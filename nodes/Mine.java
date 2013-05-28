package atra.clay.nodes;

import org.powerbot.core.script.job.state.Node;

import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.Entity;

import atra.clay.constants.Constants;

public class Mine extends Node {

	@Override
	public boolean activate() {
		
		return !Inventory.isFull() && Calculations.distanceTo(Constants.getRockTile()) <= 5;
	}

	@Override
	public void execute() {
		Entity rock = SceneEntities.getNearest(Constants.getRocks());
		Constants.setStatus("Mining rocks.");
		if (rock != null && rock.isOnScreen()) {
			if (rock.interact("Mine")) {
				for (int i = 0; i < 500 && rock != null; i++) {
					sleep(10, 20);
				}
			}
		}
	}

}

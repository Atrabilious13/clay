package atra.clay.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;

import atra.clay.constants.Constants;

public class Soften extends Node {

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return Inventory.isFull() && Calculations.distanceTo(Constants.atPump) <= 5
				&& Inventory.contains(Constants.clay);
	}

	@Override
	public void execute() {

		Constants.setStatus("Softening clay");
		
		if (!Widgets.get(1370).validate() && !Widgets.get(1251).validate()) {
			if (Inventory.isItemSelected()) {
				Constants.setStatus("Interacting with pump.");
				SceneEntities.getNearest(Constants.pump).click(true);
				for (int i = 0; i < 10000 && !Widgets.get(1370).validate(); i++) {
					sleep(25, 50);
				}
			} else {
				Constants.setStatus("Selecting clay.");
				if (Inventory.getItem(Constants.clay).getWidgetChild().interact("Use")) {
					sleep(30, 70);
				}
			}
		}
		
		if (Widgets.get(1370).validate()) {
			Constants.setStatus("Interacting with widget.");
			Widgets.get(1370).getChild(38).click(true);
			sleep(200, 500);
		}
		
		if (Widgets.get(1251).validate()) {
			for (int i = 0; i < 10000 && Widgets.get(1251).validate(); i++) {
				Constants.setStatus("Waiting for all clay to be softened.");
				sleep(30, 60);
			}
		}
	}

}

package atra.clay.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.tab.Inventory;

import atra.clay.constants.Constants;

public class WalkToRock extends Node {

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return !Inventory.isFull() && Calculations.distanceTo(Constants.atRocks) >= 6
				&& Walking.newTilePath(Constants.toRocks).validate();
	}

	@Override
	public void execute() {
		
		Constants.setStatus("Walking to rocks");
		
		if (Calculations.distanceTo(Walking.getDestination()) > 5 && Walking.newTilePath(Constants.toRocks).validate()) {
			sleep(35, 65);
		}
		
		Walking.newTilePath(Constants.toRocks).randomize(2, 2).traverse();
		sleep(200, 400);
		
	}

}

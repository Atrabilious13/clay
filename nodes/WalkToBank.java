package atra.clay.nodes;


import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.tab.Inventory;

import atra.clay.constants.Constants;

public class WalkToBank extends Node {

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return Inventory.isFull() && Inventory.contains(Constants.getSoftClay())
				&& !Inventory.contains(Constants.getClay())
				&& Calculations.distanceTo(Constants.getBankTile()) > 5
				&& Walking.newTilePath(Constants.getBankPath()).validate();
	}

	@Override
	public void execute() {
		
		Constants.setStatus("Walking to bank.");
		
		if (Calculations.distanceTo(Walking.getDestination()) > 5 && Walking.newTilePath(Constants.getBankPath()).validate()) {
			sleep(35, 65);
		}
		
		Walking.newTilePath(Constants.getBankPath()).randomize(2, 2).traverse();
		sleep(200, 400);
	}

}

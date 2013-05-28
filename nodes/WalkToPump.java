package atra.clay.nodes;


import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.tab.Inventory;


import atra.clay.constants.Constants;

public class WalkToPump extends Node {

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return Inventory.isFull() && Calculations.distanceTo(Constants.atPump) > 5
		&& Walking.newTilePath(Constants.toPump).validate() && Inventory.contains(Constants.clay);
	}

	@Override
	public void execute() {
		
		Constants.setStatus("Walking to pump.");
		
		if (Calculations.distanceTo(Walking.getDestination()) > 5 && Walking.newTilePath(Constants.toPump).validate()) {
			sleep(35, 65);
		}
		
		Walking.newTilePath(Constants.toPump).randomize(2, 2).traverse();
		sleep(200, 400);
	}

}

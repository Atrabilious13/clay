package atra.clay.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;

import atra.clay.constants.Constants;

public class Soften extends Node {

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return Inventory.isFull() && Calculations.distanceTo(Constants.getPumpTile()) <= 5
				&& Inventory.contains(Constants.getClay());
	}

	@Override
	public void execute() {

		Constants.setStatus("Softening clay");
		
		if (!Constants.getMainWidget().validate() && !Constants.getWaitWidget().validate()) {
			if (Inventory.isItemSelected()) {
				Constants.setStatus("Interacting with pump.");
				SceneEntities.getNearest(Constants.getPump()).click(true);
				for (int i = 0; i < 10000 && !Constants.getMainWidget().validate(); i++) {
					sleep(25, 50);
				}
			} else {
				Constants.setStatus("Selecting clay.");
				if (Inventory.getItem(Constants.getClay()).getWidgetChild().interact("Use")) {
					sleep(30, 70);
				}
			}
		}
		
		if (Constants.getMainWidget().validate()) {
			Constants.setStatus("Interacting with widget.");
			Constants.getWidgetButton().click(true);
			sleep(200, 500);
		}
		
		if (Constants.getWaitWidget().validate()) {
			for (int i = 0; i < 10000 && Constants.getWaitWidget().validate(); i++) {
				Constants.setStatus("Waiting for all clay to be softened.");
				sleep(30, 60);
			}
		}
	}

}

package atra.clay.nodes;


import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;

import atra.clay.constants.Constants;

public class UseBank extends Node {

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return Inventory.isFull() && Inventory.contains(Constants.softClay)
				&& !Inventory.contains(Constants.clay)
				&& Calculations.distanceTo(Constants.atBank) <= 5;
	}

	@Override
	public void execute() {
		
		Constants.setStatus("Depositting all soft clay.");
		
		if (!Bank.isOpen()) {
			if (Bank.open()) {
				for (int i = 0; i < 10000 && !Bank.isOpen(); i++) {
					sleep(20, 50);
				}
			}
		} else {
			if (Inventory.isFull()) {
				if (Bank.depositInventory()) {
					for (int i = 0; i < 1000 && Inventory.isFull(); i++) {
						sleep(30, 70);
					}
				}
			} else {
				if (Bank.close()) {
					for (int i = 0; i < 1000 && Bank.isOpen(); i++) {
						sleep(10, 20);
					}
				}
				
			}
		}
	}

}

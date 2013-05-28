package atra.clay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.powerbot.core.event.events.MessageEvent;
import org.powerbot.core.event.listeners.MessageListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.Job;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;
import org.powerbot.core.script.util.Random;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.tab.Skills;

import atra.clay.constants.Constants;
import atra.clay.nodes.Mine;
import atra.clay.nodes.Soften;
import atra.clay.nodes.UseBank;
import atra.clay.nodes.WalkToBank;
import atra.clay.nodes.WalkToPump;
import atra.clay.nodes.WalkToRock;
import atra.clay.paint.ClayPaint;
import atra.methods.SkillTracker;

@Manifest(authors = { "Atrabilious" }, description = "Mines and softens clay at Draynor", name = "Atra Clay", version = 0.1)
public class AtraClay extends ActiveScript implements MessageListener {

	public static SkillTracker mining;
	public static SkillTracker crafting;

	private final List<Node> jobsCollection = Collections
			.synchronizedList(new ArrayList<Node>());
	private Tree jobContainer = null;

	public final void submit(final Job job) {
		getContainer().submit(job);
	}

	public final void provide(final Node... jobs) {
		for (final Node job : jobs) {
			if (!jobsCollection.contains(job)) {
				jobsCollection.add(job);
			}
		}
		jobContainer = new Tree(jobsCollection.toArray(new Node[jobsCollection
				.size()]));
	}

	public void onStart() {
		Constants.setStatus("Loading up...");
		mining = new SkillTracker(Skills.MINING);
		crafting = new SkillTracker(Skills.CRAFTING);
		
		Constants.setStartTime(System.currentTimeMillis());
		provide(new Mine(), new UseBank(), new Soften(), new WalkToRock(),
				new WalkToPump(), new WalkToBank());
		
		ClayPaint.launch();

	}

	@Override
	public int loop() {
		if (jobContainer != null) {
			final Node job = jobContainer.state();
			if (job != null) {
				jobContainer.set(job);
				getContainer().submit(job);
				job.join();
			}
		}
		return Random.nextInt(20, 80);
	}

	
	@Override
	public void messageReceived(MessageEvent e) {
		switch (e.getMessage().toLowerCase()) {
		
			case "you manage to mine some clay.":
				Constants.addClayMined();
				break;
				
			case "you mix the clay and water. you now have some soft, workable clay":
				Constants.addClaySoftened();
				break;
				
			case "you found a sapphire":
				Constants.addSapphires();
				break;
				
			case "you found a emerald":
				Constants.addEmeralds();
				break;
				
			case "you found a ruby":
				Constants.addRubys();
				break;
				
			case "you found a diamond":
				Constants.addDiamonds();
				break;
		
		
		}
		
	}
}

package me.herobrine.ai.tasks;

import me.herobrine.ai.Task;
import me.herobrine.ai.TaskUnsuccessfulException;
import me.herobrine.data.Position;
import me.herobrine.world.Controller;
import me.herobrine.world.entities.Entity;

public class MoveEntityTask extends Task {

	private Entity target;
	
	public MoveEntityTask(Entity target) {
		this.target = target;
	}
	
	@Override
	public Task execute() throws TaskUnsuccessfulException {
		Position position = target.getPosition();
		
		if(Controller.getEntity().getPosition().distanceTo(position) < 3.0) {
			Controller.forward = false;
			Controller.jump = false;
			Controller.say("SUP BRO?!");
			return null;
		}
		
		Controller.forward = true;
		Controller.jump = true;
		Controller.setSprinting(true);
		Controller.lookAt(position);
		return this;
	}

	@Override
	public boolean handleException(TaskUnsuccessfulException exception) {
		return false;
	}

	@Override
	public String toString() {
		return String.format("%s { target: %s }", super.toString(), target.toString());
	}

}

package me.herobrine.ai.tasks;

import me.herobrine.ai.Task;
import me.herobrine.ai.TaskUnsuccessfulException;
import me.herobrine.data.Position;
import me.herobrine.world.Controller;

public class MoveTask extends Task {

	private Position position;
	
	public MoveTask(Position position) {
		this.position = position.clone();
	}
	
	@Override
	public Task execute() throws TaskUnsuccessfulException {
		if(Controller.getEntity().getPosition().distanceTo(position) < 1.0) {
			Controller.forward = false;
			Controller.jump = false;
			return null;
		}
		
		Controller.forward = true;
		Controller.jump = true;
		Controller.setSprinting(true);
		Controller.lookAt(position.clone().addY(1.6));
		
		return this;
	}

	@Override
	public boolean handleException(TaskUnsuccessfulException exception) {
		return false;
	}

	@Override
	public String toString() {
		return String.format("%s { position: %s }", super.toString(), position.toString());
	}
	
}

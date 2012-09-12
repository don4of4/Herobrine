package herobrine.tests;

import herobrine.ai.Task;
import herobrine.ai.TaskDelayed;
import herobrine.ai.TaskManager;
import herobrine.ai.TaskQueueDepletedException;
import herobrine.ai.TaskUnsuccessfulException;

public class TaskManagerTest {
	
	public static void main(String[] args) throws TaskQueueDepletedException, TaskUnsuccessfulException { 
		class TestTask extends Task {

			private int count;
			
			public TestTask(int count) {
				this.count = count;
			}
			
			@Override
			public Task execute() {
				count--;
				
				System.out.println(count);
				
				if(count == 0) {
					return null;
				} else if(count == 20) {
					return new TestTask(10);
				} else {
					return this;
				}
			}

			@Override
			public boolean handleException(TaskUnsuccessfulException exception) {
				return false;
			}
			
		}
		
		TaskManager.schedule(new TestTask(30));
		TaskManager.schedule(new TaskDelayed(new TestTask(5), 5000));
		while(TaskManager.hasTasks()) {
			TaskManager.processTask();
		}
	}

}

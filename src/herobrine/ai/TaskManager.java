package herobrine.ai;

import herobrine.ai.tasks.IdleTask;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class TaskManager {

	private static Stack<Task> tasks = new Stack<Task>();
	private static Stack<Task> tasksQueue = new Stack<Task>();
	private static List<TaskDelayed> delayedTasksQueue = new ArrayList<TaskDelayed>();
	
	static {
		tasks.add(new IdleTask());
	}
	
	public static void processTask() throws TaskQueueDepletedException, TaskUnsuccessfulException {
		if(!tasks.isEmpty()) {
			Task task = tasks.peek();
			Task newTask;
			try {
				newTask = task.execute();
				if(newTask != null) {
					if(newTask != task) {
						tasks.push(newTask);
					}
				} else {
					tasks.pop();
				}
			} catch (TaskUnsuccessfulException e) {
				boolean exceptionSolved = false;
				while(!exceptionSolved) {
					if(!task.handleException(e)) {
						tasks.pop();
						if(tasks.isEmpty()) {
							throw e;
						}
						task = tasks.peek();
					} else {
						exceptionSolved = true;
					}
				}
			}
		} else if(tasksQueue.isEmpty() && delayedTasksQueue.isEmpty()) {
			throw new TaskQueueDepletedException();
		}

		while(!tasksQueue.isEmpty()) {
			tasks.push(tasksQueue.pop());
		}
		
		if(!delayedTasksQueue.isEmpty()) {
			for(Iterator<TaskDelayed> iterator = delayedTasksQueue.iterator(); iterator.hasNext();) {
				TaskDelayed delayedTask = iterator.next();
				if(delayedTask.isReady()) {
					iterator.remove();
					tasks.push(delayedTask.getTask());
				}
			}
		}
	}
	
	public static void schedule(Task task) {
		tasksQueue.add(task);
	}
	
	public static void schedule(TaskDelayed task) {
		delayedTasksQueue.add(task);
		task.activate();
	}
	
	public static boolean hasTasks() {
		return !(tasks.isEmpty() && tasksQueue.isEmpty() && delayedTasksQueue.isEmpty());
	}
	
}

package TaskService;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
	//utilize Map for easy indexing, location, and removal
	private Map<String, Task> tasks;
	
	//constructor
	public TaskService() {
		this.tasks = new HashMap<>();
	}
	
	
	//add task to task service
	public void addTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("Task cannot be null");
		}
		if (tasks.containsKey(task.getTaskId())) {
			throw new IllegalArgumentException("Task with ID" + task.getTaskId() + " already exists");
		}
		tasks.put(task.getTaskId(), task);
	}
	
	//delete task method
	public void deleteTask(String taskId) {
		if (!tasks.containsKey(taskId)) {
			throw new IllegalArgumentException("Task with ID " + taskId + "not found.");
		}
		if(taskId == null) {
			throw new IllegalArgumentException("Task Id cannot be null.");
		}
		tasks.remove(taskId);	
	}
	
	//update methods
	public void updateName(String taskId, String name) {
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null.");
		}
		if (name.length() > 20) {
			throw new IllegalArgumentException("Name cannot exceed 20 characters.");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Name Required. Cannot be empty");
		}
		Task task = getTaskById(taskId);
		task.setTaskName(name);
	}
	
	public void updateDescription(String taskId, String description) {
		if (description == null) {
			throw new IllegalArgumentException("Description cannot be null.");
		}
		if (description.length() > 50) {
			throw new IllegalArgumentException("Description cannot exceed 50 characters.");
		}
		if(description.isEmpty()) {
			throw new IllegalArgumentException("Description is required. Cannot be empty");
		}
		Task task = getTaskById(taskId);
		task.setTaskDescription(description);
	}
	
	//helper function for update methods
		private Task getTaskById(String taskId) {
			if (taskId == null) {
				throw new IllegalArgumentException("Task ID cannot be null");
			}
			Task task = tasks.get(taskId);
			if (task == null) {
				throw new IllegalArgumentException("Task with ID " + taskId + " not found");
			}
			return task;
		}
		
		//helper functions for testing purposes
		public Task getTask(String taskId) {
			return tasks.get(taskId);
		}
		
		public int getTaskCount() {
			return tasks.size();
		}
}

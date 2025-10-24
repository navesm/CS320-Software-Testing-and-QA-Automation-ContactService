package TaskService;

public class Task {
	private final String taskId; //immutable
	private String name;
	private String description;
	
	//Constructor
	public Task(String taskId, String name, String description) {
		if (taskId == null || taskId.length() > 10 || taskId.isEmpty()) {
			throw new IllegalArgumentException("Invalid taskId");
		}
		if (name == null || name.length() > 20 || name.isEmpty()) {
			throw new IllegalArgumentException("Invalid task name.");
		}
		if (description == null || description.length() > 50 || description.isEmpty()) {
			throw new IllegalArgumentException("Invalid description");	
		}
		
		this.taskId = taskId;
		this.name = name;
		this.description = description;
	}
	
	// Getters
	public String getTaskId() {
		return taskId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	
	//Setters
	public void setTaskName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null.");
		}
		if (name.length() > 20) {
			throw new IllegalArgumentException("Name cannot be longer than 20 characters.");
		}
		this.name = name;
	}
	
	public void setTaskDescription(String description) {
		if (description == null) {
			throw new IllegalArgumentException("Description cannot be null.");
		}
		if (description.length() > 50) {
			throw new IllegalArgumentException("Description cannot be longer than 50 characters.");
		}
		this.description = description;
	}
	
}

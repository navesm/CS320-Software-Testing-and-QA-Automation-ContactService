package TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {
	// test TaskService creation
	private TaskService taskService;
	private Task validTask;
	
	@BeforeEach
	public void setUp() {
		taskService = new TaskService();
		validTask = new Task("123", "Write Tests", "Describe the tests");
		
		taskService.addTask(validTask);
	}
	
	
	//test adding tasks
	@Test
	public void testAddingTasks() {
		assertEquals(validTask, taskService.getTask("123"));
		assertEquals(1, taskService.getTaskCount());
	}
	
	@Test
	public void testAddDuplicate() {
		Task duplicate = new Task("123", "Write Tests", "Describe the tests");
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask(duplicate);
		});
	}
	
	@Test
	public void testAddNullTask() {
		Task task = null;
		
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask(task);
		});
	}
	
	// Test deleting tasks
	@Test
	public void testDeleteTask() {
		taskService.deleteTask("123");
		assertEquals(0, taskService.getTaskCount());
	}
	
	@Test
	public void testDeleteNonExistantTask() {
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.deleteTask("010");
		});
	}
	
	@Test
	public void testDeleteTaskWhenNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.deleteTask(null);
		});
	}
	
	
	//Test updating task fields:
	
	//Test name updates
	@Test
	public void testUpdateNameSuccess() {
		taskService.updateName("123","NewTestName");
		assertEquals("NewTestName", validTask.getName());
	}
	
	@Test
	public void testUpdateNameFailWhenNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateName("123", null);
		});
	}
	
	@Test
	public void testUpdateNameFailWhenEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateName("123","");
		});
	}
	
	@Test
	public void testUpdateNameFailWhenTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateName("123","update the name to this really very entirely too long name");
		});
	}
	
	//Test description updates
	@Test
	public void testUpdateDescriptionSuccess() {
		taskService.updateDescription("123", "This is the updated description");
		
		assertEquals("This is the updated description", validTask.getDescription());
	}
	
	@Test
	public void testUpdateDescriptionFailWhenNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateDescription("123", null);
		});
	}
	
	@Test
	public void testUpdateDescriptionFailWhenEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateDescription("123", "");
		});
	}
	
	@Test
	public void testUpdateDescriptionFailWhenTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateDescription("123", "Update the description to this really very entirely no good incredibly too long of a description please");
		});
	}
}

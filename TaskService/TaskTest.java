package TaskService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class TaskTest {
	
	//Tests for task creation and validation
	@Test
	public void testTaskCreatingSuccess() {
		//test creating a valid task
		Task task = new Task("1234567890", "Write Tests", "Write JUnit software tests");
		
		assertEquals("1234567890", task.getTaskId());
		assertEquals("Write Tests", task.getName());
		assertEquals("Write JUnit software tests", task.getDescription());
	}
	
	@Test
	public void testTaskIdTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678901", "Write Tests", "Write JUnit software tests");
		});
	}
	
	@Test
	public void testTaskIsEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("", "Write Tests", "Write JUnit software tests");
		});
	}
	
	@Test
	public void testTaskIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Write Tests", "Write JUnit software tests");
		});
	}
	
	//Tests for name validation
	@Test
	public void testNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "Write Tests and make sure this is longer than 20!", "Write software tests in JUnit");
		});
	}
	
	@Test
	public void testNameIsEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "", "Write JUnit software tests");
		});
	}
	
	@Test
	public void testNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", null, "Write JUnit software tests");
		});
	}
	
	
	//Test name setter
	@Test
	public void testNameUpdateSuccess() {
		Task task = new Task("1234567890", "Write Tests", "Write JUnit software tests");
		task.setTaskName("This is the new name");
		
		assertEquals("This is the new name", task.getName());
	}
	
	@Test
	public void testNameUpdateFailWhenNull() {
		Task task = new Task("1234567890", "Write Tests", "Write JUnit software tests");
		assertThrows(IllegalArgumentException.class, () -> {
			task.setTaskName(null);
		});
	}
	
	@Test
	public void testNameUpdateFailWhenTooLong() {
		Task task = new Task("1234567890", "Write Tests", "Write JUnit software tests");
		assertThrows(IllegalArgumentException.class, () -> {
			task.setTaskName("Write tests and make sure this update is too long!");
		});
	}
	
	//Tests for description validation
	@Test
	public void testDescriptionTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "Write Tests", "Write JUnit software tests and really make sure that you can make this string longer than 50 chars, okay?");
		});
	}
	
	@Test
	public void testDescriptionIsEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "Write Tests", "");
		});
	}
	
	@Test
	public void testDescriptionIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "Write tests", null);
		});
	}
	
	//Test description setter
	@Test
	public void testDescriptionUpdateSuccess() {
		Task task = new Task("1234567890", "Write Tests", "Write JUnit software tests");
		task.setTaskDescription("This is the new description!");
		
		assertEquals("This is the new description!", task.getDescription());
	}
	
	@Test
	public void testDescriptionUpdateFailWhenNull() {
		Task task = new Task("1234567890", "Write Tests", "Write JUnit software tests");
		
		assertThrows(IllegalArgumentException.class, ()-> {
			task.setTaskDescription(null);
		});
	}
	
	@Test
	public void testDescriptionUpdateFailWhenTooLong() {
		Task task = new Task("1234567890", "Write Tests", "Write JUnit software tests");
		
		assertThrows(IllegalArgumentException.class, ()-> {
			task.setTaskDescription("Write JUnit software tests and definitely ensure this entry is too many chars");
		});
	}
}

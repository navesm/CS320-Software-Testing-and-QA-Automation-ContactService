package AppointmentService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Calendar;


public class AppointmentTest {
	//Test appointment construction
	
	//construction success
	@Test
	public void testAppointmentSuccess() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		Date apptDate = calendar.getTime();
		
		Appointment appointment = new Appointment("12345", apptDate, "This is the valid appointment description");
		
		assertEquals("12345", appointment.getId());
		assertEquals(apptDate, appointment.getDate());
		assertEquals("This is the valid appointment description", appointment.getDescription());
	}
	
	//Id too long
	@Test
	public void testFailureIdTooLong() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		Date apptDate = calendar.getTime();
		
		assertThrows(IllegalArgumentException.class, ()-> {
			new Appointment("12345678901", apptDate, "This is a description");
		});
	}
	
	//Id Null
	@Test
	public void testFailureIdNull() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		Date apptDate = calendar.getTime();
		
		assertThrows(IllegalArgumentException.class, ()-> {
			new Appointment(null, apptDate, "This is a description");
		});
	}
	//Id empty
	@Test
	public void testFailureIdEmpty() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		Date apptDate = calendar.getTime();
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("", apptDate, "Description");
		});
	}
	
	// Date in past
	@Test
	public void testFailDateInPast() {
		 Calendar calendar = Calendar.getInstance();
	     calendar.set(2024, Calendar.OCTOBER, 15); // Set to October 15, 2024
	     Date pastDate = calendar.getTime();
	     
	     assertThrows(IllegalArgumentException.class, ()-> {
	    	 new Appointment("12345", pastDate, "Description");
	     });
	}
	
	// Date is NULL
	@Test
	public void testFailDateNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", null, "Description");
		});
	}
	
	
	//Description NULL
	@Test
	public void testFailDescriptionNull() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		Date apptDate = calendar.getTime();
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", apptDate, null );
		});
	}
	//Description empty
	@Test
	public void testFailDescriptionEmpty() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		Date apptDate = calendar.getTime();
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", apptDate, "");
		});
	}
	
	//Description > 50 char
	@Test
	public void testFailDescriptionTooLong() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		Date apptDate = calendar.getTime();
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", apptDate, "This description for the appointment really is very much too too very much too long");
		});
	}
	
	
	//Test setters
	//setDate success
	@Test
	public void testSetDate() {
		Date firstDate = new Date();
		Appointment validAppointment = new Appointment("12345", firstDate, "Description");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		Date apptDate = calendar.getTime();
		
		validAppointment.setDate(apptDate);
		
		assertEquals(apptDate, validAppointment.getDate());
	}
	
	//setDate failure NuLL
	@Test
	public void testSetDateFailWhenNull() {
		Date firstDate = new Date();
		Appointment validAppointment = new Appointment("12345", firstDate, "Description");
		
		assertThrows(IllegalArgumentException.class, () -> {
			validAppointment.setDate(null);
		});
	}
	
	//setDate failure in past
	@Test
	public void testSetDateFailWhenInPast() {
		Date firstDate = new Date();
		Appointment validAppointment = new Appointment("12345", firstDate, "Description");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -7);
		Date apptDate = calendar.getTime();
		
		assertThrows(IllegalArgumentException.class, () -> {
			validAppointment.setDate(apptDate);
		});
	}
	
	//setDescription success
	@Test
	public void testSetDescriptionSuccess() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		Date apptDate = calendar.getTime();
		
		Appointment validAppointment = new Appointment("12345", apptDate, "Description");
		validAppointment.setDescription("This is the new new description!");
		
		assertEquals("This is the new new description!", validAppointment.getDescription());
	}
	
	//setDescription failure NULL
	@Test
	public void testSetDescriptionFailWhenNull() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		Date apptDate = calendar.getTime();
		
		Appointment validAppointment = new Appointment("12345", apptDate, "Description");
		
		assertThrows(IllegalArgumentException.class, ()-> {
			validAppointment.setDescription(null);
		});
	}
	
	
	//setDescription failure empty
	@Test
	public void testSetDescriptionFailWhenEmpty() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		Date apptDate = calendar.getTime();
		
		Appointment validAppointment = new Appointment("12345", apptDate, "Description");
		
		assertThrows(IllegalArgumentException.class, ()-> {
			validAppointment.setDescription("");
		});
	}
	
	
	//setDescription failure too long (> 50 chars)
	@Test
	public void testSetDescriptionFailWhenTooLong() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		Date apptDate = calendar.getTime();
		
		Appointment validAppointment = new Appointment("12345", apptDate, "Description");
		
		assertThrows(IllegalArgumentException.class, ()-> {
			validAppointment.setDescription("This is the really very new description that is incredibly very much and entirely too long for this purpose");
		});
	}
}

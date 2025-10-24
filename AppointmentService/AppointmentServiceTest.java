package AppointmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.Calendar;

public class AppointmentServiceTest {
	private Appointment validAppointment;
	private AppointmentService appointmentService;
	
	@BeforeEach
	public void setUp() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		Date apptDate = calendar.getTime();

		appointmentService = new AppointmentService();
		validAppointment = new Appointment("12345", apptDate, "This is the valid appointment!" );
	}
	
	// test adding appts
	@Test
	public void testAddingAppointments() {
		appointmentService.addAppointment(validAppointment);
		
		assertEquals(1, appointmentService.getAppointmentCount());
		assertEquals(validAppointment, appointmentService.getAppointment("12345"));
	}
	
	//test add duplicate
	@Test
	public void testFailWhenAddingDuplicateAppointment() {
		appointmentService.addAppointment(validAppointment);
		
		assertThrows(IllegalArgumentException.class, ()-> {
			appointmentService.addAppointment(validAppointment);
		});
	}
	
	//test adding NULL appt
	@Test
	public void testFailWhenAddingNullAppointment() {
		assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.addAppointment(null);
		});
	}
	
	//test delete appt
	@Test
	public void testDeleteAppointmentSuccess() {
		appointmentService.addAppointment(validAppointment);
		
		assertEquals(1, appointmentService.getAppointmentCount());
		
		appointmentService.deleteAppointment(validAppointment.getId());
		assertEquals(0, appointmentService.getAppointmentCount());
	}
	
	//test delete NULL appt
	@Test
	public void testDeleteFailWhenNullAppointment() {
		appointmentService.addAppointment(validAppointment);
		
		assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.deleteAppointment(null);
		});
	}
	
	//test delete Nonexistent appt
	@Test
	public void testDeleteFailWhenNonexistentAppointment() {
		appointmentService.addAppointment(validAppointment);
		
		assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.deleteAppointment("67585");
		});
	}
}

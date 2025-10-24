package AppointmentService;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
	private Map<String, Appointment> appointments;
	
	//constructor
	public AppointmentService () {
		this.appointments =  new HashMap<>();
	}
	
	
	//Add appointments
	public void addAppointment(Appointment appointment) {
		
		if (appointment == null) {
			throw new IllegalArgumentException("Appointment cannot be null. Try again");
		}
		if (appointments.containsKey(appointment.getId())) {
			throw new IllegalArgumentException("Appointment already exists");
		}
		appointments.put(appointment.getId(), appointment);
	}
	
	//delete appointments
	public void deleteAppointment(String apptId) {
		if (apptId == null) {
			throw new IllegalArgumentException("Contact ID cannot be null");
		}
		if (!appointments.containsKey(apptId)) {
			throw new IllegalArgumentException("Appointment cannot be found or does not exist");
		}
		
		appointments.remove(apptId);
		
		
	}
	
	//helper functions
	public Appointment getAppointment(String apptId) {
		Appointment appointment = appointments.get(apptId);
		return appointment;
	}
	
	public int getAppointmentCount() {
		return appointments.size();
	}
}

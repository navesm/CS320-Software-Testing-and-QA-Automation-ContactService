package AppointmentService;
import java.util.Date;


public class Appointment {
	private final String apptId;
	private Date date;
	private String description;
	
	//Constructor
	public Appointment(String apptId, Date date, String description) {
		if (apptId == null || apptId.length() > 10 || apptId.isEmpty()) {
			throw new IllegalArgumentException("Invalid appointment ID");
		}
		Date now = new Date();
		if (date == null || date.before(now) ) {
			throw new IllegalArgumentException("Invalid appointment date");
		}
		if (description == null || description.length() > 50 || description.isEmpty()) {
			throw new IllegalArgumentException("Invalid appointment ID");
		}
		
		this.apptId = apptId;
		this.date = date;
		this.description = description;
		
	}
	
	// Getters
	public String getId() {
		return apptId;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getDescription() {
		return description;
	}
	
	
	//Setters
	public void setDate(Date date) {
		Date now = new Date();
		if(date == null) {
			throw new IllegalArgumentException("Appointment date cannot be null");
		}
		if (date.before(now)) {
			throw new IllegalArgumentException("Appointment Date must be in the future");
		}
		this.date = date;
	}
	
	public void setDescription(String description) {
		if(description == null) {
			throw new IllegalArgumentException("Appointment Description cannot be null");
		}
		if (description.isEmpty()) {
			throw new IllegalArgumentException("Description cannot be empty.");
		}
		if(description.length() > 50) {
			throw new IllegalArgumentException("Description is too long. Cannot exceed 50 characters");
		}
		this.description = description;
	}
}

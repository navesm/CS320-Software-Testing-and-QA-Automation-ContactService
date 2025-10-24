package ContactService;

public class Contact {
	private final String contactId; // immutable
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	//Constructor
	public Contact(String contactId, String firstName,String lastName, String phone, String address) {
		// validate all parameters
		if (contactId == null || contactId.length() > 10 || contactId.isEmpty()) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	//Getters for all fields
	public String getContactId() {
		return contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	
	//Setters for updatable fields only - all except contactID
	public void setFirstName(String firstName) {
		if (firstName == null) {
			throw new IllegalArgumentException("First name cannot be null");
		}
		if (firstName.length() > 10) {
			throw new IllegalArgumentException("First name cannot be longer than 10 characters");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null) {
			throw new IllegalArgumentException("Last name cannot be null");
		}
		if (lastName.length() > 10) {
			throw new IllegalArgumentException("Last name cannot be longer than 10 characters");
		}
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		if (phone == null) {
			throw new IllegalArgumentException("Phone cannot be null");
		}
		if (phone.length() != 10) {
			throw new IllegalArgumentException("Phone must be exactly 10 digits");
		}
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		if (address == null) {
			throw new IllegalArgumentException("Address cannot be null");
		}
		if (address.length() > 30) {
			throw new IllegalArgumentException("Addres cannot exceed 30 characters");
		}
		this.address = address;
	}
}

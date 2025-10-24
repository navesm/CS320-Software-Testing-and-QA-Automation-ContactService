package ContactService;
import java.util.HashMap;
import java.util.Map;


public class ContactService {
	private Map<String, Contact> contacts;
	
	public ContactService() {
		this.contacts = new HashMap<>();
	}
	
	public void addContact(Contact contact) {
		if (contact == null) {
			throw new IllegalArgumentException("Contact cannot be null");
		}
		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact with ID" + contact.getContactId() + " already exists");
		}
		contacts.put(contact.getContactId(), contact);
	}
	
	public void deleteContact(String contactId) {
		if (contactId == null) {
			throw new IllegalArgumentException("Conact ID cannot be null");
		}
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact with ID " + contactId + " not found");
		}
		contacts.remove(contactId);
	}
	
	public void updateFirstName(String contactId, String firstName) {
		Contact contact = getContactById(contactId);
		contact.setFirstName(firstName);
	}
	
	public void updateLastName(String contactId, String lastName) {
		Contact contact = getContactById(contactId);
		contact.setLastName(lastName);
	}
	
	public void updatePhone(String contactId, String phone) {
		Contact contact = getContactById(contactId);
		contact.setPhone(phone);
	}
	
	public void updateAddress(String contactId, String address) {
		Contact contact = getContactById(contactId);
		contact.setAddress(address);
	}
	
	//helper function for update methods
	private Contact getContactById(String contactId) {
		if (contactId == null) {
			throw new IllegalArgumentException("Contact ID cannot be null");
		}
		Contact contact = contacts.get(contactId);
		if (contact == null) {
			throw new IllegalArgumentException("contact with ID " + contactId + " not found");
		}
		return contact;
	}
	
	//helper functions for testing purposes
	public Contact getContact(String contactId) {
		return contacts.get(contactId);
	}
	
	public int getContactCount() {
		return contacts.size();
	}
}

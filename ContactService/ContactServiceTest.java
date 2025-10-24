package ContactService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


public class ContactServiceTest {
	private ContactService contactService;
	private Contact validContact;
	
	@BeforeEach
	public void setUp() {
		contactService = new ContactService();
		validContact = new Contact("123", "John", "Doey", "3331234567", "123 Main St");
	}
	
	
	//Test adding contacts
	@Test
	public void testAddingContacts() {
		contactService.addContact(validContact);
		Contact retrieved = contactService.getContact("123");
		assertNotNull(retrieved);
		assertEquals("John", retrieved.getFirstName());
		assertEquals(1, contactService.getContactCount());
	}
	
	@Test
	public void testAddDuplicate() {
		contactService.addContact(validContact);
		
		Contact duplicate = new Contact("123", "June", "Dooey", "1231234567", "123 Second St");
		assertThrows(IllegalArgumentException.class, ()-> {
			contactService.addContact(duplicate);
		});
	}
	
	@Test
	public void testAddNullContact() {
		assertThrows(IllegalArgumentException.class, ()-> {
			contactService.addContact(null);
		});
	}
	
	
	//Test deleting contacts
	@Test
	public void testDeleteContact() {
		contactService.addContact(validContact);
		assertEquals(1, contactService.getContactCount());
		
		contactService.deleteContact("123");
		assertEquals(0, contactService.getContactCount());
		assertNull(contactService.getContact("123"));
	}
	
	@Test
	public void testDeleteNonexistantContact() {
		assertThrows(IllegalArgumentException.class, ()-> {
			contactService.deleteContact("2345");
		});
	}
	
	@Test
	public void testDeleteNullContact() {
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.deleteContact(null);
		});
	}
	
	//Test updating contacts
	@Test
	public void testUpdatingFirstName() {
		contactService.addContact(validContact);
		contactService.updateFirstName("123", "Thor");
		
		Contact updated = contactService.getContact("123");
		assertEquals("Thor", updated.getFirstName());
	}
	
	@Test
	public void testUpdatingLastName() {
		contactService.addContact(validContact);
		contactService.updateLastName("123", "Robinson");
		
		Contact updated = contactService.getContact("123");
		assertEquals("Robinson", updated.getLastName());
	}
	
	@Test
	public void testUpdatingNumber() {
		contactService.addContact(validContact);
		contactService.updatePhone("123", "4561234567");
		
		Contact updated = contactService.getContact("123");
		assertEquals("4561234567", updated.getPhone());
	}
	
	@Test
	public void testUpdatingAddress() {
		contactService.addContact(validContact);
		contactService.updateAddress("123", "456 28th St NW");
		
		Contact updated = contactService.getContact("123");
		assertEquals("456 28th St NW", updated.getAddress());
	}
 	
}

package ContactService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ContactTest {
	@Test
	public void testContactCreationSuccess() {
		//test creating a valid contact 
		Contact contact = new Contact("1234567890", "John", "Doey", "3331234567", "123 Main St");
		
		assertEquals("1234567890", contact.getContactId());
		assertEquals("John", contact.getFirstName());
		assertEquals("Doey", contact.getLastName());
		assertEquals("3331234567", contact.getPhone());
		assertEquals("123 Main St", contact.getAddress());	
	}
	
	//Test contact Id validation
	@Test
	public void testContactIdTooLong() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("12345678901", "John", "Doey", "3331234567", "123 Main St");
		});
	}
	
	@Test
	public void testContactIdNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "John", "Doey", "3331234567", "123 Main St");
		});
	}
	
	@Test
    public void testContactIdEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("", "John", "Doe", "3331234567", "123 Main St");
        });
    }
	
	//Test firstName validation
	@Test
	public void testFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "JohnJohnJohn", "Doey", "3331234567", "123 Main St");
		});
	}
	
	@Test
	public void testFirstNameNull() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("123", null, "Doey", "3331234567", "123 Main St");
		});
	}
	
	// Test lastName validation
	@Test
	public void testLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("123", "John", "Doeydoeydoeydooo", "3331234567", "123 Main St");
		});
	}
	
	@Test
	public void testLastNameNull() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("123", "John", null, "3331234567", "123 Main St");
		});
	}
	
	// Test phone validation
	@Test
	public void testPhoneNotTenDigits() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("123", "John", "Doey", "33312345", "123 Main St");
		});
	}
	
	@Test
	public void testPhoneNull() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("123", "John", "Doe", null, "123 Main St");
		});
	}
	
	//Test address validation
	@Test
	public void testAddressTooLong() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("123", "John", "Doey", "3331234567", null);
		});
	}
	
	// Test setters
	@Test
	public void testSetFirstNameSuccess() {
		Contact contact = new Contact("123", "John", "Doey", "3331234567", "123 Main St");
		contact.setFirstName("Jane");
		assertEquals("Jane", contact.getFirstName());
		}
	
	@Test
	public void testSetFirstNameTooLong() {
		Contact contact = new Contact("123", "John", "Doey", "3331234567", "123 Main St");
		assertThrows(IllegalArgumentException.class, ()-> {
			contact.setFirstName("VeryLongNameNameJohnny");
		});
	}
	
	@Test
	public void testSetFirstNameNull() {
		Contact contact = new Contact("123", "John", "Doey", "3331234567", "123 Main St");
		assertThrows(IllegalArgumentException.class, ()-> {
			contact.setFirstName(null);
		});
	}
	
	//Test last name cases
	
	@Test
	public void testSetLastNameSuccess() {
		Contact contact = new Contact("123", "John", "Doey", "3331234567", "123 Main St");
		contact.setLastName("Jane");
		assertEquals("Jane", contact.getLastName());
	}
	
	@Test
	public void testSetLastNameFailWhenNull() {
		Contact contact = new Contact("123", "John", "Doey", "3331234567", "123 Main St");
		assertThrows(IllegalArgumentException.class, ()-> {
			contact.setLastName(null);
		});
	}
	
	@Test
	public void testSetLastNameFailWhenTooLong() {
		Contact contact = new Contact("123", "John", "Doey", "3331234567", "123 Main St");
		assertThrows(IllegalArgumentException.class, ()-> {
			contact.setLastName("ReallyVeryTooLongLastName");
		});
	}
	
	
	//Test phone update cases
	
	@Test
	public void testSetPhoneSuccess() {
		Contact contact = new Contact("123", "John", "Doey", "3331234567", "123 Main St");
		contact.setPhone("4561234567");
		assertEquals("4561234567", contact.getPhone());
	}
	
	@Test
	public void testSetPhoneFailWhenNull() {
		Contact contact = new Contact("123", "John", "Doey", "3331234567", "123 Main St");
		assertThrows(IllegalArgumentException.class, ()-> {
			contact.setPhone(null);
		});
	}
	
	@Test
	public void testSetPhoneFailWhenTooLong() {
		Contact contact = new Contact("123", "John", "Doey", "3331234567", "123 Main St");
		assertThrows(IllegalArgumentException.class, ()-> {
			contact.setPhone("33312345678");
		});
	}
	
	@Test
	public void testSetPhoneFailWhenTooShort() {
		Contact contact = new Contact("123", "John", "Doey", "3331234567", "123 Main St");
		assertThrows(IllegalArgumentException.class, ()-> {
			contact.setPhone("333123456");
		});
	}
	
	//Test address update cases
	@Test
	public void testSetAddressSuccess() {
		Contact contact = new Contact("123", "John", "Doey", "3331234567", "123 Main St");
		contact.setAddress("4568 Second St");
		assertEquals("4568 Second St", contact.getAddress());
	}
	
	@Test
	public void testSetAddressFailWhenNull() {
		Contact contact = new Contact("123", "John", "Doey", "3331234567", "123 Main St");
		assertThrows(IllegalArgumentException.class, ()-> {
			contact.setAddress(null);
		});
	}
	
	@Test
	public void testSetAddressFailWhenTooLong() {
		Contact contact = new Contact("123", "John", "Doey", "3331234567", "123 Main St");
		assertThrows(IllegalArgumentException.class, ()-> {
			contact.setAddress("45678989899898989898 42nd NW Main Avenue park BLVd really too long address, brother");
		});
	}
	
}

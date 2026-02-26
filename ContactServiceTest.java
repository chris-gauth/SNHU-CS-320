package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Contacts.Contact;
import Contacts.ContactService;


class ContactServiceTest {
	
	private ContactService contacts;
	
	
	// Ensures ContactService list is created before each test
	@BeforeEach
	void initiateContactService() {
		contacts = new ContactService();
	}
	
	
	/*
	 * ADD CONTACT TESTS
	 */
	@Test
	void testAddContact() {
		String c = contacts.addContact("John", "Smith", "1234567890", "123 River Run Drive 11223");
		contacts.getContact(c);
		
		assertTrue(contacts.getContact(c).getFirstName().equals("John"));
	}
	
		
	/*
	 * DELETE CONTACT TESTS
	 */
	@Test
	void testDeleteContact() {
		String c = contacts.addContact("John", "Smith", "1234567890", "123 River Run Drive 11223");
		contacts.deleteContact(c);
		
		assertNull(contacts.getContact(c));
	}
	
	@Test
	void testDeleteContact_NotFound() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contacts.deleteContact("2");
		});	
	}
	
	
	/*
	 * UPDATE CONTACT TESTS
	 */
	@Test
	void testUpdateContact() {
		String c = contacts.addContact("John", "Smith", "1234567890", "123 River Run Drive 11223");
		contacts.updateContact(c, null, "Roberts", null, null);
		
		Contact updated = contacts.getContact(c);
		
		assertTrue(updated.getContactId().equals(c));
		assertTrue(updated.getFirstName().equals("John"));
		assertTrue(updated.getLastName().equals("Roberts"));
		assertTrue(updated.getPhoneNumber().equals("1234567890"));
		assertTrue(updated.getAddress().equals("123 River Run Drive 11223"));
	}
}

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Contacts.Contact;

class ContactTest {
	
	
	/*
	 * Constructor Test
	 */
	@Test
	void testContact() {
		Contact contact = new Contact("3", "John", "Smith", "1234567890", "123 River Run Drive 11223");
		assertTrue(contact.getContactId().equals("3"));
		assertTrue(contact.getFirstName().equals("John"));
		assertTrue(contact.getLastName().equals("Smith"));
		assertTrue(contact.getPhoneNumber().equals("1234567890"));
		assertTrue(contact.getAddress().equals("123 River Run Drive 11223"));
	}
	
	/*
	 * --- Individual parameter testing below. Each test for NULL and TooLong parameters --- 
	 */
	
	
	/*
	 * ID TESTS
	 */
	@Test
	void testNullcontactId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "John", "Smith", "1234567890", "123 River Run Drive 11223");
		});	}
	
	@Test
	void testTooLongcontactId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789123456", "John", "Smith", "1234567890", "123 River Run Drive 11223");
		});	}
	
	
	/*
	 * FIRST NAME TESTS
	 */
	@Test 
	void testNullfirstName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("3", null, "Smith", "1234567890", "123 River Run Drive 11223");
		});	}
	
	@Test
	void testTooLongfirstName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("3", "Johnsnameistoolong", "Smith", "1234567890", "123 River Run Drive 11223");
		});	}
	
	
	/*
	 * LAST NAME TESTS
	 */	
	@Test 
	void testNulllastName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("3", "John", null, "1234567890", "123 River Run Drive 11223");
		});	}
	
	@Test
	void testTooLonglastName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("3", "John", "Smithsnameistoolong", "1234567890", "123 River Run Drive 11223");
		});	}
	
	
	/*
	 * PHONE NUMBER TESTS
	 */
	@Test 
	void testNullphoneNumber() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("3", "John", "Smith", null, "123 River Run Drive 11223");
		});	}
	@Test 
	void testTooLongphoneNumber() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("3", "John", "Smith", "123456789123456", "123 River Run Drive 11223");
		});	}
	
	
	/*
	 * ADDRESS TESTS
	 */
	@Test 
	void testNulladdress() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("3", "John", "Smith", "1234567890", null);
		});	}
	@Test 
	void testTooLongaddress() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("3", "John", "Smith", "1234567890", "This address will be more than 30 characters if I keep typing....");
		});	}	
}

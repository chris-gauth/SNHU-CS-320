package Contacts;

import java.util.HashMap;
import java.util.Map;



public class ContactService{
	
	// Stores Contacts in memory.
	private final Map<String, Contact> contacts = new HashMap<>();
	
	private int contactIdNumber = 0; // Ensures a unique ID (see addContact)
	
	
	public String addContact(String firstName, String lastName, String phoneNumber, String address) {
		String id = Integer.toString(contactIdNumber++); // Adds 1 to contactIdNumber to ensure unique ID is created.
						
		Contact contact = new Contact(id, firstName, lastName, phoneNumber, address); // Creates new contact with unique ID.
		
		contacts.put(id, contact); // Adds contact to map.
		
		return id;
	}
	
	
	public void deleteContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact not found: " + contactId);
		}
		contacts.remove(contactId);
	}
	
	
	public void updateContact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
		
		Contact old = contacts.get(contactId); //Copies contact
		
		
		// Conditional logic to accept only changed fields while keeping untouched fields.
		String newFirstName = (firstName != null) ? firstName : old.getFirstName();
		String newLastName = (lastName != null) ? lastName : old.getLastName();
		String newPhoneNumber = (phoneNumber != null) ? phoneNumber : old.getPhoneNumber();
		String newAddress = (address != null) ? address : old.getAddress();
		
		Contact updated = new Contact(contactId, newFirstName, newLastName, newPhoneNumber, newAddress);
		contacts.put(contactId, updated);
		
	}

	
	public Contact getContact(String contactId) {
		return contacts.get(contactId);
	}	
}

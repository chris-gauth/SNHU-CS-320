package Contacts;

public class Contact {
	
	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	
	//Contact constructor
	public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
		if (contactId == null || contactId.length()> 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if (firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid First Name (length is null or more than 10 characters.");
		}
		
		if (lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid Last Name (length is null or more than 10 characters.");
		}
		
		if (phoneNumber == null || phoneNumber.length() != 10) {
			throw new IllegalArgumentException("Phone number must only contain 10 digets");
		}
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Address cannot be null or more than 30 characters");
		}
				
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	
	public String getContactId() {
		return contactId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}
		

}

package com.mcnaney.testing.module3.assignment;
import java.util.Map;
import java.util.HashMap;


public class ContactService {
	
	//To hold list of contacts
	private Map<String, Contact> contactList = new HashMap<>();
	
	//Adds contact if not null, and Id is unique and not null. 
	public void addContact(Contact contact) {
		
		if (contact == null) {
			throw new IllegalArgumentException("Contact must not be null");
		}
		
		if (contact.getId() == null) {
			throw new IllegalArgumentException("Id must not be null");
		}
		
		if (contactList.containsKey(contact.getId())){
			throw new IllegalArgumentException("Id must be unique");
		}
		else {
			contactList.put(contact.getId(), contact);
		}

	}
	
	//Delete contact unless id is null, or contact is not found. (Based on provided id)
	public void deleteContact(String id) {
		
		if (id == null) {
			throw new IllegalArgumentException("Id is null");
		}
		if (contactList.containsKey(id)) {
			contactList.remove(id);
		}
		else {
			throw new IllegalArgumentException("Contact not found");
		}
	}
	
	//Returns a contact by a specified contact id, throws if id is null, or contact not found. 
	public Contact getContact(String id) {
		if (id == null) {
			throw new IllegalArgumentException("Contact Id must not be null");
		}
		if (!contactList.containsKey(id)) {
			throw new IllegalArgumentException("Contact Id not found");
		}
		Contact contact = contactList.get(id);
		return contact;
	}
	
	//Updates first name
	public void updateContactFirstName(String id, String first) {
		if (id == null) {
			throw new IllegalArgumentException("Contact Id must not be null");
		}
		Contact contact = getContact(id);
		contact.setFirstName(first);
	}
	
	//Updates Last name
	public void updateContactLastName(String id, String lastName) {
		if (id == null) {
			throw new IllegalArgumentException("Contact Id must not be null");
		}
		
		Contact contact = getContact(id);
		contact.setLastName(lastName);
	}

	//Updates phone number
	public void updateContactPhone(String id, String number) {
		if (id == null) {
			throw new IllegalArgumentException("Contact Id must not be null");
		}
		
		Contact contact = getContact(id);
		contact.setPhoneNumber(number);
	}

	//Updates address
	public void updateContacAddresst(String id, String address) {
		if (id == null) {
			throw new IllegalArgumentException("Contact Id must not be null");
		}
		
		Contact contact = getContact(id);
		contact.setAddress(address);
	}
}










































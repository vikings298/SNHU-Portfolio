package com.mcnaney.testing.module3.assignment;

public class Contact {
	
	//Class variables for Contact
	private final String id;
	private String firstName = "";
	private String lastName = "";
	private String phoneNumber = "";
	private String address = "";
	
	//Constructor checks for non-null values, and appropriate String lengths. Throws exception if argument doesn't meet requirements. 
	public Contact(String userId, String firstName, String lastName, String phoneNumber, String address) {
		
		//Input validation throws exception if validation fails. 
		if (userId == null || userId.length() > 10) {
			throw new IllegalArgumentException("Invalid Id");
		}
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		
		if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
		    throw new IllegalArgumentException("Invalid phone number");
		}


		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		
		//Create contact with provided values. 
		id = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		
	}
	
	//Public getter methods
	public String getId() { return id; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getPhoneNumber() { return phoneNumber; }
	public String getAddress() { return address; }
	
	///Public setter methods, called from ContactService. Methods implement input validation logic. 
	public void setFirstName(String name) {
		if (name == null || name.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		firstName = name;
	}
	public void setLastName(String name){
		if (name == null || name.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		lastName = name;
	}
	public void setPhoneNumber(String phone){
	    if (phone == null || !phone.matches("\\d{10}")) {
	        throw new IllegalArgumentException("Invalid phone number");
	    }
	    phoneNumber = phone;
	}

	public void setAddress(String addy) {
		if (addy == null || addy.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		address = addy;
	}

}

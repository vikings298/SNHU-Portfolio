package com.mcnaney.testing.module3.assignment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;



public class ContactTest {
	
	@Test
	void testContact() {
		Contact contact = new Contact("bigMac", "Mitchell", "McNaney", "4034344344", "83 Krusty Krab Lane");
		Assertions.assertEquals("bigMac", contact.getId());
		Assertions.assertEquals("Mitchell", contact.getFirstName());
		Assertions.assertEquals("McNaney", contact.getLastName());
		Assertions.assertEquals("4034344344", contact.getPhoneNumber());
		Assertions.assertEquals("83 Krusty Krab Lane", contact.getAddress());
	}
	
	//Too long tests
	@Test
	void testContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("bigMacFan23", "Mitchell", "McNaney", "4034344344", "83 Krusty Krab Lane");
		});
	}
	
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("bigMacFan", "Mitchelllllllllllll", "McNaney", "4034344344", "83 Krusty Krab Lane");
		});
	}
	
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("bigMacFan", "Mitchell", "McNaneyyyyyyy", "4034344344", "83 Krusty Krab Lane");
		});
	}
	
	@Test
	void testContactPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("bigMacFan", "Mitchell", "McNaney", "403434434444444", "83 Krusty Krab Lane");
		});
	}
	
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("bigMacFan", "Mitchell", "McNaney", "4034344344", "83 Krusty Krab Laneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		});
	}
	
	
	//Null Tests
	@Test
	void testContactIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact(null, "Mitchell", "McNaney", "4034344344", "83 Krusty Krab Lane");
		});
	}
	
	@Test
	void testContactFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("bigMacFan", null, "McNaney", "4034344344", "83 Krusty Krab Lane");
		});
	}
	
	@Test
	void testContactLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("bigMacFan", "Mitchell", null, "4034344344", "83 Krusty Krab Lane");
		});
	}
	
	@Test
	void testContactPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("bigMacFan", "Mitchell", "McNaney", null, "83 Krusty Krab Lane");
		});
	}
	
	@Test
	void testContactAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("bigMacFan", "Mitchell", "McNaney", "4034344344", null);
		});
	}
	
	//For non-digits in phone number
	@Test
	void testContactPhoneNotDigits() {
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("bigMacFan2", "Mitchell", "McNaney", "40343abc44", "83 Krusty Krab Lane");
	    });
	}

	

}
























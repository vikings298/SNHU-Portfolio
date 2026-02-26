package com.mcnaney.testing.module3.assignment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

	
	//Test contact success
    @Test
    void testAddContactSuccess() {
        ContactService service = new ContactService();
        Contact c = new Contact("bigMac", "Mitchell", "McNaney", "4034344344", "83 Krusty Krab Lane");

        service.addContact(c);

        Contact fetched = service.getContact("bigMac");
        Assertions.assertEquals("bigMac", fetched.getId());
    }

    //Duplicate Id test
    @Test
    void testAddContactDuplicateIdThrows() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("bigMac", "Mitchell", "McNaney", "4034344344", "83 Krusty Krab Lane");
        Contact c2 = new Contact("bigMac", "John", "Doe", "1234567890", "1 Main St");

        service.addContact(c1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(c2);
        });
    }

    //Delete success test
    @Test
    void testDeleteContactSuccess() {
        ContactService service = new ContactService();
        Contact c = new Contact("bigMac", "Mitchell", "McNaney", "4034344344", "83 Krusty Krab Lane");
        service.addContact(c);

        service.deleteContact("bigMac");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.getContact("bigMac");
        });
    }
    
    //No contact found test
    @Test
    void testDeleteContactNotFoundThrows() {
        ContactService service = new ContactService();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("doesNotExist");
        });
    }

  //Update success test
    @Test
    void testUpdateContactSuccess() {
        ContactService service = new ContactService();
        Contact c = new Contact("bigMac", "Mitchell", "McNaney", "4034344344", "83 Krusty Krab Lane");
        service.addContact(c);

        service.updateContactFirstName("bigMac", "Mike");
        service.updateContactLastName("bigMac", "Naney");
        service.updateContactPhone("bigMac", "1112223333");
        service.updateContacAddresst("bigMac", "99 New Address");

        Contact updated = service.getContact("bigMac");
        Assertions.assertEquals("Mike", updated.getFirstName());
        Assertions.assertEquals("Naney", updated.getLastName());
        Assertions.assertEquals("1112223333", updated.getPhoneNumber());
        Assertions.assertEquals("99 New Address", updated.getAddress());
    }

    //No contact found test (first name update)
    @Test
    void testUpdateContactIdNotFoundThrows() {
        ContactService service = new ContactService();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.updateContactFirstName("missing", "Mike");
        });
    }

    //Invalid data throws via delegation to contact (phone update) 
    //Only testing the one update method as other setters for contact have been tested, only wanting to test service layer behavior. 
    @Test
    void testUpdateContactInvalidPhoneThrows() {
        ContactService service = new ContactService();
        Contact c = new Contact("bigMac", "Mitchell", "McNaney", "4034344344", "83 Krusty Krab Lane");
        service.addContact(c);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.updateContactPhone("bigMac", "abc");
        });
    }
    
    //Test update with null id
    @Test
    void testUpdateContactNullIdThrows() {
    	ContactService service = new ContactService();
    	Contact c = new Contact("bigMac", "Mitchell", "McNaney", "4023512254", "23 toadstool");
    	service.addContact(c);
    	
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		service.updateContactFirstName(null,  "mitchell");
    	});
    }
    
    
    //Null id throws test
    @Test
    void testGetContactNullIdThrows() {
        ContactService service = new ContactService();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.getContact(null);
        });
    }
    
    //Add contact throws test for null contact
    @Test
    void testAddContactNullThrows() {
        ContactService service = new ContactService();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(null);
        });
    }

    //Delete throws test for null contact
    @Test
    void testDeleteContactNullThrows() {
        ContactService service = new ContactService();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact(null);
        });
    }
}

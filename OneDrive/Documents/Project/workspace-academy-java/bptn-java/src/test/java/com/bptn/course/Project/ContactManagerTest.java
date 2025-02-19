package com.bptn.course.Project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;


public class ContactManagerTest {
	
	public ContactManager manager = new ContactManager();
	
	
	@Test
	
	void testAddContact_IfValidPhoneNumber() {
		manager.addContact("John Doe", 1234567890, "john@example.com", Arrays.asList("Friend"));
		
		assertEquals(1, manager.getContactSize());
		assertEquals("John Doe", manager.getContactByName("John Doe").getName());
	}
	
	@Test
	void testAddContact_IfNotValidPhoneNumber()	{
		manager.addContact("John Doe", 1234, "john@example.com", Arrays.asList("Friend"));
		
		assertEquals(0, manager.getContactSize());
		
	}
	
	@Test
    void testUpdateExistingContact() {
		//Setup
		manager.addContact("Yonatan", 1234567890, "yonatan@example.com", Arrays.asList("Client"));
		
        manager.updateContact("Yonatan", "Simon", 2345678901L, "simon@mail.com", Arrays.asList("Friend"));

        Contact updatedContact = manager.getContactByName("Simon");
		//Tests
        assertEquals("Simon", updatedContact.getName());
        assertEquals(2345678901L, updatedContact.getPhoneNumber());
        assertEquals("simon@mail.com", updatedContact.getEmail());
        assertEquals(Arrays.asList("Friend"), updatedContact.getCategories());
		//Tear down
        manager.deleteContact("Simon");
    }
	
	@Test
	void testUpdateContactWithInvalidPhoneNumber() {
		//Setup
		manager.addContact("Yonatan", 1234567890, "yonatan@example.com", Arrays.asList("Client"));
		
		manager.updateContact("Yonatan", "Simon", 12345, "simon@mail.com", Arrays.asList("Friend"));
		
		Contact updatedContact = manager.getContactByName("Yonatan");
		//Tests
		assertEquals("Yonatan", updatedContact.getName());
		assertEquals(1234567890, updatedContact.getPhoneNumber());
		//Teardown
		manager.deleteContact("Yonatan");
	}
	
	@Test
	void testUpdateContactWithNonExistingContact() {
		
		//Setup
		assertEquals(0,manager.getContactSize());
		
		manager.updateContact("Yonatan", "Simon", 12345, "simon@mail.com", Arrays.asList("Friend"));

		//Tests
		assertEquals(0,manager.getContactSize());;
		//Teardown
	}

}

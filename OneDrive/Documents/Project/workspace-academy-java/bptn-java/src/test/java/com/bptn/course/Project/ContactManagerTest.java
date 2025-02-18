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

}

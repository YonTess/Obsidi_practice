package com.bptn.course.Project;

import java.util.*;


public class ContactManager {
    private List<Contact> contacts;
    Scanner scanner = new Scanner(System.in);
    public ContactManager() {
        contacts = new ArrayList<>();
    }

    // Add a new contact
    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }
    
    // List all contacts
    public void listContact() {
    	for (Contact contact : contacts) {
    		System.out.println(contact);
    	}
    }
    
    //update contact
    public void updateContact(String name, String newPhoneNumber, String newEmail, String newCategory) {
    	for (Contact contact : contacts) {
    		if (contact.getName().equalsIgnoreCase(name)) {
    			contact.setPhoneNumber(newPhoneNumber);
    			contact.setEmail(newEmail);
    			contact.setCategory(newCategory);
    			System.out.println("Contact Update Successful!");
    			return;
    		}
    	}
    	System.out.println("Update unsuccessful!");
    }
    
    public void deleteContact(String name) {
    	Iterator<Contact> iterator = contacts.iterator();
    	while(iterator.hasNext()) {
    		Contact contact = iterator.next();
    		if (contact.getName().equalsIgnoreCase(name)) {
    			iterator.remove();
    			System.out.println("Contact deleted successfully!");
    			return;
    		}
    	}
    	System.out.println("contact not found");
    }
    
    public void search(String criteria) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(criteria.toLowerCase()) ||
            	contact.getEmail().toLowerCase().contains(criteria.toLowerCase()) ||
            	contact.getPhoneNumber().contains(criteria)) {
                System.out.println(contact);
                found = true;
            }
        }
        if (!found) System.out.println("No matching contacts found.");
    }
}


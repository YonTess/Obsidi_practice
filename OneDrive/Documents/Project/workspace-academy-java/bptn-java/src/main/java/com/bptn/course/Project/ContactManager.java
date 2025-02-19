package com.bptn.course.Project;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import com.diogonunes.jcolor.Ansi; // Importing Ansi for colored console output
import com.diogonunes.jcolor.Attribute; // Importing Attribute for text attributes
import static com.diogonunes.jcolor.Ansi.*; // Importing static members of Ansi for easier access
import static com.diogonunes.jcolor.Attribute.*; // Importing static members of Attribute for easier
import com.diogonunes.jcolor.AnsiFormat;
// ContactManager class manages contact operations such as adding, updating, deleting, searching, grouping, sorting, exporting and importing contacts.

public class ContactManager {
	static AnsiFormat fInfo = new AnsiFormat(CYAN_TEXT());
    static AnsiFormat fError = new AnsiFormat(YELLOW_TEXT(), RED_BACK());
    static AnsiFormat fSucess = new AnsiFormat(GREEN_TEXT());
    
	// List to store contacts
    private List<Contact> contacts = new ArrayList<>();  // Stores contact list
    Scanner scanner = new Scanner(System.in);
    
    // Validating phone number is 10 digits long
    private boolean isValidPhone(long phoneNumber) {
    	return phoneNumber >= 1000000000L && phoneNumber <= 9999999999L;
    }

    // Adds a new contact to the list after validating the phone number
    public void addContact(String name, long phoneNumber, String email, List<String> categories) {
    	
    	if (!isValidPhone(phoneNumber)) {
    		System.out.println(fError.format("Error: Enter a 10 digit phone number"));
    		return;
    	}
        contacts.add(new Contact(name, phoneNumber, email, categories));
        System.out.println(fSucess.format("Contact added successfully!"));
    }
    
    // Lists all contacts stored in the list
    public void listContact() {
    	
    	if (contacts.isEmpty()) {
    		System.out.println(fError.format("No contacts available!"));
    	} else {
    		for (Contact c : contacts) {
        		System.out.println(c);
        	}
    	}
    	
    }
    
    // Updates an existing contact based on the name provided
    public void updateContact(String name, String newName, long newPhoneNumber, String newEmail, List<String> newCategories) {
    	for (Contact c : contacts) {
    		
    		if (c.getName().equalsIgnoreCase(name)) { 
    			if (!isValidPhone(newPhoneNumber)) {
    				System.out.println(fError.format("Error: Enter a 10 digit phone number"));
    				return;
    			}
    			
    			c.setName(newName);
    			c.setPhoneNumber(newPhoneNumber);
    			c.setEmail(newEmail);
    			c.setCategories(newCategories);
    			System.out.println(fSucess.format("Contact Update Successful!"));
    			return;
    		}
    	}
    	System.out.println(fError.format("Contact not found."));
    }

    // Retrieves a contact by name
	public Contact getContactByName(String name) {
		for (Contact c : contacts) {
			if (c.getName().equalsIgnoreCase(name)) {
				return c;
			}
		}
		return null;
	}
	
	// Retrieves the total number of contacts stored in the list.
	public int getContactSize() {
		return contacts.size();
	}
    
	// Deletes a contact based on its name.
    public void deleteContact(String delName) {
    	
    	boolean removed = false;
    	Iterator<Contact> iterator = contacts.iterator();

    	while(iterator.hasNext()) {
    		Contact c = iterator.next();
    		if (c.getName().equalsIgnoreCase(delName)) {
    			iterator.remove();
    			removed = true;
    			
    			System.out.println(fSucess.format("Contact deleted successfully!"));
    			return;
    		}
    	}
    	System.out.println(fError.format("contact not found"));
    }
    
    // Searches for contacts by name, email, or phone number
    public void search(String criteria) {
        boolean found = false;
        for (Contact c : contacts) {
        	
        	// Check if the criteria is found in the name, email, or phone (converted to string).
            if (c.getName().toLowerCase().contains(criteria.toLowerCase()) ||
            	c.getEmail().toLowerCase().contains(criteria.toLowerCase()) ||
            	String.valueOf(c.getPhoneNumber()).contains(criteria)) {
                System.out.println(c);
                found = true;
            }
        }
        if (!found) {
        	System.out.println(fError.format("No matching contacts found."));
        }
    }

    // Sorts contacts by name in ascending order
	public void sortByName() {
		if (contacts.isEmpty()) {
			System.out.println(fSucess.format("Contact list empty!"));
			return;
		}
		// Create a TreeSet with our custom comparator.
		TreeSet<Contact> sortedContacts = new TreeSet<>(new ContactNameComparator());
		
		sortedContacts.addAll(contacts);
		
		// Clear the original list and add the sorted contacts back into it.
		
		contacts.clear();
		contacts.addAll(sortedContacts);
		System.out.println(fSucess.format("Contacts sorted by name."));
	}
	
	// Groups contacts by their assigned categories.
	public void groupByCategory() {
		Map<String, List<Contact>> map = new HashMap<>();
		
		// For each contact, add it to the corresponding category group(s)
		
		for (Contact c : contacts) {
			for (String category : c.getCategories()) {
				if (!map.containsKey(category)) {
					map.put(category, new ArrayList<>());
				}
				map.get(category).add(c);
			}
		}
		System.out.println("Contacts grouped by category:");
		for (Map.Entry<String, List<Contact>> entry : map.entrySet()) {
			System.out.println("Category: " + entry.getKey());
			for (Contact c : entry.getValue()) {
				System.out.println(c);
			}
		}
	}
	
	// Exports contacts to a CSV file.
	public void exportCSV(String exportPath) {
		try (PrintWriter writer = new PrintWriter(new File(exportPath))) {
			StringBuilder sb = new StringBuilder();
			sb.append("Name,Phone Number,Email,Categories\n");
			for (Contact c : contacts) {
				sb.append(c.getName()).append(",");
				sb.append(c.getPhoneNumber()).append(",");
				sb.append(c.getEmail()).append(",");
				sb.append(String.join(";", c.getCategories())).append("\n");
			}
			writer.write(sb.toString());
			System.out.println(fSucess.format("Contacts exported successfully to ") + exportPath);
		} catch (FileNotFoundException e) {
			System.out.println(fError.format("Error: Unable to export contacts. ") + e.getMessage());
		}
	}
	
	// Imports contacts from a CSV file.
	public void importCSV(String importPath) {
		try (Scanner scanner = new Scanner(new File(importPath))) {
			// Skip the header line
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parts = line.split(",");
				String name = parts[0];
				long phoneNumber = Long.parseLong(parts[1]);
				String email = parts[2];
				List<String> categories = Arrays.asList(parts[3].split(";"));
				contacts.add(new Contact(name, phoneNumber, email, categories));
			}
			System.out.println(fSucess.format("Contacts imported successfully from ") + importPath);
		} catch (FileNotFoundException e) {
			System.out.println(fError.format("Error: Unable to import contacts. ")+ e.getMessage());
		}
	}
}
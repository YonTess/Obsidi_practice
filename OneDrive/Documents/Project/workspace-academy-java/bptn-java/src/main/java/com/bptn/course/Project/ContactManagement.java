package com.bptn.course.Project;

import java.util.*;

//ContactManagement class provides a console-based contact management system.
public class ContactManagement {
	
	// Prompts the user to choose categories for a contact.
	public static List<String> chooseCategories(Scanner scanner) {
		List<String> categories = new ArrayList<>();
		
		// Display predefined category options to the user
		
		System.out.println("Select categories (separate multiple choices with commas):");
     System.out.println("1. Client");
     System.out.println("2. Vendor");
     System.out.println("3. Family");
     System.out.println("4. Friend");
     System.out.println("5. Favorite");
     System.out.print("Your choice(s): ");
     
     String input = scanner.nextLine();
     
  // Validate user input
     while(!validateInput(input)) {
     	System.out.println("Enter a valid choice (1-5)");
     	input = scanner.nextLine();
     }
     
  // Split input into tokens and map to category names
     String[] tokens = input.split(",");
     for (String token : tokens) {
     	token = token.trim();
     	
     	// Map the user's numeric input to the corresponding category name	
     	switch (token) {
         case "1":
             categories.add("Client");
             break;
         case "2":
             categories.add("Vendor");
             break;
         case "3":
             categories.add("Family");
             break;
         case "4":
             categories.add("Friend");
             break;
         case "5":
             categories.add("Favorite");
             break;
         default:
             System.out.println("Invalid category option: " + token);
     	}
     }
     
     return categories;
	}
	
	// Validates that the user input consists only of valid category numbers (1-5).
	private static boolean validateInput(String input) {
		String[] tokens = input.split(",");
		for (String token : tokens) {
     	token = token.trim();
     	if (!isValidInt(token)) {
     		System.out.println("Invalid choice. Category will not be set.");
     		return false;  // input = scanner.nextLine();
     	}
     }
		return true;
	}

	// Checks if a given string represents a valid integer.
	private static boolean isValidInt(String choiceString) {

		
		try {
			int choice = Integer.parseInt(choiceString);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// The main method provides a menu-driven interface for contact management.
 public static void main(String[] args) {
 	ContactManager manager = new ContactManager();
     ContactHelper helper = new ContactHelper();
 	
     Scanner scanner = new Scanner(System.in);
     
     int choice;
     
     
  // Do-while loop to keep displaying the menu until the user selects exit        
     do {
     	System.out.println("\nPlease choose a feature:");
         System.out.println("1. Add Contact");
         System.out.println("2. List Contacts");
         System.out.println("3. Update Contact");
         System.out.println("4. Delete Contact");
         System.out.println("5. Search Contacts");
         System.out.println("6. Sort Contacts by Name");
         System.out.println("7. Group Contacts by Category");
         System.out.println("8. Export Contacts to CSV");
         System.out.println("9. Import Contacts from CSV");

         System.out.println("0. Exit");
         System.out.print("Enter your choice: ");
     	
         String choiceString = scanner.nextLine();    // Consume the newline character
         
      // Validate that input is a valid integer choice
         while (!isValidInt(choiceString)) {
             System.out.println("Invalid choice format! Please enter a valid an integer choice:");
             choiceString = scanner.nextLine();
         }
         
      // Convert the validated string input to an integer
         choice = Integer.parseInt(choiceString);
         
      // Process user choice using a switch-case
         switch (choice) {
             case 1:
             	// Add a new contact.
             	
             	String name = helper.getName(scanner);
                 long phone = helper.getPhone(scanner);
                 String email = helper.getEmail(scanner);

              // Prompt for category selection.
                 List<String> categories = chooseCategories(scanner);
                 manager.addContact(name, phone, email, categories);
                 break;
              
             case 2:
             	// List all contacts
             	manager.listContact();
             	break;
             	
             case 3:
             	// Update an existing contact.
             	System.out.print("Enter the name of the contact to update: ");
                 String oldName = scanner.nextLine();
                 Contact contact = manager.getContactByName(oldName);
                 
              // Check if the contact exists before updating
                 if (contact == null) {
                     System.out.println("Contact not found.");
                     break;
                 }
                 
              // Prompt user for updated details
                 String newName = helper.getNewName(scanner, contact);
                 String newEmail = helper.getNewEmail(scanner, contact);
                 Long newPhone = helper.getPhone(scanner,contact);
                 
                 // Prompt for new category selection.
                 List<String> newCategories = chooseCategories(scanner);
                 manager.updateContact(oldName, newName, newPhone, newEmail, newCategories);
                 break;
             case 4:
                 // Delete a contact.
                 System.out.print("Enter the name of the contact to delete: ");
                 String delName = scanner.nextLine();
                 manager.deleteContact(delName);
                 break;
             case 5:
             	// Search for contacts based on user input
                 System.out.print("Enter search criteria: ");
                 String criteria = scanner.nextLine();
                 manager.search(criteria);
                 break;
             case 6:
             	// Sort contacts alphabetically by name
             	manager.sortByName();
                 break;
            case 7:
         	// Group contacts by their assigned categories
            		manager.groupByCategory();
            		break;
            case 8:
                // Export contacts to a CSV file.
                System.out.print("Enter export file path: ");
                String exportPath = scanner.nextLine();
                manager.exportCSV(exportPath);
                break;
            case 9:
                // Import contacts from a CSV file.
                System.out.print("Enter import file path: ");
                String importPath = scanner.nextLine();
                manager.importCSV(importPath);
                break;
             case 0:
                 // Exit the application.
                 System.out.println("Exiting...");
                 break;
             default:
                 // Handle an invalid menu option.
                 System.out.println("Invalid choice. Please try again.");
         }    
         
     } while (choice != 0); // Continue looping until the user chooses to exit.
     
     scanner.close();
         
 }


}
     
         
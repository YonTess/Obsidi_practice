package com.bptn.course.Project;

import java.util.*;
import com.diogonunes.jcolor.Ansi; // Importing Ansi for colored console output
import com.diogonunes.jcolor.Attribute; // Importing Attribute for text attributes
import static com.diogonunes.jcolor.Ansi.*; // Importing static members of Ansi for easier access
import static com.diogonunes.jcolor.Attribute.*; // Importing static members of Attribute for easier
import com.diogonunes.jcolor.AnsiFormat;


//ContactManagement class provides a console-based contact management system.
public class ContactManagementApp {
	static AnsiFormat fInfo = new AnsiFormat(CYAN_TEXT());
    static AnsiFormat fError = new AnsiFormat(YELLOW_TEXT(), RED_BACK());
	// Prompts the user to choose categories for a contact.
	public static List<String> chooseCategories(Scanner scanner) {
		List<String> categories = new ArrayList<>();
		
		
		// Display predefined category options to the user
		
		 System.out.println(fInfo.format("Select categories (separate multiple choices with commas):"));
	     System.out.println("1. Client");
	     System.out.println("2. Vendor");
	     System.out.println("3. Family");
	     System.out.println("4. Friend");
	     System.out.println("5. Favorite");
     
     String input = ContactHelper.promptInput(scanner, "Your choice(s): ");
     
  // Validate user input
     while(!validateInput(input)) {
     	input = ContactHelper.promptOnErrorInput(scanner, "Enter a valid choice (1-5)");
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
             System.out.println(fError.format("Invalid category option: ") + token);
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
     		System.out.println(fError.format("Invalid choice. Category will not be set."));
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
     	printMenu();
     	
         String choiceString = ContactHelper.promptInput(scanner,"Enter your choice: ");    // Consume the newline character
         
      // Validate that input is a valid integer choice
         while (!isValidInt(choiceString)) {
             choiceString = ContactHelper.promptOnErrorInput(scanner, "Invalid choice format! Please enter a valid an integer choice:" );
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
				    String oldName = ContactHelper.promptInput(scanner, "Enter the name of the contact to update: ");
                 Contact contact = manager.getContactByName(oldName);
                 
              // Check if the contact exists before updating
                 if (contact == null) {
                     System.out.println(fError.format("Contact not found."));
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
                 String delName = ContactHelper.promptInput(scanner, "Enter the name of the contact to delete: ");
                 manager.deleteContact(delName);
                 break;
             case 5:
             	// Search for contacts based on user input
                 String criteria = ContactHelper.promptInput(scanner,"Enter search criteria: ");
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
                String exportPath = ContactHelper.promptInput(scanner, "Enter export file path: ");
                manager.exportCSV(exportPath);
                break;
            case 9:
                // Import contacts from a CSV file.
                String importPath = ContactHelper.promptInput(scanner, "Enter import file path: ");
                manager.importCSV(importPath);
                break;
             case 0:
                 // Exit the application.
                 System.out.println(colorize("Exiting...", RED_TEXT(), BOLD()));
                 break;
             default:
                 // Handle an invalid menu option.
                 System.out.println(fError.format("Invalid choice. Please try again."));
         }    
         
     } while (choice != 0); // Continue looping until the user chooses to exit.
     
     scanner.close();
         
 }
 
 // Refactored
	private static void printMenu() {
		System.out.println(colorize("\nWELCOME TO CONTACT APP", GREEN_TEXT(), BLUE_BACK(), BOLD()));
		System.out.println(colorize("\nPlease choose a feature:\n", YELLOW_TEXT(), BOLD()));
		System.out.println(colorize("1. Add Contact", BLUE_TEXT(), BOLD()));
		System.out.println(colorize("2. List Contacts", GREEN_TEXT(), BOLD()));
		System.out.println(colorize("3. Update Contact", MAGENTA_TEXT(), BOLD()));
		System.out.println(colorize("4. Delete Contact", CYAN_TEXT(), BOLD()));
		System.out.println(colorize("5. Search Contacts", BRIGHT_RED_TEXT(), BOLD()));
		System.out.println(colorize("6. Sort Contacts by Name", BRIGHT_GREEN_TEXT(), BOLD()));
		System.out.println(colorize("7. Group Contacts by Category", BRIGHT_CYAN_TEXT(), BOLD()));
		System.out.println(colorize("8. Export Contacts to CSV", BRIGHT_BLUE_TEXT(), BOLD()));
		System.out.println(colorize("9. Import Contacts from CSV", BRIGHT_YELLOW_TEXT(), BOLD()));

		System.out.println(colorize("0. Exit", RED_TEXT(), BOLD()));
	}


}
     
         
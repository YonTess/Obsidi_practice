package com.bptn.course.Project;

import java.util.Scanner;

//ContactHelper class provides utility methods for managing user input related to contact details.
public class ContactHelper {
	
	// Prompts the user to enter a new email address for a given contact.
     public static String getNewEmail(Scanner scanner, Contact contact) {
     
     String newEmail = promptInput(scanner, "Enter new Email ("+ contact.getEmail()+"): ");
     
  // If the user does not enter a new email, retain the existing one.
     if (newEmail.isEmpty()) {
         newEmail = contact.getEmail();
     }
     
  // Validate email format
     while (!isValidEmail(newEmail)) {
        
         newEmail = promptInput(scanner, "Invalid email format. Please enter a valid email:");
     }
     return newEmail;
 }

    // Validates the format of an email address using a regular expression.
		private static boolean isValidEmail(String newEmail) {
			return newEmail.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,8}$");
		}

		// Prompts the user to enter a new name for a contact.
 public static String getNewName(Scanner scanner, Contact contact) {

     String newName = promptInput(scanner, "Enter new Name ("+ contact.getName()+"): ");
     
  // If no input is provided, keep the existing name
     if (newName.isEmpty()) {
         newName = contact.getName();
     }
     return newName;
 }

 // Prompts the user to enter an email address and ensures it is in a valid format
 public static String getEmail(Scanner scanner) {
     String email = promptInput(scanner,"Enter Email: ");
     
     // Validate email format
     while (!isValidEmail(email)) {

         email = promptInput(scanner, "Invalid email format "+ email +". Please enter a valid email:");
     }
     return email;
 }

 // Prompts the user to enter a phone number and ensures it consists of exactly 10 digits.
 public static long getPhone(Scanner scanner) {

     String phoneNumber = promptInput(scanner, "Enter Phone (10 digits): ");
     
  // Validate phone number format
     while (!isValidPhoneNumber(phoneNumber)) {

         phoneNumber = promptInput(scanner, "Invalid phone number format. Please enter a valid phone number:");
     }
     long phone = Long.parseLong(phoneNumber);
     return phone;
 }

 // Validates that the phone number consists of exactly 10 numeric digits.
	private static boolean isValidPhoneNumber(String phoneNumber) {
		return phoneNumber.matches("^[0-9]{10}$");
	}

	// Prompts the user to enter a name.
 public static String getName(Scanner scanner) {
     System.out.print("Enter Name: ");
     String name = scanner.nextLine();
     return name;
 }   
 
 // Prompts the user to enter a new phone number for a given contact.
 public static long getPhone(Scanner scanner, Contact contact) {

     String newPhoneNumber = promptInput(scanner, "Enter new Phone (10 digits)("+ contact.getPhoneNumber()+"): ");
     
     // If the user does not enter a new phone number, retain the existing one.
     if (newPhoneNumber.isEmpty()) {
         newPhoneNumber = Long.toString(contact.getPhoneNumber());
     }
     
     // Validate phone number format
     while (!isValidPhoneNumber(newPhoneNumber)) {

         newPhoneNumber = promptInput(scanner, "Invalid phone number format. Please enter a valid phone number:");
     }
     long newPhone = Long.parseLong(newPhoneNumber);
     return newPhone;
 }

	// Refactored
	static String promptInput(Scanner scanner, String prompt) {
		System.out.print(prompt);
		String choice = scanner.nextLine();
		return choice;
	}
	
	
}
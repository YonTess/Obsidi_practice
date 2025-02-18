package com.bptn.course.Project;

import java.util.Scanner;

//ContactHelper class provides utility methods for managing user input related to contact details.
public class ContactHelper {
	
	// Prompts the user to enter a new email address for a given contact.
     public static String getNewEmail(Scanner scanner, Contact contact) {
     System.out.print("Enter new Email ("+ contact.getEmail()+"): ");
     String newEmail = scanner.nextLine();
     
  // If the user does not enter a new email, retain the existing one.
     if (newEmail.isEmpty()) {
         newEmail = contact.getEmail();
     }
     
  // Validate email format
     while (!isValidEmail(newEmail)) {
         System.out.println("Invalid email format. Please enter a valid email:");
         newEmail = scanner.nextLine();
     }
     return newEmail;
 }

    // Validates the format of an email address using a regular expression.
		private static boolean isValidEmail(String newEmail) {
			return newEmail.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,8}$");
		}

		// Prompts the user to enter a new name for a contact.
 public static String getNewName(Scanner scanner, Contact contact) {
     System.out.print("Enter new Name ("+ contact.getName()+"): ");
     String newName = scanner.nextLine();
     
  // If no input is provided, keep the existing name
     if (newName.isEmpty()) {
         newName = contact.getName();
     }
     return newName;
 }

 // Prompts the user to enter an email address and ensures it is in a valid format
 public static String getEmail(Scanner scanner) {
     System.out.print("Enter Email: ");
     String email = scanner.nextLine();
     
     // Validate email format
     while (!isValidEmail(email)) {
         System.out.println("Invalid email format "+ email +". Please enter a valid email:");
         email = scanner.nextLine();
     }
     return email;
 }

 // Prompts the user to enter a phone number and ensures it consists of exactly 10 digits.
 public static long getPhone(Scanner scanner) {
     System.out.print("Enter Phone (10 digits): ");
     String phoneNumber = scanner.nextLine();
     
  // Validate phone number format
     while (!isValidPhoneNumber(phoneNumber)) {
         System.out.println("Invalid phone number format. Please enter a valid phone number:");
         phoneNumber = scanner.nextLine();
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
     System.out.print("Enter new Phone (10 digits)("+ contact.getPhoneNumber()+"): ");
     String newPhoneNumber = scanner.nextLine();
     
     // If the user does not enter a new phone number, retain the existing one.
     if (newPhoneNumber.isEmpty()) {
         newPhoneNumber = Long.toString(contact.getPhoneNumber());
     }
     
     // Validate phone number format
     while (!isValidPhoneNumber(newPhoneNumber)) {
         System.out.println("Invalid phone number format. Please enter a valid phone number:");
         newPhoneNumber = scanner.nextLine();
     }
     long newPhone = Long.parseLong(newPhoneNumber);
     return newPhone;
 }
}
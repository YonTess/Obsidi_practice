package com.bptn.course.Project;

import java.util.Scanner;

import com.bptn.course.Project.CRUDManager;
import com.bptn.course.Project.Contact;

public class ContactManagement {
    public static void main(String[] args) {
    	CRUDManager crudManager = new CRUDManager();


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. List Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");

            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add new contact information
                    System.out.println("Enter Name: ");
                    String name = scanner.nextLine();
                    
                    System.out.println("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    
                    System.out.println("Enter Email: ");
                    String email = scanner.nextLine();
                    
                    System.out.println("Enter Category (Friends, Family, Work, etc.): ");
                    String category = scanner.nextLine();
                    
                    // Create a new contact and add it to the list
                    Contact contact = new Contact(name, phoneNumber, email, category);
                    crudManager.addContact(contact);
                    
                    System.out.println("Contact added successfully!");
                    break;
                case 2:
                    crudManager.listContact();
                    break;
                case 3:
                    // Update contact logic
                	//crudManager.updateContact(name, phoneNumber, email, category);
                    break;
                case 4:
                    // Delete contact logic
                    break;

                case 9:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
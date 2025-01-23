package com.bptn.course._01_variables;

public class VariableOperations {

	public static void main(String[] args) {
		
		// Declaring two integer variables with values
		int firstNumber = 7;
		int secondNumber = 6;
		
		// Arithmetic operations
		int sum = firstNumber + secondNumber;
		int difference = firstNumber - secondNumber;
		int product = firstNumber * secondNumber;
		int quotient = firstNumber / secondNumber;
		
		// Print original variables and arithmetic results
		
		System.out.println("Original variables: ");
		System.out.println("First Number = " + firstNumber);
		System.out.println("Second Number =" + secondNumber);
		System.out.println("Arithmetic Oparations: ");
		System.out.println("Sum = " + sum);
		System.out.println("Difference =" + difference);
		System.out.println("Product = " + product);
		System.out.println("Quotient = " + quotient);

		//Reassign new values to the original variables

		firstNumber = 10;
		secondNumber = 5;
		
		//Print variables after reassigning

		System.out.println("New First Number: " + firstNumber);
		System.out.println("New Second Number: " + secondNumber);
		
		//Declare a character variable and a string variable and print them
		char myChar = 'Y';
		String myString = "Yonatan";
		System.out.println("My Character is: " + myChar);
		System.out.println("My String is: " + myString);

	}

}


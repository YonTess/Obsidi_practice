package com.bptn.course.Example;

public class Sudent extends Person {
	
	String studentId;
	
	public Sudent(String name, String studentId) {
		
		super.name = name;   // super used to initialize a variable in superclass to subclass
		this.studentId = studentId;
	}
		
		
		public String toString() {			// the toString changes the instance variables into a string representation
		return super.toString() + studentId;    // the super calls the toString() from super class
	
	}
		
//	public String toString() {
//		return name + studentId;
//	}

	
	public static void main(String[] args) {
		Sudent student = new Sudent("Izy", "123");
		System.out.println(student.toString());    // student.toString() calls the toString method in line 14.
	}
}

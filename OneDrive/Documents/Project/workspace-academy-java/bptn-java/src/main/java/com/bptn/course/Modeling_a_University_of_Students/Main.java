package com.bptn.course.Modeling_a_University_of_Students;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Start by looking in the University and Student classes. Implement the methods. 

        // Create a bunch of student objects 
            // (Make sure one student has the following studentId: 123)
            // (Make sure one other student has the following username: testUsername1)

        // Create instance of university called "university" and populate it with the students.

        System.out.println("\nUniversity ------ \n" + university.students);
        System.out.println("\nGetting student------\n" + university.getStudent(123));
        System.out.println("\nDeleting student------\n" + university.deleteStudent(123));
        System.out.println("\nSeaching student------\n" + university.searchStudent("testUserna"));

        System.out.println("\nUniversity ------ \n" + university.students);

    }
}

package com.bptn.course.Modeling_a_University_of_Students;

import java.util.*;

class Student {

    private long studentId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private Date birthdate;
    private Date admissionDate;
    private long rollNumber;
    private String curriculumName;

    public Student(long studentId,
            String userName,
            String password,
            String firstName,
            String lastName,
            String email,
            String phone,
            String address,
            String gender,
            Date birthdate,
            Date admissionDate,
            long rollNumber,
            String curriculumName) {
        this.studentId = studentId;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.birthdate = birthdate;
        this.admissionDate = admissionDate;
        this.rollNumber = rollNumber;
        this.curriculumName = curriculumName;
    }

    /* Implement getters and setters */
    public long getStudentId() {
    }

    public void setStudentId(long studentId) {
    }

    public String getUserName() {
    }

    public void setUserName(String userName) {
    }

    public String getPassword() {
    }

    public void setPassword(String password) {
    }

    public String getFirstName() {
    }

    public void setFirstName(String firstName) {
    }

    public String getLastName() {
    }

    public void setLastName(String lastName) {
    }

    public String getEmail() {
    }

    public void setEmail(String email) {
    }

    public String getPhone() {
    }

    public void setPhone(String phone) {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
    }

    public void setBirthdate(Date birthdate) {
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public long getRollNumber() {
    }

    public void setRollNumber(long rollNumber) {
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
    }
    /* ------end section of getters and setters----------*/

    public void editStudent(List<Student> universityStudents, Student student) {
       // Given a list of students, find by id a student that matches the id of the given student and replace it with the given student.

       // CAN THIS BE REFACTORED? Think about it and give some comments here. Could this method be better placed in a different class? Maybe yes, maybe not. Why?
    }

     public String toString() {
        return "\nStudent: \n" +
                "studentId = " + this.studentId + "\n" +
                "userName = " + this.userName + "\n" +
                "password = " + this.password + "\n" +
                "firstName = " + this.firstName + "\n" +
                "lastName = " + this.lastName + "\n" +
                "email = " + this.email + "\n" +
                "phone = " + this.phone + "\n" +
                "address = " + this.address + "\n" +
                "gender = " + this.gender + "\n" +
                "birthdate = " + this.birthdate + "\n" +
                "admissionDate = " + this.admissionDate + "\n" +
                "rollNumber = " + this.rollNumber + "\n" +
                "curriculumName = " + this.curriculumName + "\n";
    }

}


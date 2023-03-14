package com.example.easyadmission.Student.Database;

public class Student_Basic_information_database {

    String first_name,last_name,middle_name,dob,email,phone_number,marks_10th,marks_12th;
    public Student_Basic_information_database(String first_name,String last_name,String middle_name,String dob,String email,String phone_number,String marks_10th,String marks_12th)
    {
        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_name = middle_name;
        this.dob = dob;
        this.email = email;
        this.phone_number = phone_number;
        this.marks_10th = marks_10th;
        this.marks_12th = marks_12th;
    }

    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getMarks_10th() {
        return marks_10th;
    }

    public void setMarks_10th(String marks_10th) {
        this.marks_10th = marks_10th;
    }

    public String getMarks_12th() {
        return marks_12th;
    }

    public void setMarks_12th(String marks_12th) {
        this.marks_12th = marks_12th;
    }
}

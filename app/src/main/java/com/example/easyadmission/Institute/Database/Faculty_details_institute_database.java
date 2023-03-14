package com.example.easyadmission.Institute.Database;

public class Faculty_details_institute_database {
    String name,email,qualification,experience,id;
    public Faculty_details_institute_database(String name,String email,String qualification,String experience,String id)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.qualification = qualification;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getExperience() { return experience; }

    public void setExperience(String experience) { this.experience = experience; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

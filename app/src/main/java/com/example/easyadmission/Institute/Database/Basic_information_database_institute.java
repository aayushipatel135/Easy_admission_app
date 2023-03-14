package com.example.easyadmission.Institute.Database;

public class Basic_information_database_institute {
    String institute_name,institute_email,institute_about;

    public Basic_information_database_institute(String institute_name,String institute_email,String institute_about)
    {
        this.institute_name = institute_name;
        this.institute_email = institute_email;
        this.institute_about = institute_about;
    }

    public String getInstitute_name() {
        return institute_name;
    }

    public void setInstitute_name(String institute_name) {
        this.institute_name = institute_name;
    }

    public String getInstitute_email() {
        return institute_email;
    }

    public void setInstitute_email(String institute_email) { this.institute_email = institute_email; }

    public String getInstitute_about() {
        return institute_about;
    }

    public void setInstitute_about(String institute_about) { this.institute_about = institute_about; }

}

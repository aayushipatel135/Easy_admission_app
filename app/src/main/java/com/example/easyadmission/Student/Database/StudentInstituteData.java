package com.example.easyadmission.Student.Database;

public class StudentInstituteData {
    String institute_name,img_url;

    public  StudentInstituteData(String institute_name,String img_url)
    {
        this.img_url = img_url;
        this.institute_name = institute_name;
    }

    public String getInstitute_name() {
        return institute_name;
    }

    public String getImg_url() {
        return img_url;
    }
}

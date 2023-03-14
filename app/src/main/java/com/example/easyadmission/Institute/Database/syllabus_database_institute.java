package com.example.easyadmission.Institute.Database;

public class syllabus_database_institute {
    String course_id,course_name,course_information,course_branch;
    public syllabus_database_institute(String course_id,String course_name,String course_information,String course_branch)
    {
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_information = course_information;
        this.course_branch = course_branch;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_information() {
        return course_information;
    }

    public void setCourse_information(String course_information) {
        this.course_information = course_information;
    }

    public String getCourse_branch() {
        return course_branch;
    }

    public void setCourse_branch(String course_branch) {
        this.course_branch = course_branch;
    }
}

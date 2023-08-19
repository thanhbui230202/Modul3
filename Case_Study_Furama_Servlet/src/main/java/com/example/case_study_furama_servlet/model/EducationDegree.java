package com.example.case_study_furama_servlet.model;

public class EducationDegree {
    private int education_id;
    private String education_name;

    public EducationDegree() {
    }

    public EducationDegree(int id, String name) {
        this.education_id = id;
        this.education_name = name;
    }

    public int getEducation_id() {
        return education_id;
    }

    public void setEducation_id(int education_id) {
        this.education_id = education_id;
    }

    public String getEducation_name() {
        return education_name;
    }

    public void setEducation_name(String education_name) {
        this.education_name = education_name;
    }
}

package com.example.redkeepithalal;

public class userPreference {
    private char hafiz; //yes no for doesnt matter
    private String location; //near me or doesnt matter
    private int income; //rough idea
    private int yearsOfEducation;
    private String qualification;
    private int familyMembers; // maximum number of family members
    private qna questionsAndAnswers;

    public userPreference(char hafiz,String location, int income, int yearsOfEducation, String qualification, int familyMembers, qna questionsAndAnswers) {
        this.location = location;
        this.income = income;
        this.yearsOfEducation = yearsOfEducation;
        this.qualification = qualification;
        this.familyMembers = familyMembers;
        this.questionsAndAnswers = questionsAndAnswers ;
    }
    public userPreference(char hafiz,String location, int income, int yearsOfEducation, String qualification, int familyMembers) {
        this.location = location;
        this.income = income;
        this.yearsOfEducation = yearsOfEducation;
        this.qualification = qualification;
        this.familyMembers = familyMembers;
        questionsAndAnswers = new qna() ;
    }

    public char getHafiz() {
        return hafiz;
    }

    public String getLocation() {
        return location;
    }

    public int getIncome() {
        return income;
    }

    public int getYearsOfEducation() {
        return yearsOfEducation;
    }

    public String getQualification() {
        return qualification;
    }

    public int getFamilyMembers() {
        return familyMembers;
    }

    public void setHafiz(char hafiz) {
        this.hafiz = hafiz;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void setYearsOfEducation(int yearsOfEducation) {
        this.yearsOfEducation = yearsOfEducation;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setFamilyMembers(int familyMembers) {
        this.familyMembers = familyMembers;
    }

    public qna getQuestionsAndAnswers() {
        return questionsAndAnswers;
    }

    public void setQuestionsAndAnswers(qna questionsAndAnswers) {
        this.questionsAndAnswers = questionsAndAnswers;
    }
}

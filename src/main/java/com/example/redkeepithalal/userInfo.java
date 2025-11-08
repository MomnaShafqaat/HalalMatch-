package com.example.redkeepithalal;
import java.util.ArrayList;

public class userInfo extends person {
    private char hafiz ;
    private family familyInfo ;
    private boolean isWorking ;
    private sourceOfIncome incomeInfo ;
    private int income ;
    private location userLocation ;
    private String maritalStatus ;
    private String religion ;
    private long number ;
    private String[] hobbies ;
    private userPreference preferences ;
    private ArrayList<match>  matches ;
    public userInfo()
    {}
    public userInfo(String name, int age, int height, char hafiz , int yearsOfEducation, family familyInfo, boolean isWorking, sourceOfIncome incomeInfo, int income, location userLocation, char gender, String maritalStatus, String religion, long number, String[] hobbies) {
        super(name,age,height,yearsOfEducation,gender) ;
        this.hafiz = hafiz ;
        this.isWorking = isWorking ;
        this.familyInfo = familyInfo;
        this.incomeInfo = incomeInfo;
        this.income = income;
        this.userLocation = userLocation;
        this.maritalStatus = maritalStatus;
        this.religion = religion;
        this.number = number;
        this.hobbies = (String[]) hobbies.clone() ; //to avoid shallow copy otherwise each users hobbies point to the same array
    }

    public family getFamilyInfo() {
        return familyInfo;
    }

    public void setFamilyInfo(family familyInfo) {
        this.familyInfo = familyInfo;
    }

    public sourceOfIncome getIncomeInfo() {
        return incomeInfo;
    }

    public void setIncomeInfo(sourceOfIncome incomeInfo) {
        this.incomeInfo = incomeInfo;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public location getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(location userLocation) {
        this.userLocation = userLocation;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public userPreference getPreferences() {
        return preferences;
    }

    public void setPreferences(userPreference preferences) {
        this.preferences = preferences;
    }

    public char  getHafiz() {
        return hafiz;
    }

    public void setHafiz(char hafiz) {
        this.hafiz = hafiz;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public ArrayList<match> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<match> matches) {
        this.matches = matches;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }
}


package com.example.redkeepithalal;

public abstract class person {
    private String name ;
    private int age ;
    private int height ;
    private int yearsOfEducation ;
    private char gender ;
    public person()
    {}

    public person(String name, int age, int height, int yearsOfEducation, char gender) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.yearsOfEducation = yearsOfEducation;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getYearsOfEducation() {
        return yearsOfEducation;
    }

    public char getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setYearsOfEducation(int yearsOfEducation) {
        this.yearsOfEducation = yearsOfEducation;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}


package com.example.redkeepithalal;

public class family {
    private int numOfFamilyMembers ;
    private String familySystem ; //joint or nuclear

    public family(int numOfFamilyMembers, String familySystem) {
        this.numOfFamilyMembers = numOfFamilyMembers;
        this.familySystem = familySystem;
    }

    public int getNumOfFamilyMembers() {
        return numOfFamilyMembers;
    }

    public String getFamilySystem() {
        return familySystem;
    }
}


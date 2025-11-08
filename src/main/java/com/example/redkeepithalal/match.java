package com.example.redkeepithalal;

public class match {
    private int counter ;
    private userInfo potentialMatch ;
    private boolean isApproved ;
    public match()
    {
        counter = 0 ;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public userInfo getPotentialMatch() {
        return potentialMatch;
    }

    public void setPotentialMatch(userInfo potentialMatch) {
        this.potentialMatch = potentialMatch;
    }
    public void incrementCounter()
    {
        counter++ ;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}


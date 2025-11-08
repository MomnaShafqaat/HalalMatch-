package com.example.redkeepithalal;
import java.io.IOException;
public class illegalAgeException extends IOException {
    private int age ;
    public illegalAgeException(int age)
    {
        super(age + " is not a legal age for marriage") ;
        this.age = age ;
    }
}

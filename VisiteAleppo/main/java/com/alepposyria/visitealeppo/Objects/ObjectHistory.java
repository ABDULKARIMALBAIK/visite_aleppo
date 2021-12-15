package com.alepposyria.visitealeppo.Objects;


import java.security.PrivateKey;

/**
 * Created by Lenovo on 10/08/2018.
 */

public class ObjectHistory {

    //declare variables
    private  int picture ;
    private  String name;
    private  String context;

    //constructor to set values in variables

    public ObjectHistory(int picture, String name, String context) {

        this.picture = picture;
        this.name = name;
        this.context = context;
    }

     //here setter to variables.
    public void setPicture(int picture) {
        this.picture = picture;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContext(String context) {
        this.context = context;
    }

    ////here getter to variables.

    public int getPicture() {
        return picture;
    }

    public String getName() {
        return name;
    }

    public String getContext() {
        return context;
    }
}

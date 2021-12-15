package com.alepposyria.visitealeppo.Objects;

/**
 * Created by Lenovo on 09/08/2018.
 */

public class ObjectLocation {

    //declare variables
    private  int picture ;
    private  int location;
    private  float rate;
    private  String name;
    private  String Address;

    //constructor to set values in variables
    public ObjectLocation(int picture, int location, float rate, String name, String address) {
        this.picture = picture;
        this.location = location;
        this.rate = rate;
        this.name = name;
        this.Address = address;
    }

    //here setter to variables

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    //here getter to variables
    public int getPicture() {
        return picture;
    }

    public int getLocation() {
        return location;
    }

    public float getRate() {
        return rate;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {return Address;}

}

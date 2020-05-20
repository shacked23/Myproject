package com.example.myproject;

import android.widget.TextView;

public class User {
    private String  id;
    private String name;
    private String firstName;
    private String data;
    private String helath;
    private String gender;
    private String phoneNumber;
    public User(){

    }
    public User(String  id,String name,String firstName,String data,String helath,String gender,String phoneNumber){
        this.id=id;
        this.name=name;
        this.firstName=firstName;
        this.data=data;
        this.helath=helath;
        this.gender=gender;
        this.phoneNumber=phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHelath() {
        return helath;
    }

    public void setHelath(String helath) {
        this.helath = helath;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gander) {
        this.gender = gander;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

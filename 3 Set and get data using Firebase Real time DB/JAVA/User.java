package com.example.letsloginapp;

public class User {
    String firstName, lastName, mobile, emailId;

    public User(String firstName, String lastName, String mobile, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.emailId = emailId;
    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}

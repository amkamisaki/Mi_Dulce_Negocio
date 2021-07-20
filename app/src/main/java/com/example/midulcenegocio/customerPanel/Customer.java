package com.example.midulcenegocio.customerPanel;

public class Customer {

    private String Email,Password;

    public Customer(){
    }
    // Press Alt+insert


    public Customer(String email, String password) {
        this.Email = email;
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

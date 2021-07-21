package com.example.midulcenegocio.adminPanel;
//Admin class with email and password
public class Admin {

    private String Email, Password;

    // Press Alt+Insert


    public Admin(String email, String password) {
        this.Email = email;
        Password = password;

    }
    public Admin() {
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

}

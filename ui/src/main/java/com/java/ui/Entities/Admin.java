package com.java.ui.Entities;

public class Admin {
    private int id;
    private String NationalIdentity;
    private String Name;
    private String Surname;
    private String Password;

    public Admin(int id, String nationalIdentity, String name, String surname, String password) {
        this.id = id;
        NationalIdentity = nationalIdentity;
        Name = name;
        Surname = surname;
        Password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNationalIdentity() {
        return NationalIdentity;
    }

    public void setNationalIdentity(String nationalIdentity) {
        NationalIdentity = nationalIdentity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

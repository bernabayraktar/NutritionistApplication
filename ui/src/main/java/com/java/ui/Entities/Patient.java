package com.java.ui.Entities;

public class Patient {
    private int id;
    private String NationalIdentity;
    private String Name;
    private String Surname;
    private String Disease;
    private String Diet;
    private String DietStartDate;
    private String NutritionistNationalIdentity;
    private String Password;

    public Patient(int id, String nationalIdentity, String name, String surname, String disease, String diet, String dietStartDate, String nutritionistNationalIdentity, String password) {
        this.id = id;
        NationalIdentity = nationalIdentity;
        Name = name;
        Surname = surname;
        Disease = disease;
        Diet = diet;
        DietStartDate = dietStartDate;
        NutritionistNationalIdentity = nutritionistNationalIdentity;
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

    public String getDisease() {
        return Disease;
    }

    public void setDisease(String disease) {
        Disease = disease;
    }

    public String getDiet() {
        return Diet;
    }

    public void setDiet(String diet) {
        Diet = diet;
    }

    public String getDietStartDate() {
        return DietStartDate;
    }

    public void setDietStartDate(String dietStartDate) {
        DietStartDate = dietStartDate;
    }

    public String getNutritionistNationalIdentity() {
        return NutritionistNationalIdentity;
    }

    public void setNutritionistNationalIdentity(String nutritionistNationalIdentity) {
        NutritionistNationalIdentity = nutritionistNationalIdentity;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

package com.example.ej1practicafx.Entity;

import java.util.Date;

public class Contact {
    private String name;
    private String lastName;
    private Date birthDate;
    private Sex sex;
    private Profesion profesion;
    private String email;
    private Boolean acceptCommercial;

    public Contact(String name, String lastName, Date birthDate, Sex sex, Profesion profesion, String email, Boolean acceptCommercial) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.sex = sex;
        this.profesion = profesion;
        this.email = email;
        this.acceptCommercial = acceptCommercial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAcceptCommercial() {
        return acceptCommercial;
    }

    public void setAcceptCommercial(Boolean acceptCommercial) {
        this.acceptCommercial = acceptCommercial;
    }
}

package com.pbaumgarten.makeagui;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    private String name;
    private String email;
    private String phoneNumber;
    private LocalDate dateofBirth;

    public Person(String name, String email, String phoneNumber, LocalDate dateofBirth){
        this.name= name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.dateofBirth=dateofBirth;
    }

    public Person(String name, String email, String phoneNumber, String dateofBirth){
        this.name= name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.setDateofBirth(dateofBirth);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(LocalDate dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        this.dateofBirth = LocalDate.parse(dateofBirth, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    public int getAge (){
        LocalDate today = LocalDate.now();
        Period period = Period.between(this.dateofBirth, today);
        return period.getYears();
    }



    }


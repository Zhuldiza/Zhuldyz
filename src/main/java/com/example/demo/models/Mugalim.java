package com.example.demo.models;

import javax.persistence.*;

@Entity
public class Mugalim {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String firstName;
    private String lastName ;
    private String email ;

    public Mugalim(){}

    public Mugalim(String firstName, String lastName, String email) {
        this.firstName=firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String Name) {
        this.firstName = Name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String Name) {
        this.lastName = Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package com.example.demo.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stud {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String StudName;
    private int year;

    public Stud() {
        this.StudName = "" ;
        this.year = 0 ;
    }

    public Stud(String studName, int year) {
        this.StudName = studName;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudName() {
        return getStudName();
    }

    public void setstudName(String studName) {
        this.StudName = studName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

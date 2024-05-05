package com.example.Inventor.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    public Date dateTime;


    // Геттеры и сеттеры


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Report(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Report() {
    }
}
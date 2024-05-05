package com.example.Inventor.models;

import jakarta.persistence.*;
@Entity
@Table(name = "Processor")
public class Processor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "SocketDesignation")
    private String socketDesignation;
    @Column(name = "Description")
    private String description;

    @Column(name = "CurrentClockSpeed")
    private Long currentClockSpeed;

    @ManyToOne
    @JoinColumn(name = "reportId")
    private Report reportId;

    // Геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocketDesignation() {
        return socketDesignation;
    }

    public void setSocketDesignation(String socketDesignation) {
        this.socketDesignation = socketDesignation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCurrentClockSpeed() {
        return currentClockSpeed;
    }

    public void setCurrentClockSpeed(Long currentClockSpeed) {
        this.currentClockSpeed = currentClockSpeed;
    }

    public Report getreportId() {
        return reportId;
    }

    public void setreportId(Report reportId) {
        this.reportId = reportId;
    }
}

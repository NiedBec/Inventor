package com.example.Inventor.models;

import jakarta.persistence.*;

@Entity
@Table(name = "RAMInfo")
public class RAMInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MemoryDevices")
    private Long memoryDevices;
    @ManyToOne
    @JoinColumn(name = "Report_ID")
    private Report report;

    // Геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemoryDevices() {
        return memoryDevices;
    }

    public void setMemoryDevices(Long memoryDevices) {
        this.memoryDevices = memoryDevices;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
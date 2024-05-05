package com.example.Inventor.models;

import jakarta.persistence.*;
@Entity
@Table(name = "LANCard")
public class LANCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "AdapterType")
    private String adapterType;

    @Column(name = "MACAddress")
    private String macAddress;

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

    public String getAdapterType() {
        return adapterType;
    }

    public void setAdapterType(String adapterType) {
        this.adapterType = adapterType;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Report getreportId() {
        return reportId;
    }

    public void setreportId(Report reportId) {
        this.reportId = reportId;
    }
}
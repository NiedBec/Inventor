package com.example.Inventor.models;

import jakarta.persistence.*;
@Entity
@Table(name = "HDD")
public class HDD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Model")
    private String model;

    @Column(name = "Partitions")
    private Long partitions;

    @Column(name = "Size")
    private Long size;

    @Column(name = "InterfaceType")
    private String interfaceType;

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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getPartitions() {
        return partitions;
    }

    public void setPartitions(Long partitions) {
        this.partitions = partitions;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
package com.example.Inventor.models;

import jakarta.persistence.*;
@Entity
@Table(name = "XmlEntity")
public class XmlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "XMLData")
    private String xmlData;
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

    public String getXmlData() {
        return xmlData;
    }

    public void setXmlData(String xmlData) {
        this.xmlData = xmlData;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}

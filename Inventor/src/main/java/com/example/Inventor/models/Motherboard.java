package com.example.Inventor.models;

import jakarta.persistence.*;
@Entity
@Table(name = "Motherboard")
public class Motherboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Manufacturer")
    private String manufacturer;
    @Column(name = "Product")
    private String product;

    @Column(name = "SerialNumber")
    private String serialNumber;
    @Column(name = "Status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "Report_ID")
    private Report report_id;

    // Геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Report getReport_id() {
        return report_id;
    }

    public void setReport_id(Report report_id) {
        this.report_id = report_id;
    }
}

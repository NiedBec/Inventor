package com.example.Inventor.models;

import jakarta.persistence.*;
@Entity
@Table(name = "RAM")
public class RAM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "capacity")
    private Long capacity;
    @Column(name = "DeviceLocator")
    private String deviceLocator;
    @Column(name = "Manufacturer")
    private String manufacturer;

    @Column(name = "PartNumber")
    private String partNumber;

    @Column(name = "SerialNumber")
    private String serialNumber;
    @Column(name = "Tag")
    private String tag;
    @Column(name = "TypeDetail")
    private String typeDetail;
    @Column(name = "MemoryType")
    private long memoryType;
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

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getDeviceLocator() {
        return deviceLocator;
    }

    public void setDeviceLocator(String deviceLocator) {
        this.deviceLocator = deviceLocator;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTypeDetail() {
        return typeDetail;
    }

    public void setTypeDetail(String typeDetail) {
        this.typeDetail = typeDetail;
    }

    public long getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(long memoryType) {
        this.memoryType = memoryType;
    }

    public Report getReport_id() {
        return report_id;
    }

    public void setReport_id(Report report_id) {
        this.report_id = report_id;
    }
}
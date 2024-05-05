package com.example.Inventor.models;

import jakarta.persistence.*;
@Entity
@Table(name = "LogicalDrive")
public class LogicalDrive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DeviceID")
    private String deviceID;

    @Column(name = "FileSystem")
    private String fileSystem;

    @Column(name = "Size")
    private Long size;

    @Column(name = "FreeSpace")
    private Long freeSpace;

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

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getFileSystem() {
        return fileSystem;
    }

    public void setFileSystem(String fileSystem) {
        this.fileSystem = fileSystem;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(Long freeSpace) {
        this.freeSpace = freeSpace;
    }

    public Report getreportId() {
        return reportId;
    }

    public void setreportId(Report reportId) {
        this.reportId = reportId;
    }
}

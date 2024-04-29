package com.example.Inventor.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "InformationOS")
public class InformationOS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "csname")
    private String csname;
    @Column(name = "caption")
    private String caption;
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Column(name = "Version")
    private String version;
    @Column(name = "RegisteredUser")
    private String registeredUser;
    @Column(name = "CountryCode")
    private String countryCode;
    // Геттеры и сеттеры


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCsname() {
        return csname;
    }

    public void setCsname(String csname) {
        this.csname = csname;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(String registeredUser) {
        this.registeredUser = registeredUser;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
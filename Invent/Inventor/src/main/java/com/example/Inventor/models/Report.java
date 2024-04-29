package com.example.Inventor.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "information_os_id")
    private InformationOS informationOS;
    @ManyToOne
    @JoinColumn(name = "ram_info_id")
    private RAMInfo ramInfo;
    private Date dateTime;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    // Геттеры и сеттеры


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InformationOS getInformationOS() {
        return informationOS;
    }

    public void setInformationOS(InformationOS informationOS) {
        this.informationOS = informationOS;
    }

    public RAMInfo getRamInfo() {
        return ramInfo;
    }

    public void setRamInfo(RAMInfo ramInfo) {
        this.ramInfo = ramInfo;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
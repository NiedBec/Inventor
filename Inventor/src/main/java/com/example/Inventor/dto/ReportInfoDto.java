package com.example.Inventor.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import com.example.Inventor.models.*;

public class ReportInfoDto {
    private Long reportId;
    private Long RAMInfomemoryDevices;
    private Date dateTime;
    private String csname;
    private String caption;
    private String serialNumber;
    private String version;
    private String registeredUser;
    private String countryCode;
    private UUID uuid;
    private List<HDD> hdds;
    private List<GPU> gpus;
    private List<Processor> cpus;
    private List<Motherboard> motherboards;
    private List<LogicalDrive> logicalDrives;
    private List<RAM> rams;
    private List<RAMInfo> ramInfos;
    private List<LANCard> lanCards;
    private List<NetInfo> netInfos;
    private List<Programs> programs;
    private List<Location> locations;
    // Геттеры и сеттеры


    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Long getRAMInfomemoryDevices() {
        return RAMInfomemoryDevices;
    }

    public void setRAMInfomemoryDevices(Long RAMInfomemoryDevices) {
        this.RAMInfomemoryDevices = RAMInfomemoryDevices;
    }

    public List<Processor> getCpus() {
        return cpus;
    }

    public void setCpus(List<Processor> cpus) {
        this.cpus = cpus;
    }

    public List<Motherboard> getMotherboards() {
        return motherboards;
    }

    public void setMotherboards(List<Motherboard> motherboards) {
        this.motherboards = motherboards;
    }

    public List<LogicalDrive> getLogicalDrives() {
        return logicalDrives;
    }

    public void setLogicalDrives(List<LogicalDrive> logicalDrives) {
        this.logicalDrives = logicalDrives;
    }

    public List<RAM> getRams() {
        return rams;
    }

    public void setRams(List<RAM> rams) {
        this.rams = rams;
    }

    public List<RAMInfo> getRamInfos() {
        return ramInfos;
    }

    public void setRamInfos(List<RAMInfo> ramInfos) {
        this.ramInfos = ramInfos;
    }

    public List<LANCard> getLanCards() {
        return lanCards;
    }

    public void setLanCards(List<LANCard> lanCards) {
        this.lanCards = lanCards;
    }

    public List<NetInfo> getNetInfos() {
        return netInfos;
    }

    public void setNetInfos(List<NetInfo> netInfos) {
        this.netInfos = netInfos;
    }

    public List<Programs> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Programs> programs) {
        this.programs = programs;
    }

    public List<GPU> getGpus() {
        return gpus;
    }

    public void setGpus(List<GPU> gpus) {
        this.gpus = gpus;
    }

    public List<HDD> getHdds() {
        return hdds;
    }

    public void setHdds(List<HDD> hdds) {
        this.hdds = hdds;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
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

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

}
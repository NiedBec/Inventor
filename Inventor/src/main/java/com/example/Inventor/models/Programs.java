package com.example.Inventor.models;


import jakarta.persistence.*;
@Entity
@Table(name = "Programs")
public class Programs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DisplayName")
    private String displayName;

    @Column(name = "DisplayVersion")
    private String displayVersion;
    @Column(name = "Publisher")
    private String publisher;
    @Column(name = "InstallDate")
    private String installDate;


    @ManyToOne
    @JoinColumn(name = "reportId")
    private Report reportId;

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayVersion() {
        return displayVersion;
    }

    public void setDisplayVersion(String displayVersion) {
        this.displayVersion = displayVersion;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getInstallDate() {
        return installDate;
    }

    public void setInstallDate(String installDate) {
        this.installDate = installDate;
    }

    public Report getreportId() {
        return reportId;
    }

    public void setreportId(Report reportId) {
        this.reportId = reportId;
    }
}
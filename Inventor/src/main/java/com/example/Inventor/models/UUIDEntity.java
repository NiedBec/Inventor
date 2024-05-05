package com.example.Inventor.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "UUIDEntity")
public class UUIDEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "reportId")
    private Report reportId;
    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Report getreportId() {
        return reportId;
    }

    public void setreportId(Report reportId) {
        this.reportId = reportId;
    }
}
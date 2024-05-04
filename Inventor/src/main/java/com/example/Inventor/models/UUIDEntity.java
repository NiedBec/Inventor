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
    @JoinColumn(name = "Report_ID")
    private Report report_id;
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

    public Report getReport_id() {
        return report_id;
    }

    public void setReport_id(Report report_id) {
        this.report_id = report_id;
    }
}
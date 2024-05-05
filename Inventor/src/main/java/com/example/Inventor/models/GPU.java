package com.example.Inventor.models;

import jakarta.persistence.*;

@Entity
@Table(name = "GPU")
public class GPU {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "VideoProcessor")
    private String videoProcessor;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoProcessor() {
        return videoProcessor;
    }

    public void setVideoProcessor(String videoProcessor) {
        this.videoProcessor = videoProcessor;
    }

    public Report getreportId() {
        return reportId;
    }

    public void setreportId(Report reportId) {
        this.reportId = reportId;
    }
}
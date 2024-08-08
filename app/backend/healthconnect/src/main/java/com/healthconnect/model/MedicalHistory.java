package com.healthconnect.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "medicalhistory")
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;
    private Long patientId;
    private String description;
    private LocalDate dateRecorded;
    // other fields

    // Default constructor
    public MedicalHistory() {}

    // Parameterized constructor
    public MedicalHistory(Long patientId, String description, LocalDate dateRecorded) {
        this.patientId = patientId;
        this.description = description;
        this.dateRecorded = dateRecorded;
    }

    // Getters and setters
    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(LocalDate dateRecorded) {
        this.dateRecorded = dateRecorded;
    }
}

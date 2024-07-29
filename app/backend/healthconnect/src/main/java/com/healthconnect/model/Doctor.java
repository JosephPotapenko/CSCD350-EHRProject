package com.healthconnect.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctor_id;

    private Long user_id;
    private String firstName;
    private String lastName;
    private String specialty;
    private String contactInfo;
    private String email;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @JsonManagedReference
    private UserAccount userAccount;

    // Default constructor
    public Doctor() {}

    // Parameterized constructor
    public Doctor(Long user_id, String firstName, String lastName, String specialty, String contactInfo, String email, UserAccount userAccount) {
        this.user_id = user_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.contactInfo = contactInfo;
        this.email = email;
        this.userAccount = userAccount;
    }

    // Getters and setters
    public Long getDoctorId() {
        return doctor_id;
    }

    public void setDoctorId(Long doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Long getUserId() {
        return user_id;
    }

    public void setUserId(Long user_id) {
        this.user_id = user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}

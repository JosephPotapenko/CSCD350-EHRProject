package com.healthconnect.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "billing")
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billing_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;

    private Date billing_date;
    private Date due_date;
    private Double amount;
    private String status;
    private String payment_method;
    private String description;

    // Getters and setters
    public Long getBilling_id() {
        return billing_id;
    }

    public void setBilling_id(Long billingId) {
        this.billing_id = billingId;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Date getBilling_date() {
        return billing_date;
    }

    public void setBilling_date(Date billingDate) {
        this.billing_date = billingDate;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date dueDate) {
        this.due_date = dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String paymentMethod) {
        this.payment_method = paymentMethod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

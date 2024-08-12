package com.healthconnect.model;

public class PaymentRequest {
    private Long billingId;
    private String cardName;
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    private Long userId; // Add this line

    // Getters and setters
    public Long getBillingId() {
        return billingId;
    }

    public void setBillingId(Long billingId) {
        this.billingId = billingId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Long getUserId() { // Add this getter
        return userId;
    }

    public void setUserId(Long userId) { // Add this setter
        this.userId = userId;
    }
}

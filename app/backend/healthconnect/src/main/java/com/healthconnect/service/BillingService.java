package com.healthconnect.service;

import com.healthconnect.model.Billing;
import com.healthconnect.model.PaymentRequest;
import com.healthconnect.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    public Billing saveBilling(Billing billing) {
        return billingRepository.save(billing);
    }

    public List<Billing> getBillsByPatientId(Long userId) {
        return billingRepository.findByPatientId(userId);
    }

    public boolean payBill(PaymentRequest paymentRequest) {
        Billing billing = billingRepository.findById(paymentRequest.getBillingId()).orElse(null);
        if (billing != null) {
            billing.setStatus("Paid");
            billingRepository.save(billing);
            return true;
        }
        return false;
    }
}

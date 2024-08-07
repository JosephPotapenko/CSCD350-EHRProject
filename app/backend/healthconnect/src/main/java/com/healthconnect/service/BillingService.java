package com.healthconnect.service;

import com.healthconnect.model.Billing;
import com.healthconnect.model.PaymentRequest;
import com.healthconnect.model.UserAccount;
import com.healthconnect.repository.BillingRepository;
import com.healthconnect.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    private UserAccountRepository userAccountRepository;

    public Billing saveBilling(Billing billing) {
        return billingRepository.save(billing);
    }

    public List<Billing> getBillsByPatientId(UserAccount userId) {
        return billingRepository.findByUserAccount(userId);
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

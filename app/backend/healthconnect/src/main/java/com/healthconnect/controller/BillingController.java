package com.healthconnect.controller;

import com.healthconnect.model.Billing;
import com.healthconnect.model.PaymentRequest;
import com.healthconnect.model.UserAccount;
import com.healthconnect.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping("/add")
    public ResponseEntity<Billing> addBilling(@RequestBody Billing billing) {
        Billing newBilling = billingService.saveBilling(billing);
        return ResponseEntity.ok(newBilling);
    }

    @GetMapping("/patient/{userId}")
    public ResponseEntity<List<Billing>> getBillsByPatientId(@PathVariable UserAccount userId) {
        List<Billing> billingList = billingService.getBillsByPatientId(userId);
        return ResponseEntity.ok(billingList);
    }

    @PostMapping("/pay")
    public ResponseEntity<String> payBill(@RequestBody PaymentRequest paymentRequest) {
        boolean isPaid = billingService.payBill(paymentRequest);
        if (isPaid) {
            return ResponseEntity.ok("Payment successful");
        } else {
            return ResponseEntity.status(400).body("Payment failed");
        }
    }
}

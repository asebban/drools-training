package ma.medtech.drools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.medtech.drools.model.Customer;
import ma.medtech.drools.service.EligibilityService;

@RestController
@RequestMapping("/api")
public class EligibilityController {

    @Autowired
    private EligibilityService service;

    @PostMapping("/eligibility")
    public ResponseEntity<Customer> checkEligibility(@RequestBody Customer customer) {
        Customer result = service.evaluate(customer);
        return ResponseEntity.ok(result);
    }
}


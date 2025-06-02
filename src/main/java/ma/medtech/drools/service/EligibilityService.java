package ma.medtech.drools.service;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.medtech.drools.model.Customer;

@Service
public class EligibilityService {

    @Autowired
    private KieSession kieSession;

    public Customer evaluate(Customer customer) {
        kieSession.insert(customer);
        kieSession.fireAllRules();
        return customer;
    }
}


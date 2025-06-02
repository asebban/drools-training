package ma.medtech.drools.services;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.medtech.drools.model.Product;

@Service
public class PricingService {

    @Autowired
    private KieSession kieSession;

    public void applyDiscount(Product product) {
        kieSession.insert(product);
        kieSession.fireAllRules();
    }
}

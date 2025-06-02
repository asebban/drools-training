package ma.medtech.drools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ma.medtech.drools.model.Product;
import ma.medtech.drools.services.PricingService;

@RestController
public class ProductController {

    @Autowired
    private PricingService pricingService;

    @GetMapping("/price")
    public String calculatePrice() {
        Product p = new Product(200.0, 0.0);
        pricingService.applyDiscount(p);
        return "Discount = " + p.getDiscount();
    }
}


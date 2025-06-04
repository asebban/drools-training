package ma.medtech.drools.services;

public class ExternalService {
    public int getAge(String name) {
        // Simulate an external service call to get the age of a customer
        if ("Alice".equals(name)) {
            return 70;
        } else if ("Bob".equals(name)) {
            return 30;
        }
        return 0; // Default case
    }

    public double getIncome(String name) {
        // Simulate an external service call to get the income of a customer
        if ("Alice".equals(name)) {
            return 50000;
        } else if ("Bob".equals(name)) {
            return 30000;
        }
        return 0.0; // Default case
    }

    public static class Factory {
        public static ExternalService get() {
            return new ExternalService();
        }
    }
}

package ma.medtech.drools.model;

public class Transaction {
    private String country;
    private double amount;

    // Constructeurs, getters, setters
    public Transaction() {}
    public Transaction(String country, double amount) {
        this.country = country;
        this.amount = amount;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}

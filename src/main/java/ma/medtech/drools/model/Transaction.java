package ma.medtech.drools.model;

public class Transaction {
    private double amount;
    private String currency;
    private String country;
    private Client client;

    public Transaction() {}
    public Transaction(double amount, String currency, String country, Client client) {
        this.amount = amount;
        this.currency = currency;
        this.country = country;
        this.client = client;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                ", country='" + country + '\'' +
                ", client=" + client +
                '}';
    }
}


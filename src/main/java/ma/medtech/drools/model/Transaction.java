package ma.medtech.drools.model;

public class Transaction {
    private String clientId;
    private double amount;

    public Transaction() {}
    public Transaction(String clientId, double montant) {
        this.clientId = clientId;
        this.amount = montant;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "clientId='" + clientId + '\'' +
                ", montant=" + amount +
                '}';
    }

}


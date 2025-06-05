package ma.medtech.drools.model;

public class Transaction {
    private String clientId;
    private double montant;
    private String type;

    public Transaction(String clientId, double montant, String type) {
        this.clientId = clientId;
        this.montant = montant;
        this.type = type;
    }

    // Getters
    public String getClientId() { return clientId; }
    public double getMontant() { return montant; }
    public String getType() { return type; }
    public void setClientId(String clientId) { this.clientId = clientId; }
    public void setMontant(double montant) { this.montant = montant; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return "Transaction{" +
                "clientId='" + clientId + '\'' +
                ", montant=" + montant +
                ", type='" + type + '\'' +
                '}';
    }
}

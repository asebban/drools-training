package ma.medtech.drools.model;

public class Client {
    private String id;
    private String name;
    private double totalAmount;

    public Client() {}
    public Client(String id, String name) {
        this.id = id;
        this.name = name;
        this.totalAmount = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void addMontant(double amount) {
        this.totalAmount += amount;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", montantTotal=" + totalAmount +
                '}';
    }

    // Getters et setters
}


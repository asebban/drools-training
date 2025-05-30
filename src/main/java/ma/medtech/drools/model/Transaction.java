package ma.medtech.drools.model;

public class Transaction {
    private String id;
    private double amount;
    private boolean suspicious;
    private boolean vip;
    
    public Transaction() {}
    public Transaction(String id, double amount, boolean suspicious, boolean vip) {
        this.id = id;
        this.amount = amount;
        this.suspicious = suspicious;
        this.vip = vip;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public boolean isSuspicious() {
        return suspicious;
    }
    public void setSuspicious(boolean suspicious) {
        this.suspicious = suspicious;
    }
    public boolean isVip() {
        return vip;
    }
    public void setVip(boolean vip) {
        this.vip = vip;
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", suspicious=" + suspicious +
                ", vip=" + vip +
                '}';
    }
}


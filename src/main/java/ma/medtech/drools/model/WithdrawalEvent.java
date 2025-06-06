package ma.medtech.drools.model;

import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

@Role(Role.Type.EVENT)
@Timestamp("timestamp")
public class WithdrawalEvent {
    private String clientId;
    private double amount;
    private long timestamp;

    public WithdrawalEvent(String clientId, double amount, long timestamp) {
        this.clientId = clientId;
        this.amount = amount;
        this.timestamp = timestamp;
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
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}


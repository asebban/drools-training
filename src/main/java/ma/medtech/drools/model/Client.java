package ma.medtech.drools.model;

public class Client {
    private String name;
    private boolean valid;

    public Client() {}
    public Client(String name, boolean valid) {
        this.name = name;
        this.valid = valid;
    }

    public String getName() { return name; }
    public boolean isValid() { return valid; }

    public void setName(String name) { this.name = name; }
    public void setValid(boolean valid) { this.valid = valid; }
}

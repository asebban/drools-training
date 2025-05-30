package ma.medtech.drools.model;

public class Majeur {
    private String name;

    public Majeur(String name) { this.name = name; }

    public String getName() { return name; }

    @Override
    public String toString() {
        return "Majeur{name='" + name + "'}";
    }
}


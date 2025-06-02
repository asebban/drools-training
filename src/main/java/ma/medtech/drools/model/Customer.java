package ma.medtech.drools.model;

public class Customer {
    private String name;
    private int age;
    private double income;
    private boolean eligible;

    // Getters, setters, constructeur
    public Customer(String name, int age, double income) {
        this.name = name;
        this.age = age;
        this.income = income;
        this.eligible = false; // Default value
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public boolean isEligible() {
        return eligible;
    }

    public void setEligible(boolean eligible) {
        this.eligible = eligible;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", income=" + income +
                ", eligible=" + eligible +
                '}';
    }
}

package ma.medtech.drools.model;

public class Customer {
    private String name;
    private int age;
    private double income;

    public Customer() {}
    public Customer(String name, int age, double income) {
        this.name = name;
        this.age = age;
        this.income = income;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getIncome() { return income; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setIncome(double income) { this.income = income; }
}

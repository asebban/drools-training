package ma.medtech.drools.model;

public class Person {
    private String name;
    private int age;
    private double income;
    private boolean employed;
    private int score;

    public Person() {}
    public Person(String name, int age, double income, boolean employed) {
        this.name = name;
        this.age = age;
        this.income = income;
        this.employed = employed;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }

    public double getIncome() { return income; }
    public void setIncome(double income) { this.income = income; }
    public boolean isEmployed() { return employed; }
    public void setEmployed(boolean employed) { this.employed = employed; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", income=" + income +
                ", employed=" + employed +
                ", score=" + score +
                '}';
    }
}

package ma.medtech.drools.model;

import java.util.List;

public class Client {
    private String name;
    private int age;
    private String country;
    private List<String> roles;

    public Client() {}
    public Client(String name, int age, String country, List<String> roles) {

        this.name = name;
        this.age = age;
        this.country = country;
        this.roles = roles;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCountry() { return country; }
    public List<String> getRoles() { return roles; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setCountry(String country) { this.country = country; }
    public void setRoles(List<String> roles) { this.roles = roles; }
}

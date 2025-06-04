package ma.medtech.drools;

import ma.medtech.drools.model.Customer;
import ma.medtech.drools.services.ExternalService;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class App {
    public static void main(String[] args) {

        List<Customer> riskyCustomers = new ArrayList<>();
        List<Customer> nonRiskyCustomers = new ArrayList<>();
        
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession ksession = kc.newKieSession("rulesSession");

        // Get the external service instance
        ExternalService externalService = ExternalService.Factory.get();
        ksession.setGlobal("externalService", externalService);
        ksession.setGlobal("riskyCustomers", riskyCustomers);
        ksession.setGlobal("nonRiskyCustomers", nonRiskyCustomers);

        Customer c1 = new Customer("Alice", 70, 2000);
        Customer c2 = new Customer("Bob", 30, 30000);
        Customer c3 = new Customer("Ahmed", 60, 3000); // Ajout du client Ahmed

        ksession.insert(c1);
        ksession.insert(c2);
        ksession.insert(c3);
        ksession.fireAllRules();
        ksession.dispose();

        System.out.println("Risky Customers:");
        for (Customer customer : riskyCustomers) {
            System.out.println(customer.getName() + " - Age: " + customer.getAge() + ", Income: " + customer.getIncome());
        }

        System.out.println("Non-Risky Customers:");
        for (Customer customer : nonRiskyCustomers) {
            System.out.println(customer.getName() + " - Age: " + customer.getAge() + ", Income: " + customer.getIncome());
        }
    }
}
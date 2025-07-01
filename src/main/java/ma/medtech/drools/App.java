package ma.medtech.drools;

import ma.medtech.drools.model.Client;
import ma.medtech.drools.model.Transaction;

import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class App {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession ksession = kc.newKieSession("rulesSession");
        
        Client alice = new Client("Alice", 70, "FR", List.of("USER"));
        Client bob   = new Client("Bob", 35, "NG", List.of("ADMIN", "USER"));
        Client ali   = new Client("Ali", 20, "MA", List.of("USER"));

        Transaction t1 = new Transaction(5000.0, "EUR", "FR", alice);
        Transaction t2 = new Transaction(12000.0, "USD", "NG", bob);
        Transaction t3 = new Transaction(1000.0, "MAD", "MA", ali);

        ksession.insert(alice);
        ksession.insert(bob);
        ksession.insert(ali);
        ksession.insert(t1);
        ksession.insert(t2);
        ksession.insert(t3);

        ksession.fireAllRules();
        ksession.dispose();

    }
}
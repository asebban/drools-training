package ma.medtech.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import ma.medtech.drools.model.Client;
import ma.medtech.drools.model.Transaction;

public class App {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession ksession = kc.newKieSession("rulesSession");

        Client client = new Client("1", "Ahmed");
        ksession.insert(client);

        Transaction transaction1 = new Transaction("1", 1000.0);
        ksession.insert(transaction1);
        ksession.fireAllRules();
        System.out.println("***********************************");
        Transaction transaction2 = new Transaction("1", 3000.0);
        ksession.insert(transaction2);
        ksession.fireAllRules();
        System.out.println("***********************************");
        Transaction transaction3 = new Transaction("1", 5000.0);
        ksession.insert(transaction3);
        ksession.fireAllRules();
        System.out.println("***********************************");
        Transaction transaction4 = new Transaction("1", 3000.0);
        ksession.insert(transaction4);
        ksession.fireAllRules();

    }
}
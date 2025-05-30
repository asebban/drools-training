package ma.medtech.drools;

import ma.medtech.drools.model.Transaction;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


public class App {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession ksession = kc.newKieSession("rulesSession");

        Transaction tx = new Transaction();
        tx.setId("TX999");
        tx.setAmount(20000);     // gros montant → suspect
        tx.setVip(true);         // mais c'est un VIP
        
        ksession.insert(tx);
        ksession.fireAllRules();
        ksession.dispose();
    }
}
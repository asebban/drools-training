package ma.medtech.drools;

import ma.medtech.drools.model.Client;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class App {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession ksession = kc.newKieSession("rulesSession");

        Client c = new Client("Alice", false);
        ksession.insert(c);
        ksession.fireAllRules();
        ksession.dispose();
    }
}
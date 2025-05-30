package ma.medtech.drools;

import ma.medtech.drools.model.Product;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class App {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession session = kc.newKieSession("rulesSession");

        Product c = new Product(1000.0, 11.0);  // Score moyen
        session.insert(c);

        session.fireAllRules();
        session.dispose();

    }
}
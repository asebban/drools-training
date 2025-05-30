package ma.medtech.drools;

import ma.medtech.drools.model.Counter;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class App {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession session = kc.newKieSession("rulesSession");

        Counter counter = new Counter(0);

        session.insert(counter);
        session.fireAllRules();  // Attention : boucle ici !
        session.dispose();
        System.out.println("Final counter value: " + counter.getValue());
    }
}
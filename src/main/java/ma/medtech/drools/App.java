package ma.medtech.drools;

import ma.medtech.drools.model.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class App {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession session = kc.newKieSession("rulesSession");

        Person p = new Person("Alice", 20);
        var factHandle = session.insert(p);

        System.out.println("=== Première exécution avec age = 20 ===");
        session.fireAllRules();

        System.out.println("\n=== Mise à jour : age = 15 ===");
        p.setAge(15);
        session.update(factHandle, p);
        session.fireAllRules();

        System.out.println("\n=== Re-mise à jour : age = 19 ===");
        p.setAge(19);
        session.update(factHandle, p);
        session.fireAllRules();

        session.dispose();
    }
}
package ma.medtech.drools;

import ma.medtech.drools.model.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class App {
    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();

        KieSession session = kieContainer.newKieSession("rulesSession");

        Person jean = new Person("Jean", 70);

        System.out.println("=== Avant exécution : " + jean);
        session.insert(jean);
        session.fireAllRules();
        System.out.println("**************************");
        session.fireAllRules();
        System.out.println("=== Après exécution : " + jean);
    }
}
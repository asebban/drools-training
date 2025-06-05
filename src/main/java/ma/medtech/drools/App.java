package ma.medtech.drools;

import ma.medtech.drools.model.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

public class App {
    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();

        KieSession session = kieContainer.newKieSession("rulesSession");

        Person jean = new Person("Jean", 70);
        Person paul = new Person("Paul", 80);

        System.out.println("=== Avant exécution : " + jean);
        session.insert(jean);
        session.fireAllRules();
        System.out.println("**************************");
        session.insert(paul);
        FactHandle jeanHandle = session.getFactHandle(jean); // Récupère le FactHandle de Jean
        session.update(jeanHandle, jean); // Notifie Drools que Jean doit être réévalué
        session.fireAllRules();
        System.out.println("=== Après exécution : " + jean);
    }
}
package ma.medtech.drools;

import ma.medtech.drools.model.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

public class App {
    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();

        StatelessKieSession session = kieContainer.newStatelessKieSession("rulesSession");

        Person jean = new Person("Jean", 70);
        Person paul = new Person("Paul", 80);

        System.out.println("=== Avant exécution : " + jean);
        session.execute(jean);
        System.out.println("**************************");
        session.execute(paul);
        System.out.println("=== Après exécution : " + jean);
    }
}
package ma.medtech.drools;

import ma.medtech.drools.model.Person;

import java.util.List;

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
        session.execute(List.of(jean, paul));
        System.out.println("**************************");
        jean.setEligible(false);
        session.execute(paul);
        System.out.println("=== Après exécution : " + jean);
    }
}
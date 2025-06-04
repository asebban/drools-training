package ma.medtech.drools;

import ma.medtech.drools.model.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class App {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession ksession = kc.newKieSession("rulesSession");

        Person p1 = new Person("Alice", 70);
        Person p2 = new Person("Bob", 15);
        ksession.insert(p1);
        ksession.insert(p2);
        ksession.getAgenda().getAgendaGroup("senior").setFocus();
        ksession.getAgenda().getAgendaGroup("junior").setFocus();
        ksession.fireAllRules();
        ksession.dispose();
    }
}
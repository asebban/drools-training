package ma.medtech.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class App {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();

        KieSession session = kc.newKieSession("rulesSession");
        session.getAgenda().getAgendaGroup("validation").setFocus();

        session.insert("A");
        session.fireAllRules();

        session.insert("B"); // Fait qui satisferait la règle B
        session.fireAllRules(); // Règle B ne s'active pas !
    }
}
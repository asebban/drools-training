package ma.medtech.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import ma.medtech.drools.model.Transaction;

import java.util.*;

public class TestFraude {
    public static void main(String[] args) {
        List<String> alertes = new ArrayList<>();

        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kSession = kc.newKieSession("ksession-rules");

        kSession.setGlobal("alertes", alertes);

        kSession.insert("Ali");

        // Transactions du client Ali
        kSession.insert(new Transaction("Ali", 1200, "cash"));
        kSession.insert(new Transaction("Ali", 1500, "wire"));
        kSession.insert(new Transaction("Ali", 900, "cash"));
        kSession.insert(new Transaction("Ali", 1100, "cash"));
        kSession.insert(new Transaction("Ali", 1300, "card"));

        kSession.fireAllRules();
        kSession.dispose();

        System.out.println("Alertes générées :");
        alertes.forEach(System.out::println);
    }
}

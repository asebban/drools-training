package ma.medtech.drools;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import ma.medtech.drools.model.Transaction;

public class RulesPerformanceTest {

    @Test
    public void testEfficiency() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();

        KieSession inefficient = kc.newKieSession("inefficientSession");
        KieSession optimized = kc.newKieSession("optimizedSession");

        // Génère 1 000 transactions avec les mêmes pays
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            transactions.add(new Transaction("FR", 100 + i));
        }

        // Mesure temps inefficace
        long t1 = System.currentTimeMillis();
        transactions.forEach(inefficient::insert);
        inefficient.fireAllRules();
        inefficient.dispose();
        long t2 = System.currentTimeMillis();

        // Mesure temps optimisé
        long t3 = System.currentTimeMillis();
        transactions.forEach(optimized::insert);
        optimized.fireAllRules();
        optimized.dispose();
        long t4 = System.currentTimeMillis();

        System.out.println("Temps version inefficace: " + (t2 - t1) + " ms");
        System.out.println("Temps version optimisée : " + (t4 - t3) + " ms");
    }
}


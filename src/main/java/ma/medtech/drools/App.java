package ma.medtech.drools;

import ma.medtech.drools.model.Person;

import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.event.rule.DefaultRuleRuntimeEventListener;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class App {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession ksession = kc.newKieSession("rulesSession");

        ksession.addEventListener(new DefaultAgendaEventListener() {
            @Override
            public void matchCreated(MatchCreatedEvent event) {
                System.out.println("[TRACE] Match créé pour règle : " + event.getMatch().getRule().getName());
                List<Object> objects = event.getMatch().getObjects();
                for (Object obj : objects) {
                    System.out.println("[TRACE] Objet dans le match : " + obj);
                }
            }

            @Override
            public void afterMatchFired(AfterMatchFiredEvent event) {
                System.out.println("[TRACE] Règle exécutée : " + event.getMatch().getRule().getName());
            }
        });

        ksession.addEventListener(new DefaultRuleRuntimeEventListener() {
            @Override
            public void objectInserted(ObjectInsertedEvent event) {
                System.out.println("[TRACE] Objet inséré : " + event.getObject());
            }

            @Override
            public void objectUpdated(ObjectUpdatedEvent event) {
                System.out.println("[TRACE] Objet mis à jour : " + event.getObject());
            }

            @Override
            public void objectDeleted(ObjectDeletedEvent event) {
                System.out.println("[TRACE] Objet supprimé : " + event.getOldObject());
            }
        });



        Person p1 = new Person("Alice", 70);
        ksession.insert(p1);
        ksession.fireAllRules();
        ksession.dispose();
    }
}
package ma.medtech.drools;

import ma.medtech.drools.model.WithdrawalEvent;
import java.util.concurrent.TimeUnit;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.conf.ClockTypeOption;
import org.kie.api.time.SessionPseudoClock;

public class App {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();

        KieSessionConfiguration config = ks.newKieSessionConfiguration();
        config.setOption(ClockTypeOption.get("pseudo"));

        KieSession ksession = kc.newKieSession("cepsession", config);
        SessionPseudoClock clock = ksession.getSessionClock();

        WithdrawalEvent w1 = new WithdrawalEvent("Ali", 600.0, System.currentTimeMillis());
        WithdrawalEvent w2 = new WithdrawalEvent("Ali", 700.0, System.currentTimeMillis()+90000); // 1min30 après

        ksession.insert(w1);
        clock.advanceTime(90, TimeUnit.SECONDS); 
        ksession.insert(w2);

        ksession.fireAllRules();
        ksession.dispose();
    }
}
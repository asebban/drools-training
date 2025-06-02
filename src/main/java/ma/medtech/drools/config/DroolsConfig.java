package ma.medtech.drools.config;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {

    @Bean
    public KieContainer kieContainer() {
        KieServices kieServices = KieServices.Factory.get();
        return kieServices
            .newKieClasspathContainer();
    }

    @Bean
    public KieSession kieSession() {
        return kieContainer().newKieSession("ksession-rules");
    }
}
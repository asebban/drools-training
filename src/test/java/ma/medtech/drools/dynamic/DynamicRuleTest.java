package ma.medtech.drools.dynamic;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicRuleTest {

    public static class Product {
        private double price;
        private double discount;

        public Product(double price) {
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }
    }

    @Test
    public void testDynamicRule() {
        String drl = "package rules;\n" +
                     "import " + Product.class.getCanonicalName() + ";\n" +
                     "rule \"Dynamic discount rule\"\n" +
                     "when\n" +
                     "  $p : Product(price > 500)\n" +
                     "then\n" +
                     "  $p.setDiscount(25);\n" +
                     "  System.out.println(\"[Dynamic] Discount applied: \" + $p.getDiscount());\n" +
                     "end";

        KieServices ks = KieServices.Factory.get();
        KieFileSystem kfs = ks.newKieFileSystem();
        kfs.write("src/main/resources/rules/dynamicRule.drl", drl);

        KieBuilder kb = ks.newKieBuilder(kfs).buildAll();
        Results results = kb.getResults();
        if (results.hasMessages(Message.Level.ERROR)) {
            fail("Erreur de compilation des règles: " + results.getMessages());
        }

        KieContainer kc = ks.newKieContainer(ks.getRepository().getDefaultReleaseId());
        KieSession kSession = kc.newKieSession();

        Product product = new Product(1000.0);
        kSession.insert(product);
        kSession.fireAllRules();
        kSession.dispose();

        assertEquals(25.0, product.getDiscount());
    }
}

package cditest;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class StarterClass {

    public static void main(String[] ars){
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        GreetingService greetingService = container.instance().select(GreetingService.class).get();
        System.out.println(greetingService.greet("Alex"));
    }

}

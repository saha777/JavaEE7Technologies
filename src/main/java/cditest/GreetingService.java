package cditest;

import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

@Stateless
public class GreetingService {
    @Inject @Any @Fancy Greeting greeting;

    public String greet(String name){
        return greeting.greet(name);
    }
}

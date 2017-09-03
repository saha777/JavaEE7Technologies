package cditest;

@Fancy
public class FancyGreeting implements Greeting {

    public String greet(String name) {
        return "Hi, " + name;
    }

}

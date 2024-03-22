package pl.kkurowski.creditcard;

import java.util.Collections;

public class App {
    public static void main(String[] args)
    {
        var name = "Krzysztof";
        var message = String.format("Hello %s", name);

        var names = Collections.singletonList("Krzysztof Kurowski");

        System.out.println(message);
    }
}

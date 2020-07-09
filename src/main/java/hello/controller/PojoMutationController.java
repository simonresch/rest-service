package hello.controller;

import hello.model.Greeting;
import hello.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PojoMutationController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private String nullObj = null;

    @PostMapping("/pojo_mutation_list")
    public Greeting crashOnMultipleListEntries(@RequestBody User user) {
        if (user.getJobs() != null && user.getJobs().size() > 1) {
            System.err.println("This is a crash: " + nullObj.charAt(1));
        }
        return new Greeting(counter.incrementAndGet(), String.format(template, user.toString()));
    }

    @PostMapping("/pojo_mutation_strings")
    public Greeting crashOnMultipleStrings(@RequestBody User user) {
        String key1 = "deadbeef";
        String key2 = "ouchfoobar";
        if (user.getFirstName() != null && user.getFirstName().equals(key1))
        {
            System.err.println("Found " + key1 + " id = " + user.getFirstName());
            if (user.getLastName() != null && user.getLastName().equals(key2)) {
                System.err.println("This is a crash: " + nullObj.charAt(1));
            }
        }
        return new Greeting(counter.incrementAndGet(), String.format(template,
                user.getFirstName() != null ? user.getFirstName() : ""));
    }
}

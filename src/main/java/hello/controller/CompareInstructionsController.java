package hello.controller;

import hello.model.Greeting;
import hello.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CompareInstructionsController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private String nullObj = null;

    @RequestMapping("/string_compare")
    public Greeting crashOnString(@RequestParam(value="name", defaultValue="World") String name) {
        if (name.equals("deadbeef")) {
            System.err.println("This is a crash: " + nullObj.charAt(1));
        }
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping("/int_compare")
    public Greeting crashOnInt(@RequestBody User user) {
        if (user.getId() != null && user.getId() == 510072) {
            System.err.println("This is a crash: " + nullObj.charAt(1));
        }
        return new Greeting(counter.incrementAndGet(), String.format(template,
                user.getFirstName() != null ? user.getFirstName() : ""));
    }
}

package hello.controller;

import hello.model.Greeting;
import hello.model.User;
import hello.service.InjectableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SystemTestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    InjectableService injectableService;

    @PostMapping("/system_test")
    public Greeting hiddenSqlInjection(@RequestBody User user) {
        if (user.getJobs() != null && user.getJobs().size() > 1) {
            if (user.getFirstName() != null) {
                User dbUser = injectableService.findUserByName(user.getFirstName());
                return new Greeting(counter.incrementAndGet(), String.format(template, dbUser.toString()));
            }
        }
        return new Greeting(counter.incrementAndGet(), String.format(template, user.toString()));
    }
}

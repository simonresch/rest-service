package hello.controller;

import hello.model.User;
import hello.service.InjectableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InjectionController {
    @Autowired
    InjectableService injectableService;

    @RequestMapping("/sql_injection")
    public User searchVulnerable(@RequestParam String name) {
        return injectableService.findUserByName(name);
    }
}

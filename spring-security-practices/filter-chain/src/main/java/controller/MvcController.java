package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MvcController {
    @GetMapping("/hello")
    public String hello() {
        return "world";
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}

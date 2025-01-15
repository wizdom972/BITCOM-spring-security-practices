package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MvcController {
    @GetMapping("/hello")
    public String test() {
        return "<h1>Hello World</h1>";
    }
}

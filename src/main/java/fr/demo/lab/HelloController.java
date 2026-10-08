package fr.demo.lab;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class HelloController {

    private final HelloService service;

    HelloController(HelloService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    Message hello(@RequestParam(defaultValue = "monde") String name) {
        return new Message(service.greet(name));
    }

    record Message(String text) {}
}

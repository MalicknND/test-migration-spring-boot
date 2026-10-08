package fr.demo.lab;

import org.springframework.stereotype.Service;

@Service
class HelloService {
    String greet(String name) {
        return "Bonjour " + name;
    }
}

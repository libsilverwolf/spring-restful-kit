package io.github.libsilverwolf.restfulkit.spring3x.example;

import io.github.libsilverwolf.restfulkit.spring3x.annotation.EnableRestfulPolyfill;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRestfulPolyfill
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

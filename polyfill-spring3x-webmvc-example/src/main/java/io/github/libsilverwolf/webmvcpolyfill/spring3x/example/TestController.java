package io.github.libsilverwolf.webmvcpolyfill.spring3x.example;

import io.github.libsilverwolf.webmvcpolyfill.spring3x.dto.WebMvcBaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public WebMvcBaseResponse<?> testApi() {
        return WebMvcBaseResponse.success("hello");
    }
}

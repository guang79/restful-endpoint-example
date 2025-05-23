package com.axaxl;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/demo", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AXAXLController {

    @GetMapping("/")
    public String index() {
        return "Hello, this is AXA XL Spring Boot Application";
    }

}

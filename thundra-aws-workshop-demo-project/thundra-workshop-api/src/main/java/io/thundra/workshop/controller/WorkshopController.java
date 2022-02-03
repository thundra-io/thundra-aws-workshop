package io.thundra.workshop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class WorkshopController {

    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }

    @PostMapping("/")
    public String post(@RequestBody String body) {
        return body;
    }

    @GetMapping("/dummy")
    public String dummy() {
        return "Dummy";
    }

}
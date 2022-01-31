package io.thundra.workshop.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class WorkshopController {

    @PostMapping(value = "/")
    public String index(@RequestBody String body) {
        return body;
    }

}
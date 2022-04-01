package com.infogalaxy.springchatapp.controller;

import com.infogalaxy.springchatapp.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

//Rest Controller for Handling all Greeting Message and Generate JSON Response

@RestController
public class GreetingController {

    //String template for generating greeting message
    public static final String template = "Hello, %s !";

    //AtomicLong object for counter increment
    private final AtomicLong counter = new AtomicLong();

    //Mapping greeting with URL to generate the Bean Response in JSON Format
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}

package com.infogalaxy.springchatapp.controller;

import com.infogalaxy.springchatapp.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

//Rest Controller for Handling all Greeting Message and Generate JSON Response

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    //String template for generating greeting message
    public static final String template = "Hello, %s !";

    //AtomicLong object for counter increment
    private final AtomicLong counter = new AtomicLong();

    //Mapping greeting with URL to generate the Bean Response in JSON Format
    //URL - http://localhost:8080/greeting/?name=Tahir
    @RequestMapping(value={"","/"})
    public Greeting greeting(@RequestParam(value="firstname", defaultValue = "World") String firstname) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, firstname));
    }

    //Passing firstname and lastname for user model
    //URL - http://localhost:8080/greeting/user?firstname=Tahir&lastname=Mansuri
    @RequestMapping("/user")
    public Greeting greetingUser(@RequestParam(value="firstname", defaultValue = "Guest") String firstname,
                             @RequestParam(value="lastname", defaultValue = "User") String lastname) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, (firstname+" "+lastname)));
    }

    //Passing firstname and lastname for user model using put method
    //URL - {postman} localhost:8080/greeting/Tahir/?lastname=Mansuri
    @PutMapping("/{firstname}")
    public Greeting greeting(@PathVariable String firstname,
                             @RequestParam(value = "lastname", defaultValue = "User") String lastname) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, (firstname+" "+lastname)));
    }

}

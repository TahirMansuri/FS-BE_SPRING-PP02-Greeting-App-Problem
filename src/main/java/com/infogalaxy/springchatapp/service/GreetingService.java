package com.infogalaxy.springchatapp.service;

import com.infogalaxy.springchatapp.model.Greeting;
import com.infogalaxy.springchatapp.model.User;
import com.infogalaxy.springchatapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {

    //String template for generating greeting message
    public static final String template = "Hello, %s !";

    //AtomicLong object for counter increment
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    //Adding the Greeting Message to Repo for CurdOperation
    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }

    //Accessing the Data and setting in Object for User Response
    @Override
    public Greeting getGreetingById(long id) {
        //findById() for getting data on ID condition
        Greeting greeting = greetingRepository.findById(id).orElse(new Greeting());
        return greeting;
    }
}

package com.infogalaxy.springchatapp.service;

import com.infogalaxy.springchatapp.model.Greeting;
import com.infogalaxy.springchatapp.model.User;

import java.util.List;

public interface IGreetingService {
    Greeting addGreeting(User user);
    Greeting getGreetingById(long id);
    List<Greeting> getAllGretings();
    List<Greeting> getAllGretingsGT3(long id);
    void deleteGreeting(long id);
}

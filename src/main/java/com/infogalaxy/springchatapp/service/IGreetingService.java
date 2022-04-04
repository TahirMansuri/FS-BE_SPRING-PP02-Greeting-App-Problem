package com.infogalaxy.springchatapp.service;

import com.infogalaxy.springchatapp.model.Greeting;
import com.infogalaxy.springchatapp.model.User;

public interface IGreetingService {
    Greeting addGreeting(User user);
    Greeting getGreetingById(long id);
}

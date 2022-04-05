package com.infogalaxy.springchatapp.controller;

import com.infogalaxy.springchatapp.model.Greeting;
import com.infogalaxy.springchatapp.model.User;
import com.infogalaxy.springchatapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Rest Controller for Handling all Greeting Message and Generate JSON Response

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    //Autowiring the Object of GreetingService Interface
    @Autowired
    IGreetingService greetingService;

    //Mapping with URL and getting firstName ans lastName by Query Parameter in GET Method
    //URL - http://localhost:8080/greeting/?firstName=Tahir&lastName=Mansuri
    @GetMapping(value={"","/","/home"})
    public Greeting greeting(@RequestParam(value="firstName", defaultValue = "World") String firstName,
                            @RequestParam(value = "lastName", defaultValue = "") String lastName) {

        //Creting User Model Object and Setting firstName and lastName
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);

        //Invoking GreetingService method to Store User Object
        return greetingService.addGreeting(user);
    }

    //Accessing the Greeting Message from H2DB
    //URL - http://localhost:8080/greeting/getgreeting?id=1
    @RequestMapping("/getgreeting")
    public Greeting getGreeting(@RequestParam int id) {
        return greetingService.getGreetingById(id);
    }


    //Get All Greetings from Database
    //URL - http://localhost:8080/greeting/allgreetings
    @RequestMapping("/allgreetings")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGretings();
    }

    //Get Greeting Messages whose ID is Greater than 3
    @RequestMapping("/allgreetinggt3")
    public List<Greeting> getGreetingGT3(@RequestParam(value="id") long id) {
        return greetingService.getAllGretingsGT3(id);
    }


    //Deleteing the Greeting By ID
    //URL - http://localhost:8080/greeting/deletegreeting/?id=3
    @RequestMapping("/deletegreeting")
    public String deleteGreeting(@RequestParam(value="id") long id){
        greetingService.deleteGreeting(id);
        return "Greeting with ID :"+id+" Deleted.";
    }
    //Mapping greeting with URL to generate the Bean Response in JSON Format
    //URL - http://localhost:8080/greeting/?name=Tahir
//    @RequestMapping(value={"","/"})
//    public Greeting greeting(@RequestParam(value="firstname", defaultValue = "World") String firstname) {
//        return new Greeting(counter.incrementAndGet(),
//                String.format(template, firstname));
//    }

    //Passing firstname and lastname for user model
    //URL - http://localhost:8080/greeting/user?firstname=Tahir&lastname=Mansuri
//    @RequestMapping("/user")
//    public Greeting greetingUser(@RequestParam(value="firstname", defaultValue = "Guest") String firstname,
//                             @RequestParam(value="lastname", defaultValue = "User") String lastname) {
//        return new Greeting(counter.incrementAndGet(),
//                String.format(template, (firstname+" "+lastname)));
//    }

    //Passing firstname and lastname for user model using put method
    //URL - {postman} localhost:8080/greeting/Tahir/?lastname=Mansuri
//    @PutMapping("/{firstname}")
//    public Greeting greeting(@PathVariable String firstname,
//                             @RequestParam(value = "lastname", defaultValue = "User") String lastname) {
//        return new Greeting(counter.incrementAndGet(),
//                String.format(template, (firstname+" "+lastname)));
//    }

}

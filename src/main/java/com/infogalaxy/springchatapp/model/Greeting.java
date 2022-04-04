package com.infogalaxy.springchatapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Model Class for handling Greeting Message Request and Response
@Entity
@Table(name="GREETING")
public class Greeting {

    //@Id specify Column Id for Table
    @Id
    @Column
    private long counter;
    @Column
    private String message;

    public Greeting() {
        counter = 0;
        message = "";
    }

    public Greeting(long counter, String message) {
        this.counter = counter;
        this.message = message;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

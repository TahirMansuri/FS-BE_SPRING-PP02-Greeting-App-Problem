package com.infogalaxy.springchatapp.repository;

import com.infogalaxy.springchatapp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface GreetingRepository extends CrudRepository<Greeting,Long> {
}

package com.infogalaxy.springchatapp.repository;

import com.infogalaxy.springchatapp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting,Long> {
    //List<Greeting> findAllBy();
}

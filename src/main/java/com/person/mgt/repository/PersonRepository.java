package com.person.mgt.repository;


import com.person.mgt.entity.Person;
import com.person.mgt.request.PersonRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
* this is repository class for person extentions.
* */
public interface PersonRepository extends CrudRepository<Person, Long> {

}




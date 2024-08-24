package com.person.mgt.controller;

import com.person.mgt.request.PersonRequest;
import com.person.mgt.response.PersonBaseResponse;
import com.person.mgt.response.PersonResponse;
import com.person.mgt.service.PersonManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* this is controller class.
* */
@RestController
@RequestMapping("/v1/personmanage")
public class PersonManageController {

    @Autowired
    private PersonManageService personManageService;


    /* *
     * this post api is responsible to create person at db.
     * */
    @PostMapping("/createPerson")
   public PersonResponse createPerson(@RequestBody PersonRequest personRequest){
       PersonResponse personResponse = personManageService.createServicePerson(personRequest);
        return personResponse;
    }

    @GetMapping("/getPerson/{id}")
    public PersonBaseResponse getPerson(@PathVariable Long id){

        PersonBaseResponse personBaseResponse =personManageService.getServicePerson(id);
        return personBaseResponse;
    }

    @GetMapping("/getAllPerson")
    public List<PersonBaseResponse> getAllPerson(){
        List<PersonBaseResponse> list1 = personManageService.getAllServicePerson();
        return list1;
    }

    @PutMapping("/updatePerson/{id}")
    public PersonResponse updatePerson(@RequestBody PersonRequest personRequest, @PathVariable Long id ){
     return personManageService.updateServicePerson(id,personRequest);

    }

    @DeleteMapping("/removePerson/{id}")
    public PersonResponse removePerson(@PathVariable Long id){
     return personManageService.removeServicePerson(id);
    }



}

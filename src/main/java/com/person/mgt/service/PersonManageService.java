package com.person.mgt.service;

import com.person.mgt.entity.Person;
import com.person.mgt.repository.PersonRepository;
import com.person.mgt.request.PersonRequest;
import com.person.mgt.response.PersonBaseResponse;
import com.person.mgt.response.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonManageService {

    @Autowired
    private PersonRepository personRepository;

    public PersonResponse createServicePerson(PersonRequest personRequest){
        Person pp = new Person();
        pp.setName(personRequest.getName());
        pp.setAddress(personRequest.getAddress());
        pp.setDateOfBirth(new Date());
        Person p = personRepository.save(pp);
        PersonResponse pr  = new PersonResponse();
        pr.setId(p.getId());
        pr.setMessage("Person created Successfully");
        return pr;
    }

    public PersonBaseResponse getServicePerson(Long id){

        Optional<Person> optionalPerson = personRepository.findById(id);
          Person person = optionalPerson.get();
          PersonBaseResponse personBaseResponse = new PersonBaseResponse();
          personBaseResponse.setId(person.getId());
          personBaseResponse.setName(person.getName());
          personBaseResponse.setAddress(person.getAddress());
          return personBaseResponse;
    }

    public List<PersonBaseResponse> getAllServicePerson(){
            Iterable<Person> iterable = personRepository.findAll();
            List<Person> result = new ArrayList<>();
            for(Person per : iterable)
            {
                result.add(per);
            }
          List<PersonBaseResponse> list1 = result.stream().map(person -> {
                PersonBaseResponse personBaseResponse = new PersonBaseResponse();
                 personBaseResponse.setId(person.getId());
                 personBaseResponse.setName(person.getName());
                 personBaseResponse.setAddress(person.getAddress());
                 return personBaseResponse;
            }).collect(Collectors.toList());

            return list1;






    }
    public PersonResponse updateServicePerson(Long id,PersonRequest personRequest)
    {
        Optional<Person> optionalPerson = personRepository.findById(id);
        Person pt = optionalPerson.get();
      pt.setName(personRequest.getName());
      pt.setAddress((personRequest.getAddress()));
      pt.setDateOfBirth(new Date());
      Person pk = personRepository.save(pt);
      PersonResponse pu = new PersonResponse();
      pu.setId(pk.getId());
        pu.setMessage("Person updated Successfully");
      return pu;
    }
    public PersonResponse removeServicePerson(Long id)
    {
        personRepository.deleteById(id);
        PersonResponse pg = new PersonResponse();
        pg.setMessage("Id is deleted");
        return pg;
    }
}

package com.proj1Spring.services;

import com.proj1Spring.models.BaseResponse;
import com.proj1Spring.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;
import com.proj1Spring.utils.PersonRepository;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
@RestController
public class MainController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/getOne")
    public Person getOne(@RequestParam(value = "id") int id) {
        Person person=personRepository.findById(id).get();
        person.add(linkTo(methodOn(MainController.class).getOne(id)).withSelfRel());
        person.add(linkTo(methodOn(MainController.class).getAll()).withRel("allPerson"));
        person.add(linkTo(MainController.class).slash("add").withRel("add"));
        return person;
    }

    @GetMapping("/getAll")
    public CollectionModel<Person> getAll() {
        List<Person> list=personRepository.findAll();
        for (final Person person : list) {
            person.add(linkTo(methodOn(MainController.class).getOne(person.getId())).withSelfRel());
        }
        CollectionModel<Person> model=CollectionModel.of(list);
        model.add(linkTo(methodOn(MainController.class).getAll()).withSelfRel());
        model.add(linkTo(MainController.class).slash("add").withRel("add"));

        return model;
    }

    @PostMapping("/add")
    public BaseResponse add(@RequestBody Person request) {
        personRepository.save(request);
        BaseResponse baseResponse=new BaseResponse("success", 1);
        baseResponse.add(linkTo(MainController.class).slash("add").withSelfRel());
        baseResponse.add(linkTo(methodOn(MainController.class).getOne(1)).withRel("onePerson"));
        baseResponse.add(linkTo(methodOn(MainController.class).getAll()).withRel("allPerson"));

        return baseResponse;
    }
}

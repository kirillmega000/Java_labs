package com.proj1Spring.services;

import com.proj1Spring.models.BaseResponse;
import com.proj1Spring.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.proj1Spring.utils.PersonRepository;

@RestController
public class MainController {
    @Autowired
    private PersonRepository personRepository;


    @GetMapping("/getOne")
    public Person getOne(@RequestParam(value = "id") int id) {
        return personRepository.findById(id).get();
    }

    @GetMapping("/getAll")
    public Iterable<Person> getAll() {
        return personRepository.findAll();
    }

    @PostMapping("/add")
    public BaseResponse add(@RequestBody Person request) {
        personRepository.save(request);
        return new BaseResponse("success", 1);
    }
}

package com.proj1Spring.utils;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.proj1Spring.models.Person;

public interface PersonRepository extends CrudRepository<Person, Integer>{
}

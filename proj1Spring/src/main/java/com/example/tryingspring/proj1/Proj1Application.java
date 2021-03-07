package com.example.tryingspring.proj1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@SpringBootApplication
@RestController
public class Proj1Application {
	static LinkedList<Person> list=new LinkedList<>();
	public static void main(String[] args) {
		SpringApplication.run(Proj1Application.class, args);
		init();
	}
	private static void init(){
		list.add(new Person("Rulle",50,"roof"));
		list.add(new Person("Fille",70,"kitchen"));
	}
	@GetMapping("/getOne")
	public Person getOne(@RequestParam(value = "name") String name) {
		for(Person it:list){
			if(it.getName().equals(name)) return it;
		}
		return new Person("NotFound",0,"NoWhere");
	}
	@GetMapping("/getAll")
	public LinkedList<Person> getAll(){
		return list;
	}
	@PostMapping("/add")
	public BaseResponse add(@RequestBody Person request){
		list.addLast(request);
		return new BaseResponse("success",1);
	}
}

package com.ifstore.web.comic_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class ComicStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComicStoreApplication.class, args);
	}

	@GetMapping("/hello")
	public String helloWorld(@RequestParam(value = "name", defaultValue = "World") String name){
		return ("hello " + name);
	}
}

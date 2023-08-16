package com.example.demo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@FeignClient(value = "UGD", url = "https://pokeapi.co/api/v2")
@Component
public interface Comunication {
	 @RequestMapping(method = RequestMethod.GET, value ="/pokemon/")
	 Pokemon getAll();
	
	 @RequestMapping(method = RequestMethod.GET, value = "/pokemon/{name}", consumes = "application/json")
	 Object getPokemonByName(@PathVariable("name") String name);
	 
	 @RequestMapping(method = RequestMethod.GET, value = "/pokemon/{id}", consumes = "application/json")
	 Object getPokemonById(@PathVariable("id") int id);

}

package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Controller {

	@Autowired
	private Comunication cm;

	@GetMapping(value = "/getPokemon", produces = "application/json")
	public ResponseEntity<?> getAllPokemon() {
		Pokemon pokemon = cm.getAll();
		return ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(pokemon);
	}

	@GetMapping(value = "/getPokemonById/{id}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> getPokemonById(@PathVariable("id") String id) {

		System.out.println(id);
		int id1 = Integer.parseInt(id);
		Object pokemon = cm.getPokemonById(id1);

		return ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(pokemon);
	}

	@GetMapping(value = "/getPokemonByName/{name}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> getPokemonByName(@PathVariable("name") String name) {
		Pokemon pokemonList = cm.getAll();
		List<Results> results = pokemonList.getResults();
		int id = 1;
		for(var r: results) {
			if (r.getName().equals(name) ) {
				String[] arreglo = r.getUrl().split("/");
				id = Integer.parseInt(arreglo[arreglo.length-1]);
				System.out.println(id);
				break;
			}
		}
		Object pokemon = cm.getPokemonById(id);
		return ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(pokemon);
	}

}

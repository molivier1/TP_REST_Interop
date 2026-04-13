package fr.ensim.interop.introrest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.ensim.interop.introrest.model.Example;

import java.util.UUID;

@RestController
public class ExampleRestController {

	@GetMapping("/example/{pathVar}")
	public ResponseEntity<Example> example(@PathVariable("pathVar") String pathVar,
			@RequestParam("queryVar") String queryVar) {

		Example example = Example.of(pathVar, queryVar);

		return ResponseEntity.ok().body(example);
	}

	@GetMapping("/example")
	public ResponseEntity<String> anotherExample() {
		return ResponseEntity.ok(UUID.randomUUID().toString());
	}

}

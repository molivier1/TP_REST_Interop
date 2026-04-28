package fr.ensim.interop.introrest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.logback.LogbackLoggingSystem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.ensim.interop.introrest.model.Example;

import java.util.UUID;

@RestController
public class ExampleRestController {

	private static final Logger logger = LoggerFactory.getLogger(ExampleRestController.class);

	@GetMapping("/example/{pathVar}")
	public ResponseEntity<Example> example(@PathVariable("pathVar") String pathVar,
			@RequestParam("queryVar") String queryVar) {
		logger.info("Route /example/" + pathVar + "?queryVar=" + queryVar + " used!");

		Example example = Example.of(pathVar, queryVar);

		return ResponseEntity.ok().body(example);
	}

	@GetMapping("/example")
	public ResponseEntity<String> anotherExample() {
		logger.info("Route /example used!");
		return ResponseEntity.ok(UUID.randomUUID().toString());
	}

}

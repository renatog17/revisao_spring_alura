package medi.voli.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//aqui não é mais Srping Boot, e sim Spring MVC
@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping
	public String helloWord() {
		return "Hello Word!";
	}
}

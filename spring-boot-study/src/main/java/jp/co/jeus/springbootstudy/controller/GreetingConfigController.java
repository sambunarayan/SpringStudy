package jp.co.jeus.springbootstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.jeus.springbootstudy.conf.Greeting;

@RestController
@RequestMapping("/greeting-conf")
public class GreetingConfigController {
	
	private final Greeting greeting;

	public GreetingConfigController(Greeting greeting) {
		this.greeting = greeting;
	}
	
	@GetMapping
	public String getGreeting() {
		return greeting.getName();
	}
	
	@GetMapping("/coffee")
	public String getNameAndCoffee() {
		return greeting.getCoffee();
	}
}

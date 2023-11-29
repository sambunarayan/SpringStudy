package jp.co.jeus.springbootstudy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	
	@Value("${greeting-name: Mirage}")
	private String name;
	@Value("${greeting-coffee: ${greeting-name} is drinking cafe}")
	private String coffee;
	
	@GetMapping
	public String getGreeting() {
		return name;
	}
	
	@GetMapping("/coffee")
	public String getNameAndCoffee() {
		return coffee;
	}
}

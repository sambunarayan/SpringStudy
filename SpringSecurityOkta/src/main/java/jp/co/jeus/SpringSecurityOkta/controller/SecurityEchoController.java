package jp.co.jeus.SpringSecurityOkta.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityEchoController {

	@GetMapping("security-echo")
	public String get() {
		return "echo";
	}
	
}

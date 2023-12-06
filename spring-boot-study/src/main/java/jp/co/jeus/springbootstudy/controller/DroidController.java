package jp.co.jeus.springbootstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.jeus.springbootstudy.conf.Droid;

@RestController
@RequestMapping("/droid")
public class DroidController {
	
	private Droid droid;
	
	public DroidController(Droid droid) {
		this.droid = droid;
	}

	@GetMapping
	public Droid get() {
		return droid;
	}
}

package jp.co.jeus.SpringBootReactive.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.jeus.SpringBootReactive.entity.Aircraft;
import jp.co.jeus.SpringBootReactive.service.PlaneFinderService;
import reactor.core.publisher.Flux;

@RestController
public class PlaneController {
	
	@Autowired
	private PlaneFinderService service;

	@GetMapping("current-aircraft")
	public Flux<Aircraft> getCurrentAircraft() throws IOException {
		return service.getAircraft();
	}
}

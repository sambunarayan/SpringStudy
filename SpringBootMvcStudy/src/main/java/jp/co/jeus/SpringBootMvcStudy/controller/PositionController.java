package jp.co.jeus.SpringBootMvcStudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

import jp.co.jeus.SpringBootMvcStudy.domain.Aircraft;
import jp.co.jeus.SpringBootMvcStudy.repository.AircraftRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PositionController {

	@NonNull
	private final AircraftRepository repository;
	private WebClient client = WebClient.create("http://localhost:7634/aircraft");
	
	@GetMapping("/aircraft")
	public String getCurrentAircraftPositions(Model model) {
		repository.deleteAll();
		
		client.get()
			.retrieve()
			.bodyToFlux(Aircraft.class)
			.filter(plane -> !plane.getReg().isEmpty())
			.toStream()
			.forEach(repository::save);
		model.addAttribute("currentPositions", repository.findAll());
		return "positions";
	}
}

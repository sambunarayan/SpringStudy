package jp.co.jeus.SpringJpaStudy.components;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import jp.co.jeus.SpringJpaStudy.entity.Aircraft;
import jp.co.jeus.SpringJpaStudy.repository.AircraftRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableScheduling
@Component
public class PlaneFinder {

	@NonNull
	private AircraftRepository repository;
	private WebClient client = 
			WebClient.create("http://localhost:7634/aircraft");
	
	@Scheduled(fixedRate = 1000)
	private void pollPlanes() {
		repository.deleteAll();
		
		client.get()
			.retrieve()
			.bodyToFlux(Aircraft.class)
			.filter(plane -> !plane.getReg().isEmpty())
			.toStream()
			.forEach(repository::save);
		repository.findAll().forEach(System.out::println);
	}
}

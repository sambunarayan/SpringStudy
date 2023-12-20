package jp.co.jeus.SpringMongoStudy.components;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import jp.co.jeus.SpringMongoStudy.domain.Aircraft;
import jp.co.jeus.SpringMongoStudy.repository.AircraftRepository;

@Component
@EnableScheduling
public class PlaneFinderPoller {

	private WebClient client = WebClient.create("http://localhost:7634/aircraft");
	private AircraftRepository repository;
	
	public PlaneFinderPoller(AircraftRepository repository) {
		this.repository = repository;
	}
	
	
	@Scheduled(fixedRate = 1000)
	private void pollPanes() {
		repository.deleteAll();
		
		client.get()
			.retrieve()
			.bodyToFlux(Aircraft.class)
			.filter(plane -> !plane.getReg().isEmpty())
			.toStream()
			.forEach(repository::save);
		
		System.out.println("---- All aircraft ----");
		repository.findAll().forEach(System.out::println);
	}
}

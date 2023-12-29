package jp.co.jeus.SpringNeo4jStudy.component;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import jp.co.jeus.SpringNeo4jStudy.domain.Aircraft;
import jp.co.jeus.SpringNeo4jStudy.repository.AircraftRepository;

@EnableScheduling
@Component
public class PlaneFinderPoller {
	
	private AircraftRepository aircraftRepository;
	private WebClient webClient = WebClient.create("http://localhost:7634/aircraft");
	
	public PlaneFinderPoller(AircraftRepository aircraftRepository) {
		this.aircraftRepository = aircraftRepository;
	}
	
	@Scheduled(fixedRate = 1000)
	private void pollPlanes() {
		aircraftRepository.deleteAll();
		
		webClient.get()
			.retrieve()
			.bodyToFlux(Aircraft.class)
			.filter(plane -> !plane.getReg().isEmpty())
			.toStream()
			.forEach(aircraftRepository::save);
		
		System.out.println("--- All aircraft ---");
		aircraftRepository.findAll().forEach(System.out::println);
	}

}

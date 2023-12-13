package jp.co.jeus.SpringDataStudy.components;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import jp.co.jeus.SpringDataStudy.entity.Aircraft;
import jp.co.jeus.SpringDataStudy.repository.AircraftRepository;

@EnableScheduling
@Component
public class PlaneFinderRepPoller {

	private WebClient webClient = WebClient.create("http://localhost:7634/aircraft");
	private final AircraftRepository repository;
	private final RedisConnectionFactory connectionFactory;

	PlaneFinderRepPoller(AircraftRepository repository, RedisConnectionFactory  connectionFactory) {
		this.repository = repository;
		this.connectionFactory = connectionFactory;
	}

	@Scheduled(fixedRate = 1000)
	private void pollPlanes() {
		connectionFactory.getConnection().serverCommands().flushDb();
		
		webClient.get()
			.retrieve()
			.bodyToFlux(Aircraft.class)
			.filter(plane -> !plane.getReg().isEmpty())
			.toStream()
			.forEach(repository::save);
		repository.findAll().forEach(System.out::println);
	}
}

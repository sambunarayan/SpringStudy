package jp.co.jeus.SpringBootReactive.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import io.r2dbc.spi.ConnectionFactory;
import jp.co.jeus.SpringBootReactive.entity.Aircraft;
import jp.co.jeus.SpringBootReactive.repository.PlaneRepository;

@Configuration
public class DbConxInit {

	@Bean
	public ConnectionFactoryInitializer initializer(
			@Qualifier("connectionFactory") ConnectionFactory connectionFactory) {
		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
		initializer.setConnectionFactory(connectionFactory);
		initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
		return initializer;
	}

//	@Bean
	public CommandLineRunner init(PlaneRepository repo) {
		return args -> {
			repo.save(new Aircraft("SAL001", "N12345", "SAL001", "LJ",
					30000, 30, 300,
					38.7209228, -90.4107461))
			.thenMany(repo.findAll())
			.subscribe(System.out::println);
				
		};
	}
}

package jp.co.jeus.aircraft;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.jeus.aircraft.entity.Aircraft;

@RestController
@SpringBootApplication
public class SpringDataStudyApplication {

	@GetMapping("aircraft")
	public List<Aircraft> get() {
		Aircraft a = new Aircraft();
		a.setId((long) (Math.random() * 10000));
		a.setReg("reg");
		a.setType("type");
		a.setPosUpdateTime(LocalDateTime.now().toString());
		a.setSquawk("Squawk");
		a.setCallsign("category11");
		return List.of(a);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataStudyApplication.class, args);
	}

}

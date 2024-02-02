package jp.co.jeus.aircraft;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.jeus.aircraft.dto.AircraftResponseDto;
import jp.co.jeus.aircraft.entity.Aircraft;


@RestController
@SpringBootApplication
public class SpringDataStudyApplication {

	@GetMapping("aircraft")
	public List<Aircraft> get() {
		int size = (int) (Math.random() * 10);
		List<Aircraft> res = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			res.add(getAircraft());
		}
		System.out.println(res);
		return res;
	}
	
	@GetMapping("ajax/aircraft")
	public AircraftResponseDto getByAjax() {
		return new AircraftResponseDto(getAircraft());
	}
	
	private Aircraft getAircraft() {
		Aircraft a = new Aircraft();
		a.setId((long) (Math.random() * 10000));
		a.setFlightno(String.valueOf((long) (Math.random() * 10000)));
		a.setRoute("A route");
		a.setCategory("category");
		a.setLastSeenTime(String.valueOf(System.currentTimeMillis()));
		a.setBds40SeenTime(String.valueOf(System.currentTimeMillis()));
		a.setReg("reg");
		a.setType("type");
		a.setPosUpdateTime(String.valueOf(System.currentTimeMillis()));
		a.setSpeed((int) (Math.random() * 1000));
		a.setVertRate((int) (Math.random() * 1000));
		a.setLat(Math.random() * 100);
		a.setLon(Math.random() * 100);
		a.setSquawk("Squawk");
		a.setCallsign("Call - " + String.valueOf((long) (Math.random() * 10000)));
		return a;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataStudyApplication.class, args);
	}

}

package jp.co.jeus.SpringDataStudy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;

import jp.co.jeus.aircraft.SpringDataStudyApplication;
import jp.co.jeus.aircraft.controller.AircraftController;
import jp.co.jeus.aircraft.entity.Aircraft;
import jp.co.jeus.aircraft.service.AircrftFinderService;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureWebTestClient
@WebFluxTest(AircraftController.class)
@ContextConfiguration(classes = SpringDataStudyApplication.class)
class AircraftControllerTests {

	@MockBean
	private AircrftFinderService service;

	private Aircraft a1;
	private Aircraft a2;

	@BeforeEach
	public void setUp() {
		a1 = getMockAircraft();
		a2 = getMockAircraft();
		Mockito.when(service.findAircraft()).thenReturn(List.of(a1, a2));
	}

	@Test
	void findAircraft(@Autowired WebTestClient client) {
		assert client.get()
				.uri("/aircraft")
				.exchange()
				.expectStatus().isOk()
				.expectBody(Iterable.class)
				.returnResult()
				.getResponseBody()
				.iterator()
				.hasNext();
	}
	
	@Test
	void findAircraftVerifyResult(@Autowired WebTestClient client) {
		Iterable<Aircraft> resultList = client.get()
				.uri("/aircraft")
				.exchange()
				.expectStatus().isOk()
				.expectBody(Iterable.class)
				.returnResult()
				.getResponseBody();
		assertEquals(List.of(a1, a2), resultList);
	}

	private Aircraft getMockAircraft() {
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
		
}

package jp.co.jeus.aircraft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.jeus.aircraft.dto.AircraftResponseDto;
import jp.co.jeus.aircraft.entity.Aircraft;
import jp.co.jeus.aircraft.service.AircrftFinderService;

@RestController
public class AircraftController {

	@Autowired
	private AircrftFinderService service;

	@GetMapping("aircraft")
	public Iterable<Aircraft> get() {
		return service.findAircraft();
	}

	@GetMapping("ajax/aircraft")
	public AircraftResponseDto getByAjax() {
		return service.getByAjax();
	}

}

package jp.co.jeus.aircraft.dto;

import jp.co.jeus.aircraft.entity.Aircraft;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AircraftResponseDto {
	
	private Aircraft aircraft;
}

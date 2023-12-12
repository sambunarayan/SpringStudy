package jp.co.jeus.aircraft.entity;

import java.time.Instant;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Aircraft {
	
	@Id
	private Long id;
	private String callsign, squawk, reg, flightno, route, type, category;
	private int altitude, heading, speed;
	@JsonProperty("vert_rate")
	private int vertRate;
	@JsonProperty("selected_altitude")
	private int selectedAltitude;
	private double lat, lon, barometer;
	@JsonProperty("polar_distance")
	private double polarDistance;
	@JsonProperty("polar_bearing")
	private double polarBearing;
	@JsonProperty("is_adsb")
	private boolean isADSB;
	@JsonProperty("is_on_ground")
	private boolean isOnGround;
	@JsonProperty("last_seen_time")
	private String lastSeenTime;
	@JsonProperty("pos_update_time")
	private String posUpdateTime;
	@JsonProperty("bds40_seen_time")
	private String bds40SeenTime;
	
}

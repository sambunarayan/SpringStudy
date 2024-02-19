package jp.co.jeus.SpringSecurityStudy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class SecurityResponseDto {

	private String status;
	private String details;
}

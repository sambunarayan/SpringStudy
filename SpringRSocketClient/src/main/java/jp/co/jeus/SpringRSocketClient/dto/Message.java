package jp.co.jeus.SpringRSocketClient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Message {

	private String username;
	private String message;
}

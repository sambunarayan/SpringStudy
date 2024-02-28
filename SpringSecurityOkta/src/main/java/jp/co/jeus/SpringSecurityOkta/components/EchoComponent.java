package jp.co.jeus.SpringSecurityOkta.components;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EchoComponent {
	private final WebClient client;
	
	
}

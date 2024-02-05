package jp.co.jeus.SpringRSocketClient.controller;

import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.jeus.SpringRSocketClient.dto.Message;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RequestController {


private final RSocketRequester rocketRequester;
	
	public RequestController(RSocketRequester rocketRequester) {
		this.rocketRequester = rocketRequester;
	}
	
	@GetMapping("rsocket-req")
	public void requestResponse() {
		log.info("Sending one request. Waiting for one response...");
		
		this.rocketRequester.route("request-response")
			.data(new Message("superpil","client"))
			.retrieveMono(Message.class)
			.log()
			.block();
	}
}

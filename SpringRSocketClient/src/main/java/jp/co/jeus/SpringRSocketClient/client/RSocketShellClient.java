package jp.co.jeus.SpringRSocketClient.client;

import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import jp.co.jeus.SpringRSocketClient.dto.Message;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ShellComponent
public class RSocketShellClient {

	private final RSocketRequester rocketRequester;
	
	public RSocketShellClient(RSocketRequester rocketRequester) {
		this.rocketRequester = rocketRequester;
	}
	
	@ShellMethod("Send one request. One response will be printed.")
	public void req() {
		log.info("Sending one request. Waiting for one response...");
		
		this.rocketRequester.route("request-response")
			.data(new Message("superpil","client"))
			.retrieveMono(Message.class)
			.log()
			.block();
	}
	
	@ShellMethod("test shell")
	public void sum() {
		log.info("Test shell done.");
	}
}

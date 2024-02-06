package jp.co.jeus.SpringRSocketClient.client;

import java.time.Duration;

import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import jp.co.jeus.SpringRSocketClient.dto.Message;
import lombok.extern.slf4j.Slf4j;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@ShellComponent
public class RSocketShellClient {

	private final RSocketRequester rocketRequester;
	private Disposable disposable;

	public RSocketShellClient(RSocketRequester rocketRequester) {
		this.rocketRequester = rocketRequester;
	}

	@ShellMethod("Send one request. One response will be printed.")
	public void reqAndRes() {
		log.info("Sending one request. Waiting for one response...");

		this.rocketRequester.route("request-response")
				.data(new Message("superpil", "client"))
				.retrieveMono(Message.class)
				.log()
				.block();
	}

	@ShellMethod("Send one request. No response will be returned.")
	public void fireAndForget() throws InterruptedException {
		log.info("Fire-And-Forget. Sending one request. Expect no response (check server log)...");
		this.rocketRequester.route("fire-and-forget")
				.data(new Message("superpil", "client"))
				.send()
				.block();
	}

	// stream start
	@ShellMethod("Send one request. Many responses (stream) will be printed.")
	public void reqStr() {
		log.info("Request-Stream. Sending one request. Waiting for unlimited responses (Stop process to quit)...");
		this.disposable = this.rocketRequester.route("stream")
				.data(new Message("superpil", "client"))
				.retrieveFlux(Message.class)
				.log()
				.subscribe();
	}

	// channel
	@ShellMethod("Stream some settings to the server. Stream of responses will be printed.")
	public void channel() {
		Mono<Duration> setting1 = Mono.just(Duration.ofSeconds(1));
		Mono<Duration> setting2 = Mono.just(Duration.ofSeconds(3)).delayElement(Duration.ofSeconds(5));
		Mono<Duration> setting3 = Mono.just(Duration.ofSeconds(5)).delayElement(Duration.ofSeconds(15));
		Flux<Duration> settings = Flux.concat(setting1, setting2, setting3)
				.doOnNext(d -> log.info("Sending setting for {}-second interval.", d.getSeconds()));

		disposable = this.rocketRequester.route("channel")
				.data(settings)
				.retrieveFlux(Message.class)
				.log()
				.subscribe();
	}

	// stop
	@ShellMethod("Stop streaming messages from the server.")
	public void reqStop() {
		if (null != disposable)
			disposable.dispose();
	}
}

package jp.co.jeus.SpringRsocketServer.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import jp.co.jeus.SpringRsocketServer.dto.Message;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class RSocketController {

	@MessageMapping("request-response")
	public Message requestResponse(Message request) {
		log.info("Received request-response :{}", request);
		return new Message("superpil", "server");
	}
}

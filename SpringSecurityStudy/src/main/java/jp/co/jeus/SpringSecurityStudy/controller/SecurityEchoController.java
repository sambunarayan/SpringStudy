package jp.co.jeus.SpringSecurityStudy.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.jeus.SpringSecurityStudy.dto.SecurityResponseDto;

@RestController
public class SecurityEchoController {

	@GetMapping("security-echo")
	public String get() {
		return "echo";
	}
	
	@GetMapping("security-admin")
	public Iterable<SecurityResponseDto> getList() {
		return List.of(new SecurityResponseDto("NORMAL", "details1"), new SecurityResponseDto("ABNORMAL", "details2"));
	}
}

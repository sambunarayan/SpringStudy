package jp.co.jeus.springbootstudy.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class Coffee {
	
	private final String id;
	private String name;
	
	public Coffee(String id, String name) {
		this.id = id;
		this.setName(name);
	}
	
	public Coffee(String name) {
		this(UUID.randomUUID().toString(), name);
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

package jp.co.jeus.springbootstudy.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Coffee {
	
	@Id
	private String id;
	private String name;
	
	public Coffee() {
		
	}
	
	public Coffee(String id, String name) {
		this.id = id;
		this.setName(name);
	}
	
	public Coffee(String name) {
		this(UUID.randomUUID().toString(), name);
	}
	
	public void setId(String id) {
		this.id = id;
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

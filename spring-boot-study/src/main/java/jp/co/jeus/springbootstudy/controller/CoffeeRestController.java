package jp.co.jeus.springbootstudy.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.jeus.springbootstudy.dto.Coffee;

@RestController
@RequestMapping("/coffees")
public class CoffeeRestController {
	
	private List<Coffee> coffeeList = new ArrayList<>();
	
	public CoffeeRestController() {
		coffeeList.addAll(List.of(new Coffee("1", "Americano"), new Coffee("2", "Coldblew"), new Coffee("3", "Moca")));
	}
	
	@GetMapping
	public Iterable<Coffee> get() {
		return coffeeList;
	}
	
	@GetMapping("/{id}")
	public Optional<Coffee> get(@PathVariable String id) {
		return coffeeList.stream().filter(c -> c.getId().equals(id)).findFirst();
	}
	
	@PostMapping
	public Coffee post(@RequestBody Coffee coffee) {
		coffeeList.add(coffee);
		return coffee;
	}
	
	@PutMapping("/{id}")
	public Coffee put(@PathVariable String id, @RequestBody Coffee coffee) {
		Optional<Coffee> op = coffeeList.stream().filter(c -> c.getId().equals(id)).findFirst();
		if (!op.isPresent()) {
			return post(coffee);
		}
		op.get().setName(coffee.getName());
		return coffee;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		coffeeList.removeIf(c -> c.getId().equals(id));
	}
}

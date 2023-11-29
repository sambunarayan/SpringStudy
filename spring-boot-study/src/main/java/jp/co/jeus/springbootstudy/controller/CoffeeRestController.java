package jp.co.jeus.springbootstudy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.jeus.springbootstudy.entity.Coffee;
import jp.co.jeus.springbootstudy.repository.CoffeeRepository;

@RestController
@RequestMapping("/coffees")
public class CoffeeRestController {
	
	private CoffeeRepository coffeeRepository;

	public CoffeeRestController(CoffeeRepository coffeeRepository) {
		this.coffeeRepository = coffeeRepository;
		this.coffeeRepository.saveAll(List.of(new Coffee("Americano"), new Coffee("Coldblew"), new Coffee("Moca")));
	}

	@GetMapping
	public Iterable<Coffee> get() {
		return coffeeRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Coffee> get(@PathVariable String id) {
		return coffeeRepository.findById(id);
	}

	@PostMapping
	public Coffee post(@RequestBody Coffee coffee) {
		coffeeRepository.save(coffee);
		return coffee;
	}

	@PutMapping("/{id}")
	public ResponseEntity<Coffee> put(@PathVariable String id, @RequestBody Coffee coffee) {
		return (!coffeeRepository.existsById(id))
				? new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED)
				: new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		coffeeRepository.deleteById(id);
	}
}

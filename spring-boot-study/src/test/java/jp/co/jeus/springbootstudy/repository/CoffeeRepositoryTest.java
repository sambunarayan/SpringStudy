package jp.co.jeus.springbootstudy.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import jp.co.jeus.springbootstudy.entity.Coffee;

@DataJpaTest
class CoffeeRepositoryTest {
	
	@Autowired
	private CoffeeRepository repository;
	private Coffee c1, c2;

	@BeforeEach
	void setUp() throws Exception {
		c1 = new Coffee("ID_1", "americano");
		c2 = new Coffee("ID_2", "latte");
		repository.saveAll(List.of(c1, c2));
	}

	@AfterEach
	void tearDown() throws Exception {
		repository.deleteAll();
	}

	@Test
	void test() {
		List<Coffee> expected = List.of(c1, c2);
		Iterable<Coffee> actual = repository.findAll();
		int i = 0;
		for (Coffee c : actual) {
			assertEquals(c.getId(), expected.get(i).getId());
			assertEquals(c.getName(), expected.get(i++).getName());
		}
		
		assertIterableEquals(List.of(c1, c2), repository.findAll());
	}

}

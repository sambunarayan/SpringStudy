package jp.co.jeus.SpringKafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.jeus.SpringKafka.producer.HelloKafka;

@Controller
@SpringBootApplication
public class SpringKafkaApplication {
	
	@Autowired
	private HelloKafka kafka;
	
	@GetMapping("kafka/get")
	public void get() {
		kafka.helloKafka();
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaApplication.class, args);
	}

}

package jp.co.jeus.SpringKafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class HelloKafka {
	
	@Autowired
    KafkaTemplate<String, String> template;
	

    public void helloKafka(){
    	System.out.println("hello kafka");
        template.send("sample", "value").thenAccept(System.out::println);
        
    }
}

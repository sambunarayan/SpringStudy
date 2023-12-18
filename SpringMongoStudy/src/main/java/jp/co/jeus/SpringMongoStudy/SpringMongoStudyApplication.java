package jp.co.jeus.SpringMongoStudy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bson.Document;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.mongo.transitions.MongodStarter;

@RestController
@SpringBootApplication
public class SpringMongoStudyApplication {
	
	@GetMapping("get")
	public String get() {
		return "success";
	}

	public static void main(String[] args) {
		MongodStarter starter = MongodStarter.getDefaultInstance();

        int port = 12345;
        IMongodConfig mongodConfig =
                new MongodConfigBuilder()
                        .version(Version.Main.PRODUCTION)
                        .net(new Net(port, Network.localhostIsIPv6()))
                        .build();

        MongodExecutable mongodExecutable = null;

        try {
            mongodExecutable = starter.prepare(mongodConfig);
            MongodProcess mongod = mongodExecutable.start();

            // MongoDBのドライバを使ったコード
            try (MongoClient client = new MongoClient("localhost", port)) {
                MongoDatabase database = client.getDatabase("testDatabase");
                MongoCollection<Document> collection = database.getCollection("testCollection");

                Map<String, Object> docSeed1 = new HashMap<>();
                docSeed1.put("name", "磯野カツオ");
                docSeed1.put("age", 11);

                Map<String, Object> docSeed2 = new HashMap<>();
                docSeed2.put("name", "磯野ワカメ");
                docSeed2.put("age", 9);

                Arrays.asList(docSeed1, docSeed2).forEach(d -> collection.insertOne(new Document(d)));

                FindIterable<Document> iterable = collection.find(new Document("name", "磯野カツオ"));
                iterable.forEach((Block<Document>) (d -> System.out.println("doc = " + d)));
            }

            mongod.stop();
        } finally {
            if (mongodExecutable != null) {
                mongodExecutable.stop();
            }
        }
	}

}

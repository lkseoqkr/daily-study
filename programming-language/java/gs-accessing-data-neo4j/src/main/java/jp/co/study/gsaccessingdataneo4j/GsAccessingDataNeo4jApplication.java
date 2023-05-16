package jp.co.study.gsaccessingdataneo4j;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootApplication
@EnableNeo4jRepositories
public class GsAccessingDataNeo4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(GsAccessingDataNeo4jApplication.class, args);
		System.exit(0);
	}

	@Bean CommandLineRunner demo(PersonRepository personRepository) {
		return args -> {
			personRepository.deleteAll();

			Person greg = new Person("Greg");
			Person roy = new Person("roy");
			Person craig = new Person("craig");

			List<Person> team = Arrays.asList(greg, roy, craig);

			log.info("Before linking up with Neo4j...");

			team.stream().forEach(person -> log.info("\t" + person.toString()));

			personRepository.save(greg);
			personRepository.save(roy);
			personRepository.save(craig);

			greg = personRepository.findByName(greg.getName());
			greg.worksWith(roy);
			greg.worksWith(craig);
			personRepository.save(greg);

			roy = personRepository.findByName(roy.getName());
			roy.worksWith(craig);
			personRepository.save(roy);

			log.info("Lookup each person by name...");
			team.stream().forEach(person -> log.info("\t" + personRepository.findByName(person.getName()).toString()));
			List<Person> teammates = personRepository.findByTeammatesName(greg.getName());
			log.info("The following have Greg as a teammate...");
			teammates.stream().forEach(person -> log.info("\t" + person.getName()));
		};
	}

}

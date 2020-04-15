package au.com.tml.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringThymeleafExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringThymeleafExampleApplication.class, args);
	}

}

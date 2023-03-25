package eng.cpe.se.project.alllearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("eng.cpe.se.project")
@EnableJpaRepositories("eng.cpe.se.project.repository")
public class AlllearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlllearnApplication.class, args);
	}
}

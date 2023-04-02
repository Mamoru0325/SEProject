package eng.cpe.se.project.alllearn;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import eng.cpe.se.project.service.FileStorageService;
import eng.cpe.se.project.service.ImgPostService;
import eng.cpe.se.project.service.PaymentCheckService;
import eng.cpe.se.project.service.UserService;



@SpringBootApplication
@ComponentScan("eng.cpe.se.project")
@EnableJpaRepositories("eng.cpe.se.project.repository")
public class AlllearnApplication implements CommandLineRunner {
	@Resource
	FileStorageService storageService;
	@Resource
	UserService userService;
	@Resource
	ImgPostService imgPostService;
	@Resource
	PaymentCheckService paymentCheckService;

	public static void main(String[] args) {
		SpringApplication.run(AlllearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		storageService.init();
		userService.init();
		imgPostService.init();
		paymentCheckService.init();
	}
}

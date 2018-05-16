package ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class PhotoApplication {
	public static void main(String[] args) {
		SpringApplication.run(PhotoApplication.class, args);
	}
}

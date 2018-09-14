package demo.rbacapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the starting class for the main application. It does a lot of things under the hood.
 * It is a combination of 3 annotations - @Configuration @EnableAutoConfiguration @ComponentScan
 * 
 * To run the application: mvn spring-boot:run
 * 
 * @author sburnwal
 */
@SpringBootApplication	/* Same as @Configuration @EnableAutoConfiguration @ComponentScan */
public class Application {
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}

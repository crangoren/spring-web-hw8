package rksuleimanov.springwebhw8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rksuleimanov.springwebhw8.utils.SessionFactoryUtils;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);

		SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
		sessionFactoryUtils.init();
	}

}

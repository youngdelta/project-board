package com.fastcampus.projectboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;

@ConfigurationPropertiesScan
@SpringBootApplication
public class FastcampusProjectBoardApplication {

	public static void main(String[] args) {
//		ConfigurableApplicationContext applicationContext =
		SpringApplication.run(FastcampusProjectBoardApplication.class, args);
//		SpringApplication.run(FastcampusProjectBoardApplication.class, args).close();

//		applicationContext.close();
/*

		try (ConfigurableApplicationContext applicationContext =
					 SpringApplication.run(FastcampusProjectBoardApplication.class, args)){
			applicationContext.close();
		}
*/

	}

}

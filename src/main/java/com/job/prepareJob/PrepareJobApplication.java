package com.job.prepareJob;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableRabbit
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class PrepareJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrepareJobApplication.class, args);
	}

}

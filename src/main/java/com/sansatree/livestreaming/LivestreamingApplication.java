package com.sansatree.livestreaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class LivestreamingApplication{

	public static void main(String[] args) {
		SpringApplication.run(LivestreamingApplication.class, args);

	}

}

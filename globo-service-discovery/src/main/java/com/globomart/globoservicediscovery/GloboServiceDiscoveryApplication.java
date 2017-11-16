package com.globomart.globoservicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author divakar
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class GloboServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(GloboServiceDiscoveryApplication.class, args);
	}
}

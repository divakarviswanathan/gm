package com.globomart.requestrouter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author divakar
 *
 */
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class RequestRouterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequestRouterApplication.class, args);
	}

}

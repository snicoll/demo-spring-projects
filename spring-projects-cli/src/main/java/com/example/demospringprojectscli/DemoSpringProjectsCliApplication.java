package com.example.demospringprojectscli;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class DemoSpringProjectsCliApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringProjectsCliApplication.class, args);
	}

	@Bean
	ApplicationRunner cli(SpringProjectsClient client) {
		return args -> System.out.println(client.getProjectSummary("spring-boot"));
	}

	@Bean
	SpringProjectsClient springProjectsClient(HttpServiceProxyFactory httpServiceProxyFactory) {
		return httpServiceProxyFactory.createClient(SpringProjectsClient.class);
	}

	@Bean
	HttpServiceProxyFactory httpServiceProxyFactory(WebClient.Builder webClientBuilder) {
		WebClientAdapter clientAdapter = WebClientAdapter
			.forClient(webClientBuilder.baseUrl("http://localhost:8080").build());
		return HttpServiceProxyFactory.builder(clientAdapter).build();
	}

}

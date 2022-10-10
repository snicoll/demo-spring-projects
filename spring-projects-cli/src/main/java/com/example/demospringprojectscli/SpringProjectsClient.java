package com.example.demospringprojectscli;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface SpringProjectsClient {

	@GetExchange("/spring-projects/{projectId}")
	ProjectSummary getProjectSummary(@PathVariable String projectId);

	record ProjectSummary(String id, String name) {
	}

}

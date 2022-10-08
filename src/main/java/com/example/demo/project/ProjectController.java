package com.example.demo.project;

import java.util.List;

import com.example.demo.project.Release.Status;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {


	@GetMapping("/spring-projects/{projectId}")
	ProjectSummary get(@PathVariable String projectId) {
		return new ProjectSummary(projectId, projectId);
	}

	@GetMapping("/spring-projects/{projectId}/releases")
	ProjectReleases getReleases(String projectId) {
		return new ProjectReleases(List.of(new Release("2.3.4", Status.MILESTONE, false)));
	}

}

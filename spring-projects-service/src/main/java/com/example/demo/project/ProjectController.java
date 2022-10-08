package com.example.demo.project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

	private final Projects projects;

	public ProjectController(Projects projects) {
		this.projects = projects;
	}

	@GetMapping("/spring-projects/{slug}")
	ProjectSummary get(@PathVariable String slug) {
		return this.projects.findProjectBySlug(slug);
	}

	@GetMapping("/spring-projects/{slug}/releases")
	ProjectReleases getReleases(@PathVariable String slug) {
		return this.projects.findReleasesByProjectSlug(slug);
	}

}

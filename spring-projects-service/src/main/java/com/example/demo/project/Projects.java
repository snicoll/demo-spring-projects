package com.example.demo.project;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
class Projects {

	private final Map<String, ProjectSummary> projectData = Map.of("spring-framework",
			new ProjectSummary("spring-framework", "Spring Framework"), "spring-boot",
			new ProjectSummary("spring-boot", "Spring Boot"));

	private final Map<String, ProjectReleases> releaseData = Map.of("spring-framework",
			new ProjectReleases(List.of(
					new ProjectReleases.Release("5.3.23", ProjectReleases.Release.Status.GENERALLY_AVAILABLE, true),
					new ProjectReleases.Release("6.0.0-M6", ProjectReleases.Release.Status.MILESTONE, false))),
			"spring-boot",
			new ProjectReleases(List.of(
					new ProjectReleases.Release("2.7.4", ProjectReleases.Release.Status.GENERALLY_AVAILABLE, true),
					new ProjectReleases.Release("3.0.0-M5", ProjectReleases.Release.Status.MILESTONE, false))));

	ProjectSummary findProjectBySlug(String slug) {
		if (!this.projectData.containsKey(slug)) {
			throw new UnknownProjectException(slug);
		}
		return this.projectData.get(slug);
	}

	ProjectReleases findReleasesByProjectSlug(String slug) {
		if (!this.releaseData.containsKey(slug)) {
			throw new UnknownProjectException(slug);
		}
		return this.releaseData.get(slug);
	}

}

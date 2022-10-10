package com.example.demo.project;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
class ProjectApiControllerAdvice {

	@ExceptionHandler(UnknownProjectException.class)
	ProblemDetail handleUnknownProjectException(UnknownProjectException exc) {
		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
		problemDetail.setTitle("Unknown Project");
		problemDetail.setType(URI.create("https://example.org/problems/unknown-project"));
		problemDetail.setDetail(String.format("No project found with slug '%s'", exc.getSlug()));
		return problemDetail;
	}

}

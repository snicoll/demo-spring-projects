package com.example.demo.project;

public class UnknownProjectException extends RuntimeException {

	private final String slug;

	public UnknownProjectException(String slug) {
		super("No project found with slug '" + slug + "'");
		this.slug = slug;
	}

	public String getSlug() {
		return this.slug;
	}

}

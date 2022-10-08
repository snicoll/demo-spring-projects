package com.example.demo.project;

public record Release(String version, Status status, boolean current) {

	public enum Status {

		SNAPSHOT,

		MILESTONE,

		GENERALLY_AVAILABLE

	}

}

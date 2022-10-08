package com.example.demo.project;

import java.util.List;

public record ProjectReleases(List<Release> releases) {


	public record Release(String version, Status status, boolean current) {

		public enum Status {

			SNAPSHOT,

			MILESTONE,

			RELEASE_CANDIDATE,

			GENERALLY_AVAILABLE

		}

	}

}

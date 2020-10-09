package com.regex.assignment.model;

public class RegexResponse {

	private String match;
	private boolean error;

	public RegexResponse(String match, boolean error) {
		super();
		this.match = match;
		this.error = error;
	}

	public String getMatch() {
		return match;
	}

	public void setMatch(String match) {
		this.match = match;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

}

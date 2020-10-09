package com.regex.assignment.model;

public class RegexRequest {

	private String regex;
	private String textBody;

	public RegexRequest(String regex, String textBody) {
		super();
		this.regex = regex;
		this.textBody = textBody;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public String getTextBody() {
		return textBody;
	}

	public void setTextBody(String textBody) {
		this.textBody = textBody;
	}
}

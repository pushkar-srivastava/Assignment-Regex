package com.regex.assignment.services;

import com.regex.assignment.model.RegexResponse;


public interface RegexService {

	RegexResponse timedPatternMatch(String regex, String text, long time) throws InterruptedException;
}

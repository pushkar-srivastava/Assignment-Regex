package com.regex.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.regex.assignment.model.RegexRequest;
import com.regex.assignment.model.RegexResponse;
import com.regex.assignment.services.RegexService;

@Component
@Controller
public class RegexController {

	@Autowired
	private RegexService regexService;

	/*
	 * time in milliseconds used to restrict the time taken for a regular expression
	 * to match. Suppose if we have a bad regular expression which is taking a lot
	 * of time then, the thread which is performing matching operation interrupts after timeLimit
	 * milliseconds.
	 */
	long timeLimit =500;

	@RequestMapping(value = "/match", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody RegexResponse matchRegex(@RequestBody RegexRequest request) throws InterruptedException {
		return regexService.timedPatternMatch(request.getRegex(), request.getTextBody(), timeLimit);
	}
}

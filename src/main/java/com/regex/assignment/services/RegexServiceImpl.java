package com.regex.assignment.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.springframework.stereotype.Service;

import com.regex.assignment.model.RegexResponse;

@Service
public class RegexServiceImpl implements RegexService {

	private RegexResponse response;

	@Override
	public RegexResponse timedPatternMatch(String regex, String text, long time) throws InterruptedException {
		// Default value of the response
		response = new RegexResponse("", true);
		// if the Text is null or Empty
		if (text == null || text.length() == 0)
			return response;
		try {
			// Exception Handling for Syntax error in Regular Expression.
			Pattern.compile(regex);
		} catch (PatternSyntaxException e) {
			return response;
		}
		final Pattern pattern = Pattern.compile(regex);
		final String input = text;

		// Definition of thread which is Performing the matching operation.
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				long startTime = System.currentTimeMillis();
				Matcher interruptableMatcher = pattern.matcher(new InterruptibleCharSequence(input));
				if (interruptableMatcher.find()) { // runs for a longer than given time then interrupts
					response.setMatch(interruptableMatcher.group(0));
					response.setError(false);
				}
				System.out.println("Regex took:" + (System.currentTimeMillis() - startTime) + "ms");
			}
		};
		// Create a new Thread from runnable instance
		Thread thread = new Thread(runnable);
		// starting thread for matching
		thread.start();
		// pausing the execution of current thread.
		Thread.sleep(time);
		thread.interrupt();
		return response;
	}

}

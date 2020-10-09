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
		response = new RegexResponse("", true);

		if (text == null || text.length() == 0)
			return response;
		try {
			Pattern.compile(regex);
		} catch (PatternSyntaxException e) {
			return response;
		}
		final Pattern pattern = Pattern.compile(regex);
		final String input = text;

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

		Thread thread = new Thread(runnable);
		// starting new thread for matching
		thread.start();
		// pausing the execution of current thread.
		Thread.sleep(time);
		thread.interrupt();
		return response;
	}

}

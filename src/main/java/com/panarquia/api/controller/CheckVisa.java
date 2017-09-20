package com.panarquia.api.controller;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/visa")
public class CheckVisa {

	private String urlS = "curl 'https://www.google.es/'";

	// @Scheduled(initialDelay = 1000, fixedDelay = 5000)
	@RequestMapping(method = RequestMethod.GET)
	public String check() {
		boolean matches = false;

		try {
			Runtime runtime = Runtime.getRuntime();

			Process process = runtime.exec(urlS);

			String page = IOUtils.toString(process.getInputStream());

			String patternString = "Scheme unavailable because: Unfortunately";

			Pattern pattern = Pattern.compile(patternString);

			Matcher matcher = pattern.matcher(page);

			matches = matcher.find();
		} catch (Exception e) {
			return e.getMessage();
		}

		return String.valueOf(matches);
	}

}

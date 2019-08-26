package dev.michalgruszka.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlValidatorImpl implements UrlValidator {

	private static final String URL_REGEX =
			"^(https?:\\/\\/)?([\\w\\Q$-_+!*'(),%\\E]+\\.)+(\\w{2,63})(:\\d{1,4})?([\\w\\Q/$-_+!*'(),%\\E]+\\.?[\\w])*\\/?$";

	private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
	
	@Override
	public boolean isValid(String url) {
		
		if (url == null) {
			return false;
		}

		Matcher matcher = URL_PATTERN.matcher(url);
		return matcher.matches();
	}

}

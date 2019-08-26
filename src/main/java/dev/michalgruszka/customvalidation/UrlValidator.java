package dev.michalgruszka.customvalidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UrlValidator implements ConstraintValidator<Url, String>{

	private static final String URL_REGEX =
			"^(https?:\\/\\/)?([\\w\\Q$-_+!*'(),%\\E]+\\.)+(\\w{2,63})(:\\d{1,4})?([\\w\\Q/$-_+!*'(),%\\E]+\\.?[\\w])*\\/?$";

	private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

	
	@Override
	public boolean isValid(String url, ConstraintValidatorContext context) {
		
		if (url == null) {
			return false;
		}

		Matcher matcher = URL_PATTERN.matcher(url);
		return matcher.matches();
	}

}

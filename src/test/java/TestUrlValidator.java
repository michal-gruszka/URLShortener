import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;

import dev.michalgruszka.customvalidation.UrlValidator;

public class TestUrlValidator {
	
	private UrlValidator urlValidator = new UrlValidator();
	private ConstraintValidatorContext ctx = null;

	@Test
	public void testEmptyString() {
		assertFalse(urlValidator.isValid("", ctx));
	}
	
	@Test
	public void testDoubleDot() {
		assertFalse(urlValidator.isValid("example..com", ctx));
	}
	
	@Test
	public void testNonExistentProtocol() {
		assertFalse(urlValidator.isValid("lol://example.com", ctx));
	}
	
	@Test
	public void testFtpLink() {
		assertFalse(urlValidator.isValid("ftp://username:password@ftp.xyz.com", ctx));
	}
	
	@Test
	public void testWithDigits() {
		assertTrue(urlValidator.isValid("www1.example123.com", ctx));
	}
	
	@Test
	public void testWithSubdirectory() {
		assertTrue(urlValidator.isValid("example.com/something", ctx));
	}
	
	@Testtx
	public void testEndingWithSlash() {
		assertTrue(urlValidator.isValid("www.example.com/", ctx));
	}
	
	@Test
	public void testDomainName() {
		assertTrue(urlValidator.isValid("example.com", ctx));
	}
	
	@Test
	public void testDomainNameWithWww() {
		assertTrue(urlValidator.isValid("www.example.com", ctx));
	}
	
	@Test
	public void testDomainNameWithHttp() {
		assertTrue(urlValidator.isValid("http://example.com", ctx));
	}
	
	@Test
	public void testDomainNameWithHttps() {
		assertTrue(urlValidator.isValid("https://example.com", ctx));
	}
	
	@Test
	public void testWithDollarSign() {
		assertTrue(urlValidator.isValid("ex$ample.com", ctx));
	}
}

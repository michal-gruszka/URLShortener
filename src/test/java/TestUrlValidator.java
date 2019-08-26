import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dev.michalgruszka.util.UrlValidator;
import dev.michalgruszka.util.UrlValidatorImpl;

public class TestUrlValidator {
	
	private UrlValidator urlValidator = new UrlValidatorImpl();

	@Test
	public void testEmptyString() {
		assertFalse(urlValidator.isValid(""));
	}
	
	@Test
	public void testDoubleDot() {
		assertFalse(urlValidator.isValid("example..com"));
	}
	
	@Test
	public void testNonExistentProtocol() {
		assertFalse(urlValidator.isValid("lol://example.com"));
	}
	
	@Test
	public void testFtpLink() {
		assertFalse(urlValidator.isValid("ftp://username:password@ftp.xyz.com"));
	}
	
	@Test
	public void testWithDigits() {
		assertTrue(urlValidator.isValid("www1.example123.com"));
	}
	
	@Test
	public void testWithSubdirectory() {
		assertTrue(urlValidator.isValid("example.com/something"));
	}
	
	@Test
	public void testEndingWithSlash() {
		assertTrue(urlValidator.isValid("www.example.com/"));
	}
	
	@Test
	public void testDomainName() {
		assertTrue(urlValidator.isValid("example.com"));
	}
	
	@Test
	public void testDomainNameWithWww() {
		assertTrue(urlValidator.isValid("www.example.com"));
	}
	
	@Test
	public void testDomainNameWithHttp() {
		assertTrue(urlValidator.isValid("http://example.com"));
	}
	
	@Test
	public void testDomainNameWithHttps() {
		assertTrue(urlValidator.isValid("https://example.com"));
	}
	
	@Test
	public void testWithDollarSign() {
		assertTrue(urlValidator.isValid("ex$ample.com"));
	}
}

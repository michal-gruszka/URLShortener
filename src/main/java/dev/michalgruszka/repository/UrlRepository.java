package dev.michalgruszka.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import dev.michalgruszka.model.Url;

public interface UrlRepository extends CrudRepository<Url, Long> {

	Url findByOriginalUrl(String originalUrl);
	
	Url findByShortUrl(String shortUrl);
	
	/**
	 * Uses a database function which:
	 * returns code assigned to provided url if exists
	 * OR
	 * 1. takes a new code from code_pool
	 * 2. updates url table with this url-code pair 
	 * 3. removes the code from the pool
	 * @param originalUrl
	 * @return unique code for the provided url
	 */
	@Query(value = "SELECT get_code_for(?1)", nativeQuery = true)
	String getCodeFor(String originalUrl);
}

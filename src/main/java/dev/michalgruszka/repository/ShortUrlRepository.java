package dev.michalgruszka.repository;

import org.springframework.data.repository.CrudRepository;

import dev.michalgruszka.model.ShortUrl;

public interface ShortUrlRepository extends CrudRepository<ShortUrl, Long> {

	ShortUrl findByOriginalUrl(String originalUrl);
	ShortUrl findByShortUrl(String shortUrl);
}

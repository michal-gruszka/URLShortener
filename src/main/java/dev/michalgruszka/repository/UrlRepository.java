package dev.michalgruszka.repository;

import org.springframework.data.repository.CrudRepository;

import dev.michalgruszka.model.Url;

public interface UrlRepository extends CrudRepository<Url, Long> {

	Url findByOriginalUrl(String originalUrl);
	Url findByShortUrl(String shortUrl);
}

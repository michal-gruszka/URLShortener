package dev.michalgruszka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.michalgruszka.model.ShortUrl;
import dev.michalgruszka.repository.ShortUrlRepository;

@Service
public class ShortUrlService {

	@Autowired
	ShortUrlRepository repository;
	
	@Transactional
	public List<ShortUrl> getAllShortUrls() {
		return (List<ShortUrl>) repository.findAll();
	}
	
	@Transactional
	public ShortUrl getByShortUrl(String shortUrl) {
		return repository.findByShortUrl(shortUrl);
	}
	
	@Transactional
	public ShortUrl getByOriginalUrl(String originalUrl) {
		return repository.findByOriginalUrl(originalUrl);
	}
	
	@Transactional
	public ShortUrl getById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	@Transactional
	public void deleteShortUrlById(Long id) {
		repository.deleteById(id);
	}
	
	@Transactional
	public boolean addShortUrl(ShortUrl shortUrl) {
		return repository.save(shortUrl) != null;
	}
	
	@Transactional
	public boolean updateShortUrl(ShortUrl shortUrl) {
		return repository.save(shortUrl) != null;
	}
}

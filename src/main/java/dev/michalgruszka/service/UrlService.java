package dev.michalgruszka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.michalgruszka.model.Url;
import dev.michalgruszka.repository.UrlRepository;

@Service
public class UrlService {

	@Autowired
	UrlRepository repository;
	
	@Transactional
	public List<Url> getAllUrls() {
		return (List<Url>) repository.findAll();
	}
	
	@Transactional
	public Url getByShortUrl(String shortUrl) {
		return repository.findByShortUrl(shortUrl);
	}
	
	@Transactional
	public Url getByOriginalUrl(String originalUrl) {
		return repository.findByOriginalUrl(originalUrl);
	}
	
	@Transactional
	public Url getById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	@Transactional
	public boolean addUrl(Url url) {
		return repository.save(url) != null;
	}
	
	@Transactional
	public boolean updateUrl(Url url) {
		return repository.save(url) != null;
	}
}
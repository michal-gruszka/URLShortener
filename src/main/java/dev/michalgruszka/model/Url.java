package dev.michalgruszka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import dev.michalgruszka.customvalidation.ValidUrl;

@Entity
@Table(name = "url")
public class Url {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ValidUrl
	@Column(name = "original_url", unique = true)
	private String originalUrl;

	@Column(name = "code", unique = true)
	private String code;

	public Url() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		if (!originalUrl.startsWith("http://") && !originalUrl.startsWith("https://")) {
			originalUrl = "http://" + originalUrl;
		}
		this.originalUrl = originalUrl;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}

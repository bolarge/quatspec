package com.quaspec.service.service;

import java.util.Optional;

import com.quaspec.persistence.domain.Document;

public interface DocumentService {
	public Optional<Document> findById(Long id);

}

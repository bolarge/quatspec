package com.quatspec.service.service;

import java.util.Optional;

import com.quatspec.persistence.domain.Document;

public interface DocumentService {
	public Optional<Document> findById(Long id);

}

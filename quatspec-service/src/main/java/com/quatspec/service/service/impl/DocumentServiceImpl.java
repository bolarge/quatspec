package com.quatspec.service.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quatspec.persistence.domain.Document;
import com.quatspec.persistence.repository.DocumentRepository;
import com.quatspec.service.service.DocumentService;


@Service("documentService")
@Transactional
public class DocumentServiceImpl implements DocumentService {
	
	@Autowired
	private DocumentRepository documentRepository;

	@Override
	@Transactional(readOnly=true)
	public Optional<Document> findById(Long id) {
		return documentRepository.findById(id);
	}

	
}

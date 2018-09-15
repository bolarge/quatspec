package com.quaspec.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quaspec.persistence.domain.Document;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Long>{

}

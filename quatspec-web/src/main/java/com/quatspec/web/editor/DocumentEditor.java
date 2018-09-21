package com.quaspec.web.editor;

import java.beans.PropertyEditorSupport;
import java.util.Optional;

import com.quaspec.persistence.domain.Document;
import com.quaspec.service.service.DocumentService;

public class DocumentEditor extends PropertyEditorSupport{

		private DocumentService documentService;

		public DocumentEditor() {}

		public DocumentEditor(DocumentService documentService) {
			super();
			this.documentService = documentService;
		}
		
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			Long documentId = Long.parseLong(text);
			Optional<Document> document = documentService.findById(documentId);
			setValue(document.get());
		}
}

package com.quaspec.persistence.domain;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="document")
@Entity(name="Document")
public class Document {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="document_id")
	private Long id;
	
	@Column(name="filename")
	private String fileName;
	
	@Column(name="content_type")
	private String contentType;
	
	@Column(name="document_type")
	private String documentType;
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="content")
	private byte[] fileData;
	
	@Column(name="created")
	private Date created;
	
	@Column(name="version")
	private int version = 0;
	
	public Long getId()
	{
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public byte[] getFileData() { return this.fileData; }

	public void setFileData(byte[] fileData)
	{
		this.fileData = fileData;
	}

	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public Date getCreated() { return this.created; }

/*	@Transient
	public String getCreatedString()
	{
		String createdString = "";
		if (this.created != null)
			createdString = org.joda.time.format.DateTimeFormat.forPattern(
					"dd-MM-yyyy").print(this.created);
		return createdString;
	}*/

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getDocumentType() {
		return this.documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String toString()
	{
		return "Document [getId()=" + getId() + ", getFileData()=" + 
				Arrays.toString(getFileData()) + ", getContentType()=" + 
				getContentType() + ", getCreated()=" + getCreated() + 
				", getDocumentType()=" + getDocumentType() + 
				", getFileName()=" + getFileName() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
package com.quaspec.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "privilege")
@Entity(name = "privilege")
public class Privilege {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected Long id;
	
	@Column(name = "version", nullable = false)
	protected int version;
		
	@Column(name = "name", nullable = false, unique=true)	
	protected String name;
	
	@Column(name = "description")
	protected String description;

	public Privilege() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object object) {
		 if(object instanceof Privilege && ((Privilege)object).getId().equals(this.id)){
		 	 return true;
		 }
		 return false;
	}

	@Override
	public String toString() {
		return "Privilege [name=" + name + ", description=" + description + "]";
	}

}

package com.quatspec.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.quatspec.api.model.IOrganization;

@Entity(name="Organization")
@Table(name="organization")
public class Organization implements IOrganization{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @Column(name="name")
    protected String name;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id")
    protected Institution institution;

    @Column(name="email")
    protected String email;

    @Column(name="phone_number")
    protected String phoneNumber;

    @Column(name="status")
    protected boolean status = false;	
   
    public Organization(){
    	super();
    }

    public Organization(String name, String email, String phoneNumber) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @Override
    public boolean equals(Object object){
         if(object instanceof Organization && ((Organization)object).getId().equals(this.id)){
             return true;
         }
         return false;
    }
}
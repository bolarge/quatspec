package com.quaspec.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name="Institution")
@Table(name="institution")
@NamedQueries({
	@NamedQuery(name = "Institution.findAll", query = "SELECT i FROM Institution i"), 
	@NamedQuery(name="Institution.findInstitutionByName", query = "select i from Institution as i where i.name=:NAME")
})
public class Institution {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @Column(name="name")
    private String name;

    @Column(name="status")
    private boolean status = false;

    public Institution(){}

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object object){
         if(object instanceof Institution && ((Institution)object).getId().equals(this.id)){
              return true;
         }
         return false;
    }
}

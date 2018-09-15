package com.quaspec.persistence.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = "Profile")
@Table(name = "profile")
@NamedQueries({
 	@NamedQuery(name="userprofile.findAll", query = "SELECT u FROM Profile u"),
	@NamedQuery(name="userprofile.findProfileByName",query = "select u from Profile as u where LOWER(u.name)=:NAME"),
	@NamedQuery(name="userprofile.findProfileByUserId",query = "select c from Profile as c, User as u where u.id=:USERID and c MEMBER OF u.profiles and c.status=true")
})
public class Profile {
	
	@Id
	@Column(name="id") @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name",unique=true,length =50)
	protected String name;

	@Column(name="status")
	protected boolean status = false;
	
	@Column(name="description")
	protected String description;
	
	@Column(name="base_url")
	protected String baseUrl;
	
	@ManyToMany(mappedBy = "profiles")
	protected Set<User> users = new HashSet<User>();
	
	@ManyToMany(fetch=FetchType.EAGER,targetEntity = Role.class)
	@JoinTable(name = "profile_role",
			joinColumns = { @JoinColumn(name = "profle_id") },
			inverseJoinColumns = { @JoinColumn(name = "role_id") })
	  private Set<Role> roles = new HashSet<Role>();

	public Profile() {

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Profile(String string) {
		this.name = string;
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
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
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
	public boolean equals(Object obj) {
	   if(obj instanceof Profile && ((Profile)obj).getId().equals(this.id)){
	   	 return true;
	   }
	   return false;
	}
	
}

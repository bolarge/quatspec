package com.quatspec.persistence.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.quatspec.api.enums.Gender;
import com.quatspec.api.model.IUser;

@Entity(name = "User")
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
public abstract class User implements IUser{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "version")
	private int version;
	
	@Column(name = "last_name", length = 15)
	private String lastName;
	
	@Column(name = "first_name", length = 15)
	private String firstName;
	
	@Column(name = "middle_name", length = 15)
	private String middleName;
	
	@Column(name = "birth_date")
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@Column(name = "email", unique = true, nullable = false, length = 45)
	private String email;
	
	@Column(name = "username", unique = true, nullable = false, length = 25)
	private String userName;
	
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name = "password", length = 100)
	private String password;
	
	@Basic(fetch = FetchType.LAZY)
	@Lob
	@Column(name = "photo")
	private byte[] photo;
	
	@Column(name="profile_pic")
	private String profilePicture = "/static/images/avatar.png";
	
	@Column(name = "enabled")
	private boolean enabled = true;
	
	@Column(name = "question", length = 25)
	private String securityQuestion;
	
	@Column(name = "answer", length = 25)
	private String securityAnswer;	
	
	@Column(name="base_url")
	private String baseUrl;

	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name="last_logon_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLoginDate;

	@Column(name="last_logout_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogoutDate;
	
	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="institution_id")
	private Institution institution;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="organization_id")
	private Organization organization;
	
	@Column(name = "gsm_number")
	private String gsmPhoneNumber;
	
	@ManyToMany(fetch=FetchType.EAGER, targetEntity = Profile.class)
	@JoinTable(name = "user_profile",
			joinColumns = { @JoinColumn(name = "user_id") },
			inverseJoinColumns = { @JoinColumn(name = "profile_id") })
	private Set<Profile> profiles = new HashSet<Profile>();
	
	/*@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
	           joinColumns = @JoinColumn(name = "user_id"), 
	           inverseJoinColumns = @JoinColumn(name = "role_id"))
	protected Set<Role> roles = new HashSet<Role>();*/
	
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Date getLastLogoutDate() {
		return lastLogoutDate;
	}

	public void setLastLogoutDate(Date lastLogoutDate) {
		this.lastLogoutDate = lastLogoutDate;
	}

	public Set<Profile> getProfiles() {
		return profiles;
	}

	public String getGsmPhoneNumber() {
		return gsmPhoneNumber;
	}

	public void setGsmPhoneNumber(String gsmPhoneNumber) {
		this.gsmPhoneNumber = gsmPhoneNumber;
	}

	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

/*	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}*/	
}

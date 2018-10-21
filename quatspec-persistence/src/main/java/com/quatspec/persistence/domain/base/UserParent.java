package com.quatspec.persistence.domain.base;

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
import com.quatspec.persistence.domain.Institution;
import com.quatspec.persistence.domain.Organization;
import com.quatspec.persistence.domain.Product;
import com.quatspec.persistence.domain.Profile;

@Entity(name = "User")
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
public abstract class UserParent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected Long userId;
	
	@Column(name = "version")
	protected int version;
	
	@Column(name = "last_name", length = 15)
	protected String lastName;
	
	@Column(name = "first_name", length = 15)
	protected String firstName;
	
	@Column(name = "middle_name", length = 15)
	protected String middleName;
	
	@Column(name = "birth_date")
	@Temporal(TemporalType.DATE)
	protected Date birthDate;
	
	@Column(name = "email", unique = true, nullable = false, length = 45)
	protected String email;
	
	@Column(name = "username", unique = true, nullable = false, length = 25)
	protected String userName;
	
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	protected Gender gender;
	
	@Column(name = "password", length = 100)
	protected String password;
	
	@Basic(fetch = FetchType.LAZY)
	@Lob
	@Column(name = "photo")
	protected byte[] photo;
	
	@Column(name="profile_pic")
	protected String profilePicture = "/static/images/avatar.png";
	
	@Column(name = "enabled")
	protected boolean enabled = true;
	
	@Column(name = "question", length = 25)
	protected String securityQuestion;
	
	@Column(name = "answer", length = 25)
	protected String securityAnswer;	
	
	@Column(name="base_url")
	protected String baseUrl;

	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	protected Date startDate;
	
	@Column(name="last_logon_date")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastLoginDate;

	@Column(name="last_logout_date")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastLogoutDate;
	
	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="institution_id")
	protected Institution institution;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="organization_id")
	protected Organization organization;
	
	@Column(name = "gsm_number")
	protected String gsmPhoneNumber;
	
	@Column(name = "u_type")
	protected String userType;
	
	@Column(name = "merchant_id")
	protected String merchantId;
	
	@Column(name = "paychant_id")
	protected String paychantId;
	
	@Column(name = "employeeId")
	protected String employeeId;
	
	@Column(name = "national_id")
	protected String nationalId;
	
	@ManyToMany(fetch=FetchType.EAGER, targetEntity = Profile.class)
	@JoinTable(name = "user_profile",
			joinColumns = { @JoinColumn(name = "user_id") },
			inverseJoinColumns = { @JoinColumn(name = "profile_id") })
	protected Set<Profile> profiles = new HashSet<Profile>();
	
    @ManyToMany(fetch=FetchType.LAZY,targetEntity=Product.class)
    @JoinTable(name="user_product",
            joinColumns =@JoinColumn(name="user_id"),
            inverseJoinColumns=@JoinColumn(name="product_id"))
    protected Set<Product> products = new HashSet<Product>();
	
	public UserParent() {}
	
	public UserParent(String userName, String email, String password, String gsmPhoneNumber, String nationalId, Organization organization) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.gsmPhoneNumber = gsmPhoneNumber;
		this.nationalId = nationalId;
		this.organization = organization;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long id) {
		this.userId = id;
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
	
	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}

	public String getGsmPhoneNumber() {
		return gsmPhoneNumber;
	}

	public void setGsmPhoneNumber(String gsmPhoneNumber) {
		this.gsmPhoneNumber = gsmPhoneNumber;
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

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getPaychantId() {
		return paychantId;
	}

	public void setPaychantId(String paychantId) {
		this.paychantId = paychantId;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;	
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	
    public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products.addAll(products);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gsmPhoneNumber == null) ? 0 : gsmPhoneNumber.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		UserParent other = (UserParent) obj;
		if (gsmPhoneNumber == null) {
			if (other.gsmPhoneNumber != null)
				return false;
		} else if (!gsmPhoneNumber.equals(other.gsmPhoneNumber))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	

}

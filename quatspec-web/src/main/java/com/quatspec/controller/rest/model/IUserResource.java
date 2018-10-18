package com.quatspec.controller.rest.model;

import java.util.Date;
import java.util.Set;

import com.quatspec.api.enums.Gender;
import com.quatspec.api.model.IOrganization;
import com.quatspec.api.model.IUser;
import com.quatspec.persistence.domain.Organization;
import com.quatspec.persistence.domain.Profile;

public class IUserResource extends DefaultResource implements IUser<IOrganization> {

	private String userName;

	private String email;
    
	private String gsmPhoneNumber;
    
	private String userType;

	private IOrganizationResource iOrganization;      

    public IUserResource() {
        super();
    }

    public IUserResource(IUser iUser) {
        this.userName = iUser.getUserName();
        this.email = iUser.getEmail();
        this.gsmPhoneNumber = iUser.getGsmPhoneNumber();
        this.userType = iUser.getUserType();
        if(iUser.getOrganization() != null) {
        	iOrganization = new IOrganizationResource(iUser.getOrganization());
        }
    }

	@Override
	public String getUserName() {
		return userName;
	}

	@Override
	public void setUserName(String username) {
		this.userName = username;		
	}

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setPassword(String password) {
    	
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
	public String getUserType() {
		return userType;
	}

    @Override
	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public Long getUserId() {
		return null;
	}

	@Override
	public void setUserId(Long id) {		
		
	}

	@Override
	public int getVersion() {
		return 0;
	}

	@Override
	public void setVersion(int version) {
		
	}

	@Override
	public String getLastName() {
		return null;
	}

	@Override
	public void setLastName(String lastName) {
		
	}

	@Override
	public String getFirstName() {
		return null;
	}

	@Override
	public void setFirstName(String firstName) {
		
	}

	@Override
	public Date getBirthDate() {
		return null;
	}

	@Override
	public void setBirthDate(Date birthDate) {
		
	}

	@Override
	public String getMiddleName() {
		return null;
	}

	@Override
	public void setMiddleName(String middleName) {
		
	}

	@Override
	public Gender getGender() {
		return null;
	}

	@Override
	public void setGender(Gender sex) {
		
	}

	@Override
	public byte[] getPhoto() {
		return null;
	}

	@Override
	public void setPhoto(byte[] photo) {
		
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	@Override
	public void setEnabled(boolean enabled) {
		
	}

	@Override
	public String getSecurityQuestion() {
		return null;
	}

	@Override
	public void setSecurityQuestion(String securityQuestion) {
		
	}

	@Override
	public String getSecurityAnswer() {
		return null;
	}

	@Override
	public void setSecurityAnswer(String securityAnswer) {
		
	}

	@Override
	public Date getLastLoginDate() {
		return null;
	}

	@Override
	public void setLastLoginDate(Date lastLoginDate) {
		
	}

	@Override
	public Date getLastLogoutDate() {
		return null;
	}

	@Override
	public void setLastLogoutDate(Date lastLogoutDate) {
		
	}

	@Override
	public Date getStartDate() {
		return null;
	}

	@Override
	public void setStartDate(Date startDate) {
		
	}

	@Override
	public String getEmployeeId() {
		return null;
	}

	@Override
	public void setEmployeeId(String employeeId) {

	}

	@Override
	public String getBaseUrl() {
		return null;
	}

	@Override
	public void setBaseUrl(String url) {
		
	}

	@Override
	public String getGsmPhoneNumber() {		
		return gsmPhoneNumber;
	}

	@Override
	public void setGsmPhoneNumber(String gsmPhoneNumber) {
		this.gsmPhoneNumber = gsmPhoneNumber;	
	}

	@Override
	public String getMerchantId() {
		return null;
	}

	@Override
	public void setMerchantId(String merchantId) {	
		
	}

	@Override
	public String getPaychantId() {	
		return null;
	}

	@Override
	public void setPaychantId(String paychantId) {		
		
	}
	
	@Override
	public Set<Profile> getProfiles() {
		return null;
	}

	@Override
	public IOrganization getOrganization() {
		return iOrganization;
	}

	
}
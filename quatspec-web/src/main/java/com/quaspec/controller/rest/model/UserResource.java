package com.quaspec.controller.rest.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.quaspec.api.enums.Gender;
import com.quaspec.api.model.IUser;
import com.quaspec.persistence.domain.Profile;
import com.quaspec.persistence.domain.User;

public class UserResource extends DefaultResource implements IUser {

    private String username;

    private String email;

    private List<Profile> profiles;

    public UserResource() {
        super();
    }

    public UserResource(IUser user) {
        this.username = user.getUserName();
        this.email = user.getEmail();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setPassword(String password) {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setVersion(int version) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getBirthDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBirthDate(Date birthDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getMiddleName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMiddleName(String middleName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Gender getGender() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGender(Gender sex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] getPhoto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPhoto(byte[] photo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setEnabled(boolean enabled) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getSecurityQuestion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSecurityQuestion(String securityQuestion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getSecurityAnswer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSecurityAnswer(String securityAnswer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getLastLoginDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLastLoginDate(Date lastLoginDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getLastLogoutDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLastLogoutDate(Date lastLogoutDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getStartDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStartDate(Date startDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getEmployeeId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEmployeeId(String employeeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getBaseUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBaseUrl(String url) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set getProfiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGsmPhoneNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGsmPhoneNumber(String gsmPhoneNumber) {
		// TODO Auto-generated method stub
		
	}
}

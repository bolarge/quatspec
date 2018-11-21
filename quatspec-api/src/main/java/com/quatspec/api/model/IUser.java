package com.quatspec.api.model;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import com.quatspec.api.enums.Gender;

public interface IUser<T extends IOrganization>  {
	
	Long getId();

	void setId(Long id);

	int getVersion();

	void setVersion(int version);

	String getLastName();

	void setLastName(String lastName);

	String getFirstName();

	void setFirstName(String firstName);

	Date getBirthDate();

	void setBirthDate(Date birthDate);

	String getEmail();

	void setEmail(String email);

	String getMiddleName();

	void setMiddleName(String middleName);

	String getUserName();

	void setUserName(String userName);

	Gender getGender();

	void setGender(Gender sex);

	String getPassword();

	void setPassword(String password);

	byte[] getPhoto();

	void setPhoto(byte[] photo);

	boolean isEnabled();

	void setEnabled(boolean enabled);

	String getSecurityQuestion();

	void setSecurityQuestion(String securityQuestion);

	String getSecurityAnswer();

	void setSecurityAnswer(String securityAnswer);
	
	Date getLastLoginDate();

	void setLastLoginDate(Date lastLoginDate);

	Date getLastLogoutDate();

	void setLastLogoutDate(Date lastLogoutDate);
	
	Date getStartDate();

	void setStartDate(Date startDate);

	String getEmployeeId();

	void setEmployeeId(String employeeId);

	String toString();

	String getBaseUrl();

	void setBaseUrl(String url);
	
	String getGsmPhoneNumber();

	void setGsmPhoneNumber(String gsmPhoneNumber) ;
	
	String getUserType();
	
	void setUserType(String userType);
	
	String getMerchantId();
	
	void setMerchantId(String merchantId);
	
	String getPaychantId();
	
	void setPaychantId(String paychantId);
	
	Collection getProfiles();	
	
	T getOrganization();
	
	void setOrganization(T organization);
	
	String getNationalId();
	
	void setNationalId(String nationalId);
	
	//T getIProfile();
	
	//void setIProfile(T profile);
	
}

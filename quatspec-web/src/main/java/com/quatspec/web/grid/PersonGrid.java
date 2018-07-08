package com.quatspec.web.grid;

import java.util.List;

import org.springframework.security.core.userdetails.User;


public class PersonGrid {

	private int totalPages;
	
	private int currentPage;
	
	private long totalRecords;
	
	private List<User> personData;

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<User> getPersonData() {
		return personData;
	}

	public void setPersonData(List<User> personData) {
		this.personData = personData;
	}
	
}
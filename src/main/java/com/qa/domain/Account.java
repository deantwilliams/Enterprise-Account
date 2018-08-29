package com.qa.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="tbl_accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="first_name", length=50)
	@NotNull
	private String firstname;
	
	@Column(name="last_name", length=50)
	@NotNull
	private String surname;
	
	@Column(name="account_no", length=4)
	@NotNull
	private String accountNum;
	
	public Account() {}

	public Account(long id, String firstname, String surname, String accountNum) {
		this.id = id;
		this.firstname = firstname;
		this.surname = surname;
		this.accountNum = accountNum;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	
}

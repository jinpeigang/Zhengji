package com.jpg.hebei.vo;

import org.springframework.stereotype.Component;

@Component("userRegisterInfo")
public class UserRegisterInfo {
	private int id;
	private String username;
	   private String password;
	   private String password2;
	  private String companyName;
	   private String name;
	   private String cardID;
	   private String companynum;
	   private String legalRepresenttative;
	   private String address;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	public String getCompanynum() {
		return companynum;
	}
	public void setCompanynum(String companynum) {
		this.companynum = companynum;
	}
	public String getLegalRepresenttative() {
		return legalRepresenttative;
	}
	public void setLegalRepresenttative(String legalRepresenttative) {
		this.legalRepresenttative = legalRepresenttative;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
 
}

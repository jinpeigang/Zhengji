package com.jpg.hebei.model;

import javax.persistence.Entity;
/*dynamic-update="true" dynamic -insert ="true"*/ 
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "puser")
public class User {
   private int id;
   private String username;
   private String password;
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
public String getCardID() {
	return cardID;
}
public void setCardID(String cardID) {
	this.cardID = cardID;
}
@Id
@GeneratedValue
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}


   
}

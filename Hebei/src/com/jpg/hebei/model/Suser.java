package com.jpg.hebei.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "xuser")
public class Suser {
   private int ID;
   private String username;
   private String password;
   private String name;
   private String sex;
   private String tel;
   private String address;
   private String bumen;
   
@Id
@GeneratedValue  
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
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
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getBumen() {
	return bumen;
}
public void setBumen(String bumen) {
	this.bumen = bumen;
}
}

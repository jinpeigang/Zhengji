package com.jpg.hebei.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "xuqiu")
public class Information {
   private int ID;
   private String CompanyName;
   private String CenManagement;
   private String CompanyAddress;
   private String Area;
   private String WorkWebSite;
   private String  Email;
   private String LegalRepresenttative;
   private String PostCode;
   private String ContactName;
   private String Telephone;
   private String Phone;
   private String Fax;
   private String JGshuxing;
   private String CompanyIntroduction;
   private String TechNeed;
   private String StartYear;
   private String EndYear;
   private String Techquest;
   private String Techkey;
   private String Techgoal;
   private String Key1;
   private String Key2;
   private String Key3;
   private String Key4;
   private String Key5;
   private float PlanSum;
   private String TechNeedMode;
   private String CoopIntentionUnit;
   private String StudyType;
   private String SbjectThird;
   private String TechNeedField;
   private String Other;
   private String TNProfessionThird;
   private int Flage;
   private String reason;
   private String guanli;
   private String xname;
   private String xriqi;
   private String bname;
   private String briqi;
   private String suoding;
   
   @Id
   @GeneratedValue
   public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getCompanyName() {
	return CompanyName;
}
public void setCompanyName(String companyName) {
	CompanyName = companyName;
}
public String getCenManagement() {
	return CenManagement;
}
public void setCenManagement(String cenManagement) {
	CenManagement = cenManagement;
}
public String getCompanyAddress() {
	return CompanyAddress;
}
public void setCompanyAddress(String companyAddress) {
	CompanyAddress = companyAddress;
}
public String getArea() {
	return Area;
}
public void setArea(String area) {
	Area = area;
}
public String getWorkWebSite() {
	return WorkWebSite;
}
public void setWorkWebSite(String workWebSite) {
	WorkWebSite = workWebSite;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getLegalRepresenttative() {
	return LegalRepresenttative;
}
public void setLegalRepresenttative(String legalRepresenttative) {
	LegalRepresenttative = legalRepresenttative;
}
public String getPostCode() {
	return PostCode;
}
public void setPostCode(String postCode) {
	PostCode = postCode;
}
public String getContactName() {
	return ContactName;
}
public void setContactName(String contactName) {
	ContactName = contactName;
}
public String getTelephone() {
	return Telephone;
}
public void setTelephone(String telephone) {
	Telephone = telephone;
}
public String getPhone() {
	return Phone;
}
public void setPhone(String phone) {
	Phone = phone;
}
public String getFax() {
	return Fax;
}
public void setFax(String fax) {
	Fax = fax;
}
public String getJGshuxing() {
	return JGshuxing;
}
public void setJGshuxing(String jGshuxing) {
	JGshuxing = jGshuxing;
}
public String getCompanyIntroduction() {
	return CompanyIntroduction;
}
public void setCompanyIntroduction(String companyIntroduction) {
	CompanyIntroduction = companyIntroduction;
}
public String getTechNeed() {
	return TechNeed;
}
public void setTechNeed(String techNeed) {
	TechNeed = techNeed;
}
public String getStartYear() {
	return StartYear;
}
public void setStartYear(String startYear) {
	StartYear = startYear;
}
public String getEndYear() {
	return EndYear;
}
public void setEndYear(String endYear) {
	EndYear = endYear;
}
public String getTechquest() {
	return Techquest;
}
public void setTechquest(String techquest) {
	Techquest = techquest;
}
public String getTechkey() {
	return Techkey;
}
public void setTechkey(String techkey) {
	Techkey = techkey;
}
public String getTechgoal() {
	return Techgoal;
}
public void setTechgoal(String techgoal) {
	Techgoal = techgoal;
}
public String getKey1() {
	return Key1;
}
public void setKey1(String key1) {
	Key1 = key1;
}
public String getKey2() {
	return Key2;
}
public void setKey2(String key2) {
	Key2 = key2;
}
public String getKey3() {
	return Key3;
}
public void setKey3(String key3) {
	Key3 = key3;
}
public String getKey4() {
	return Key4;
}
public void setKey4(String key4) {
	Key4 = key4;
}
public String getKey5() {
	return Key5;
}
public void setKey5(String key5) {
	Key5 = key5;
}

public String getTechNeedMode() {
	return TechNeedMode;
}
public void setTechNeedMode(String techNeedMode) {
	TechNeedMode = techNeedMode;
}
public String getCoopIntentionUnit() {
	return CoopIntentionUnit;
}
public void setCoopIntentionUnit(String coopIntentionUnit) {
	CoopIntentionUnit = coopIntentionUnit;
}
public String getStudyType() {
	return StudyType;
}
public void setStudyType(String studyType) {
	StudyType = studyType;
}
public String getSbjectThird() {
	return SbjectThird;
}
public void setSbjectThird(String sbjectThird) {
	SbjectThird = sbjectThird;
}
public String getTechNeedField() {
	return TechNeedField;
}
public void setTechNeedField(String techNeedField) {
	TechNeedField = techNeedField;
}
public String getOther() {
	return Other;
}
public void setOther(String other) {
	Other = other;
}
public String getTNProfessionThird() {
	return TNProfessionThird;
}
public void setTNProfessionThird(String tNProfessionThird) {
	TNProfessionThird = tNProfessionThird;
}

public String getReason() {
	return reason;
}
public void setReason(String reason) {
	this.reason = reason;
}
public String getGuanli() {
	return guanli;
}
public void setGuanli(String guanli) {
	this.guanli = guanli;
}
public String getXname() {
	return xname;
}
public void setXname(String xname) {
	this.xname = xname;
}
public String getXriqi() {
	return xriqi;
}
public void setXriqi(String xriqi) {
	this.xriqi = xriqi;
}
public String getBname() {
	return bname;
}
public void setBname(String bname) {
	this.bname = bname;
}
public String getBriqi() {
	return briqi;
}
public void setBriqi(String briqi) {
	this.briqi = briqi;
}
public float getPlanSum() {
	return PlanSum;
}
public void setPlanSum(float planSum) {
	PlanSum = planSum;
}
public int getFlage() {
	return Flage;
}
public void setFlage(int flage) {
	Flage = flage;
}
public String getSuoding() {
	return suoding;
}
public void setSuoding(String suoding) {
	this.suoding = suoding;
}
   
}

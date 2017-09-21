package com.jpg.hebei.model;

import org.springframework.stereotype.Component;

@Component("retrieve")
public class Retrieve {
	 private String biaoyin1;
	 private String tiaojian1;
	 private String biaoyin2;//二级下拉
	 private String tiaojian2;//二级下拉
	 private String biaoyin3;//审核结果
	 private String biaoyin4;//精确模糊
	 
	public String getBiaoyin1() {
		return biaoyin1;
	}
	public void setBiaoyin1(String biaoyin1) {
		this.biaoyin1 = biaoyin1;
	}
	public String getTiaojian1() {
		return tiaojian1;
	}
	public void setTiaojian1(String tiaojian1) {
		this.tiaojian1 = tiaojian1;
	}
	public String getBiaoyin2() {
		return biaoyin2;
	}
	public void setBiaoyin2(String biaoyin2) {
		this.biaoyin2 = biaoyin2;
	}
	public String getTiaojian2() {
		return tiaojian2;
	}
	public void setTiaojian2(String tiaojian2) {
		this.tiaojian2 = tiaojian2;
	}
	public String getBiaoyin3() {
		return biaoyin3;
	}
	public void setBiaoyin3(String biaoyin3) {
		this.biaoyin3 = biaoyin3;
	}
	public String getBiaoyin4() {
		return biaoyin4;
	}
	public void setBiaoyin4(String biaoyin4) {
		this.biaoyin4 = biaoyin4;
	}
}

package com.jpg.hebei.model;

import org.springframework.stereotype.Component;

@Component("search")
public class Search {
	private String sel0;
	private String sel2;
	private String sel3;
	private String sel4;
	private String inputvalue;
	public String getSel0() {
		return sel0;
	}
	public void setSel0(String sel0) {
		this.sel0 = sel0;
	}
	public String getSel2() {
		return sel2;
	}
	public void setSel2(String sel2) {
		this.sel2 = sel2;
	}
	public String getSel3() {
		return sel3;
	}
	public void setSel3(String sel3) {
		this.sel3 = sel3;
	}
	public String getSel4() {
		return sel4;
	}
	public void setSel4(String sel4) {
		this.sel4 = sel4;
	}
	public String getInputvalue() {
		return inputvalue;
	}
	public void setInputvalue(String inputvalue) {
		this.inputvalue = inputvalue;
	}
}

package com.kh.spring.model.vo;

import java.util.Arrays;

public class Dev {

	private String devName;
	private int devAge;
	private String devEmail;
	private String devGender;
	private String[] devLang;
	
	public Dev() {
		// TODO Auto-generated constructor stub
	}

	public Dev(String devName, int devAge, String devEmail, String devGender, String[] devLang) {
		super();
		this.devName = devName;
		this.devAge = devAge;
		this.devEmail = devEmail;
		this.devGender = devGender;
		this.devLang = devLang;
	}

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public int getDevAge() {
		return devAge;
	}

	public void setDevAge(int devAge) {
		this.devAge = devAge;
	}

	public String getDevEmail() {
		return devEmail;
	}

	public void setDevEmail(String devEmail) {
		this.devEmail = devEmail;
	}

	public String getDevGender() {
		return devGender;
	}

	public void setDevGender(String devGender) {
		this.devGender = devGender;
	}

	public String[] getDevLang() {
		return devLang;
	}

	public void setDevLang(String[] devLang) {
		this.devLang = devLang;
	}

	@Override
	public String toString() {
		return "Dev [devName=" + devName + ", devAge=" + devAge + ", devEmail=" + devEmail + ", devGender=" + devGender
				+ ", devLang=" + Arrays.toString(devLang) + "]";
	}
	
	
}

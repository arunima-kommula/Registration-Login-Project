package com.register.model;

import java.io.Serializable;

public class LoginBean implements Serializable {
	
    private String userid;
    private String pass;
    
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

   
}

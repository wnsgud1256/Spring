package com.company.hellospring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient; 

//어노테이션 관련.

@XmlRootElement(name = "datas")			//root경로 설정을 datas로 함.
@XmlAccessorType(XmlAccessType.FIELD) //xml타입으로 바꿈
public class UserBean {
	
	String id;
	@XmlTransient 
	String pw;
	boolean result; //중복 여부값을 담기 위해 만듬.
	
	public boolean getResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
}

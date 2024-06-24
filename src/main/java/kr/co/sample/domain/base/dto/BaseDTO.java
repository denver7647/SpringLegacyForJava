package kr.co.sample.domain.base.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

public class BaseDTO {
	
	@Size(min = 2, max = 50)
	@Length(min = 2, max = 50)
	private String userName;
	private String gender;
	private int age;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}

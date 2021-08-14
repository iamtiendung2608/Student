package com.example.demo.StudentInfo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private int id;
	private String name;
	private String gender;
	private String phone;
	private String birth;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		String result=new String();
		if(gender=="Male") {
		 result = String.format("Student Id: %s, his name is: %s, phone: %s, birth:%s  ",id,name,phone,birth);
		}
		else
			result = String.format("Student Id: %s, her name is: %s, phone: %s, birth: %s  ",id,name,phone,birth);
		return result;
	}
}

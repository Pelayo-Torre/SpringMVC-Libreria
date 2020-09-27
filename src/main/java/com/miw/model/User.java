package com.miw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("deprecation")
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int id; 
	
	@NotNull @NotBlank(message="{register.err.name}")
	private String name;
	
	@NotNull @NotBlank(message="{register.err.surname}")
	private String surname;
	
	@Length(min = 8, max = 16, message = "{register.err.login}")
	private String login;
	
	@Length(min = 8, max = 30, message = "{register.err.password}")
	private String password;
	@Transient
	private String repeatPassword;
	
	@Min(value=18, message="{register.err.age}")
	@Max(value=120)
	private int age;
	
	@Email(message="{register.err.mail}")
	@NotBlank(message="{register.err.mail.null}")
	private String email;
	
	@Pattern(regexp="[9|6|7][0-9]{8}", message="{register.err.phone}")  
	private String phone;
	
	public User() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", login=" + login + 
				", age=" + age + ", email=" + email + ", phone=" + phone + "]";
	}

}

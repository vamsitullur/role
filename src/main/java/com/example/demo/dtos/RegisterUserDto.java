package com.example.demo.dtos;

public class RegisterUserDto {
	private String email;

	private String password;

	private String fullName;

	private String Role;

	public String getRole() {
		return Role;
	}

	public void setRole(String Role) {
		this.Role = Role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}

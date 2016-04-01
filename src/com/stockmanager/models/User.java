package com.stockmanager.models;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class User {

	@NotBlank(message = "Username should not be blank")
	@Size(min = 3, max = 15, message = "Username should be between 3 and 15 characters")
	@Pattern(regexp = "^\\w{3,}$", message = "Username can consist only of numbers, letters and underscore")
	private String username;

	@NotBlank(message = "Password cannot be blank.")
	@Pattern(regexp = "\\S+$", message = "Password cannot contain blank spaces")
	@Size(min = 2, max = 15, message = "Password must be between 2 and 15 characters long.")
	private String password;

	private boolean enabled = false;
	private String authority;

	public User() {

	}

	public User(String username, String password, boolean enabled, String authority) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authority = authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}

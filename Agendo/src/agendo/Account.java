package agendo;

import java.util.ArrayList;

public class Account {
	private String username;
	private String password;
	private String email;
	
	
	public Account(String username, String email, String password) {
		this.username = username;
		this.password = password;
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public String getEmail() {
		return email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String toString() {
		
		return "Email: "+email+" Username:  "+username+" Password: "+password+"\n";
	}
	
}

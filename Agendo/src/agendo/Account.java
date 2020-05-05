package agendo;

import java.util.ArrayList;

public class Account {
	private String username;
	private String password;
	private String email;
	
	
	public Account(String username, String password, String email) {
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
	
	public String toString() {
		
		return "Email: "+email+" Username:  "+username+" Password: "+password+"\n";
	}
	
}

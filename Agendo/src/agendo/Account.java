package agendo;

import java.util.ArrayList;

public class Account {
	private String username;
	private String password;
	private String email;
	private int accountID;
	
	
	public Account(String username, String email, String password, int accountID) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.setAccountID(accountID);
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


	public int getAccountID() {
		return accountID;
	}


	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
}

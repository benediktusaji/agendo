package agendo;

import java.util.ArrayList;

public class UserAccount extends Account {
	private ArrayList<Event> eventList = new ArrayList<Event>();
	
	public UserAccount(String username, String password, String email) {
		super(username, password, email);
		// TODO Auto-generated constructor stub
	}

}

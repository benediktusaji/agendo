package agendo;

import java.util.ArrayList;

public class UserAccount extends Account {
	
	private ArrayList<Event> listEvent = new ArrayList<Event>();
	
	public UserAccount(String username, String password, String email,int accountID) {
		super(username, password, email, accountID);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Event> getListEvent() {
		return listEvent;
	}

	public void setListEvent(ArrayList<Event> listEvent) {
		this.listEvent = listEvent;
	}

	public void addEvent(Event e) {
		this.listEvent.add(e);
	}
}

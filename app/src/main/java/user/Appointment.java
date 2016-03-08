package user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* After an AppointmentRequest is accepted, an Appointment is issued.
 * All of them are in the list appointments of the user.
 * Only Guests and Doctors accept and refuse AppointmentRequests. */

public class Appointment {
	
	private Date date;
	private User user1;
	private User user2;
	
	public Appointment(Date date, User user1, User user2){
		this.date=date;
		this.user1=user1;
		this.user2=user2;
	}
	
	public Date getDate(){
		return date;
	}
	
	public List<User> getUsers(){
		ArrayList<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		return users;
	}
}

package user;

import android.content.SharedPreferences;

import post.AppointmentRequest;
import post.Comment;

import java.util.ArrayList;
import java.util.List;

abstract public class User {
	private String id;
	private String password;
	protected List<AppointmentRequest> appointmentRequests;
	protected List<Appointment> appointments;
	
	public User(String id, String password, Hospital hospital){
		this.id=id;
		this.password=password;
		hospital.addUser(this);
		appointments=new ArrayList<>();
		appointmentRequests=new ArrayList<>();
	}

	
	public List<String> showProfile(){
		return new ArrayList<>();
	}
	
	public boolean addAppointmentRequest(AppointmentRequest ar){
		return appointmentRequests.add(ar);
	}
	
	public boolean deleteAppointmentRequest(AppointmentRequest ar){
		return appointmentRequests.remove(ar);
	}
	
	public boolean addAppointment(Appointment ap){
		return appointments.add(ap);
	}
	
	public boolean deleteAppointment(Appointment ap){
		return appointments.remove(ap);
	}
	
	// Method used by Hospital file
	public boolean verifyLogin(String id, String password){
		return (id.compareTo(this.id) == 0 && password.compareTo(this.password) == 0);
	}
	
	public String getID(){
		return id;
	}
	
	public String getName(){
		return "User";
	}
	
	// Comment posting
	public Comment postComment(Patient patient, String comment){
		return new Comment(this, patient, comment);
	}
}

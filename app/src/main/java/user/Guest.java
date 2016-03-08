package user;

import android.content.SharedPreferences;

import java.util.Date;
import java.util.List;

import post.AppointmentRequest;

public class Guest extends User {

	private Patient patient;
	
	public Guest(String id, String password, Hospital hospital, Patient patient) {
		super(id, password, hospital);
		this.patient=patient;
	}

	@Override
	public List<String> showProfile(){
		return patient.showProfile();
	}
	
	@Override
	public String getName(){
		return "Guest of " + patient.getName();
	}
	
	public Patient getPatient(){
		return patient;
	}


	// Handling Appointment Requests
	
	public AppointmentRequest requestAppointment(Date proposedDate, String remarks){
		return new AppointmentRequest(this, patient, patient.getDoctor(), proposedDate, remarks);
	}
	
	public AppointmentRequest requestAppointment(Date proposedDate){
		return new AppointmentRequest(this, patient, patient.getDoctor(), proposedDate);
	}
	
	public Appointment acceptAppointment(AppointmentRequest ar){
		Appointment ap = new Appointment(ar.getProposedDate(), patient.getDoctor(), this);
		this.addAppointment(ap);
		patient.getDoctor().addAppointment(ap);
		this.deleteAppointmentRequest(ar);
		return ap;
	}
	
	public boolean refuseAppointment(AppointmentRequest ar){
		return this.deleteAppointmentRequest(ar);
	}
	
	// Getters
	
	public List<Appointment> getAppointments(){
		return appointments;
	}
	
	public List<AppointmentRequest> getAppointmentRequests(){
		return appointmentRequests;
	}
}

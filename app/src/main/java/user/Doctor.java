package user;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import post.AppointmentRequest;
import post.MedicalReport;

public class Doctor extends HospitalStaff {

	private String specialization;
	
	// Constructor without description
	public Doctor(String id, String password, Hospital hospital, String name, String rank,
			String contactNumber, String specialization) {
		super(id, password, hospital, name, rank, contactNumber);
		this.specialization=specialization;
	}
	
	// Constructor with description
	public Doctor(String id, String password, Hospital hospital, String name, String rank,
			String contactNumber, String description, String specialization) {
		super(id, password, hospital, name, rank, contactNumber, description);
		this.specialization=specialization;
	}


	@Override
	public List<String> showProfile(){
		ArrayList<String> profile = new ArrayList<String>();
		profile.add("Doctor");
		profile.add(name);
		profile.add(rank);
		profile.add(specialization);
		profile.add(description);
		profile.add(contactNumber);
		profile.add(description);
		return profile;
	}
	
	// Handling Appointment Requests
	
	public AppointmentRequest requestAppointment(Date proposedDate, String remarks, Guest guest){
		return new AppointmentRequest(this, guest.getPatient(), guest, proposedDate, remarks);
	}
	
	public AppointmentRequest requestAppointment(Date proposedDate, Guest guest){
		return new AppointmentRequest(this, guest.getPatient(), guest, proposedDate);
	}
	
	public Appointment acceptAppointment(AppointmentRequest ar){
		Appointment ap = new Appointment(ar.getProposedDate(), ar.getAuthor(), this);
		this.addAppointment(ap);
		ar.getAuthor().addAppointment(ap);
		this.deleteAppointmentRequest(ar);
		return ap;
	}
	
	public boolean refuseAppointment(AppointmentRequest ar){
		return this.deleteAppointmentRequest(ar);
	}
	
	public List<Appointment> getAppointments(){
		return appointments;
	}
	
	public List<AppointmentRequest> getAppointmentRequests(){
		return appointmentRequests;
	}
	
	// Handling Medical Reports
	
	public MedicalReport createReport(Patient patient, Priority priority, String report){
		return new MedicalReport(this, patient, priority, report);
	}

}

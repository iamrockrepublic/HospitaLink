package user;

import java.util.ArrayList;
import java.util.List;

/* Hospital Database.
 * For the demo, one Hospital database is sufficient.
 * It keeps track of all users and patients by storing them. */

public class Hospital {

	private List<User> users;
	private List<Patient> patients;
	private String name;
	
	public Hospital(String name){
		this.name=name;
		this.users=new ArrayList<User>();
		this.patients=new ArrayList<Patient>();
	}
	
	// Automatic functions. No need to use by programmer
	
	public void addUser(User user){
		for (User oldUser: users){
			if (user.getID().compareTo(oldUser.getID()) == 0)
				throw new IllegalArgumentException();
		}
		if (!this.users.add(user))
			throw new IllegalArgumentException();
	}
	
	public void addPatient(Patient patient){
		for (Patient oldPatient: patients){
			if (patient.getID().compareTo(oldPatient.getID()) == 0) 
				throw new IllegalArgumentException();
		}
		if (!this.patients.add(patient))
			throw new IllegalArgumentException();
	}
	
	// Functions to delete. No use in demo.
	
	public boolean deleteUser(User user){
		return this.users.remove(user);
	}
	
	public boolean deletePatient(Patient patient){
		return this.patients.remove(patient);
	}
	
	// IMPORTANT: Use this method when trying to login.
	
	public boolean verifyLogin(String id, String password){
		for (User user: users) {
			if (user.verifyLogin(id, password)) return true;
		}
		return false;
	}
	
	// Getter
	
	public String getName(){
		return name;
	}
	
	// To get the patients list of the doctor
	
	public List<Patient> getPatientListForDoctor(Doctor doctor){
		ArrayList<Patient> patientList = new ArrayList<>();
		for (Patient patient: patients){
			if (patient.getDoctor().getID().compareTo(doctor.getID()) == 0)
				patientList.add(patient);
		}
		return patientList;
	}
	
	// A Nurse can in principle take care of all patients. Her list is a list of all patients.
	
	public List<Patient> getAllPatientsList(){
		return patients;
	}
	
}

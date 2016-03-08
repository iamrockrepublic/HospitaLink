package user;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

import post.HealthCheck;

public class Nurse extends HospitalStaff {

	// Constructor without description
	public Nurse(String id, String password, Hospital hospital, String name, String rank,
			String contactNumber) {
		super(id, password, hospital, name, rank, contactNumber);
		// TODO Auto-generated constructor stub
	}
	
	// Constructor with description
	public Nurse(String id, String password, Hospital hospital, String name, String rank,
			String contactNumber, String description) {
		super(id, password, hospital, name, rank, contactNumber, description);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<String> showProfile(){
		ArrayList<String> profile = new ArrayList<String>();
		profile.add("Nurse");
		profile.add(name);
		profile.add(rank);
		profile.add(contactNumber);
		profile.add(description);
		return profile;
	}


	// HealthCheck handling
	
	public HealthCheck checkHealth(Patient patient, int heartRate, int bloodRate, int bloodSugarLevel,
			int temperature, String remarks){
		return new HealthCheck(this, patient, heartRate, bloodRate, bloodSugarLevel, temperature, remarks);
	}

}

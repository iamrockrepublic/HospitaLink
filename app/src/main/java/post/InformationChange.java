package post;

import java.util.ArrayList;
import java.util.List;

import user.Patient;
import user.User;

/* Only published by HospitalStaff */

public class InformationChange extends StatusUpdate {

	private String illness;
	private String remarks;
	
	public InformationChange(User author, Patient patient, String illness, String remarks) {
		super(author, patient);
		this.illness=illness;
		this.remarks=remarks;
		patient.setIllness(illness);
	}
	
	public List<String> getInfoChange(){
		ArrayList<String> ic = new ArrayList<>();
		ic.add(illness);
		ic.add(remarks);
		return ic;
	}

}

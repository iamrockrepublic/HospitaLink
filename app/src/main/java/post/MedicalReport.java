package post;

import user.Patient;
import user.Priority;
import user.User;

/* Only published by Doctor */

public class MedicalReport extends StatusUpdate {

	private String report;
	
	public MedicalReport(User author, Patient patient, Priority priority, String report) {
		super(author, patient);
		this.report=report;
		patient.setPriority(priority);
	}
	
	public String getReport(){
		return report;
	}

}

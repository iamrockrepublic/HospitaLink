package post;

import user.Patient;
import user.User;

/* A healthCheck can only be published by a Nurse. */

public class HealthCheck extends StatusUpdate {

	private int heartRate, bloodRate, bloodSugarLevel, temperature;
	private String remarks;
	
	public HealthCheck(User author, Patient patient, int heartRate, int bloodRate, int bloodSugarLevel,
			int temperature, String remarks) {
		super(author, patient);
		this.heartRate=heartRate;
		this.bloodRate=bloodRate;
		this.bloodSugarLevel=bloodSugarLevel;
		this.temperature=temperature;
		this.remarks=remarks;
	}
	
	public int[] getNumbers(){
		int[] array = new int[4];
		array[0] = heartRate;
		array[1] = bloodRate;
		array[2] = bloodSugarLevel;
		array[3] = temperature;
		return array;
	}
	
	public String getRemarks(){
		return remarks;
	}

}

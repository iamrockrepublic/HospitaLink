package post;

import java.util.Date;

import user.Patient;
import user.User;

/* AppointmentRequest is used to request an appointment by the Guest or Doctor.
 * Either of them can accept or refuse the request using methods in their Java files. */

public class AppointmentRequest extends Post {

	private String remarks;
	private Date proposedDate;
	
	// Constructor
	public AppointmentRequest(User author, Patient patient, User recipient, Date proposedDate, String remarks) {
		super(author, patient);
		this.proposedDate=proposedDate;
		this.remarks=remarks;
	}
	
	// Constructor without remarks
	public AppointmentRequest(User author, Patient patient, User recipient, Date proposedDate) {
		super(author, patient);
		this.proposedDate=proposedDate;
		this.remarks="";
	}
	
	// Getters
	public Date getProposedDate(){
		return proposedDate;
	}
	
	public String getRemarks(){
		return remarks;
	}

}

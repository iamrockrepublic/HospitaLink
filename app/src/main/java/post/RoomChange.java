package post;

import java.util.ArrayList;
import java.util.List;

import user.Patient;
import user.User;

/* Only published by HospitalStaff */

public class RoomChange extends StatusUpdate {

	private int ward;
	private int room;
	private int bed;
	
	public RoomChange(User author, Patient patient, int ward, int room, int bed) {
		super(author, patient);
		this.ward=ward;
		this.room=room;
		this.bed=bed;
		patient.changeRoom(ward, room, bed);
	}
	
	public List<Integer> getRoomChange(){
		ArrayList<Integer> rc = new ArrayList<>();
		rc.add(ward);
		rc.add(room);
		rc.add(bed);
		return rc;
	}

}

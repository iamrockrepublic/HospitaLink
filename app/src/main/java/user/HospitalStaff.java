package user;

import android.content.SharedPreferences;

import post.InformationChange;
import post.RoomChange;

abstract public class HospitalStaff extends User {

	protected String name;
	protected String rank;
	protected String contactNumber;
	protected String description;
	
	// Constructor with description
	public HospitalStaff(String id, String password, Hospital hospital, String name, String rank, String contactNumber, String description) {
		super(id, password, hospital);
		this.name=name;
		this.rank=rank;
		this.contactNumber=contactNumber;
		this.description=description;
	}
	
	// Constructor without description
	public HospitalStaff(String id, String password, Hospital hospital, String name, String rank, String contactNumber) {
		super(id, password, hospital);
		this.name=name;
		this.rank=rank;
		this.contactNumber=contactNumber;
		this.description="";
	}
	
	@Override
	public String getName(){ return name; }
	public String getRank() { return rank; }
	public String getContactNumber() { return contactNumber; }
	public String getDescription() { return description; }


	// Room and Information Change
	
	public RoomChange changeRoom(Patient patient, int ward, int room, int bed){
		return new RoomChange(this, patient, ward, room, bed);
	}
	
	public InformationChange changeInfo(Patient patient, String illness, String remarks){
		return new InformationChange(this, patient, illness, remarks);
	}
	
}

package user;

import post.Post;

import java.util.ArrayList;
import java.util.List;

public class Patient {

	private String id;
	private String name;
	private String admissionTime;
	private String estimatedDischarge;
	private String illness;
	private Doctor doctor;
	private int ward;
	private int room;
	private int bed;
	private String medicalHistory;
	private Priority priority;
	private List<Post> posts;
	
	// Complete constructor
	public Patient(Hospital hospital, String id, String name, String admissionTime, String estimatedDischarge, String illness,
			Doctor doctor, int ward, int room, int bed, String medicalHistory, Priority priority){
		this.id=id;
		this.name=name;
		this.admissionTime=admissionTime;
		this.estimatedDischarge=estimatedDischarge;
		this.illness=illness;
		this.doctor=doctor;
		this.ward=ward;
		this.room=room;
		this.bed=bed;
		this.medicalHistory=medicalHistory;
		this.priority=priority;
		hospital.addPatient(this);
		this.posts=new ArrayList<>();
	}
	
	// Minimal default constructor
	public Patient(Hospital hospital, String id, String name, String admissionTime, Doctor doctor, int ward, int room, int bed){
		this.id=id;
		this.name=name;
		this.admissionTime=admissionTime;
		this.estimatedDischarge="To be determined";
		this.illness="To be determined";
		this.doctor=doctor;
		this.ward=ward;
		this.room=room;
		this.bed=bed;
		this.medicalHistory="To be determined";
		this.priority=Priority.STABLE;
		hospital.addPatient(this);
		this.posts=new ArrayList<>();
	}
	
	public void setIllness(String illness){
		this.illness=illness;
	}
	
	public void setMedicalHistory(String medicalHistory){
		this.medicalHistory=medicalHistory;
	}
	
	public void changeRoom(int ward, int room, int bed){
		this.ward=ward;
		this.room=room;
		this.bed=bed;
	}
	
	public void setPriority(Priority newPriority){
		this.priority=newPriority;
	}
	
	public Priority getPriority(){
		return priority;
	}
	
	public void setEstimatedDischarge(String estimatedDischarge){
		this.estimatedDischarge=estimatedDischarge;
	}
	
	public List<String> showProfile(){
		ArrayList<String> profile = new ArrayList<>();
		profile.add("Patient");
		profile.add(name);
		profile.add(admissionTime);
		profile.add(estimatedDischarge);
		profile.add(illness);
		profile.add(Integer.toString(ward));
		profile.add(Integer.toString(room));
		profile.add(Integer.toString(bed));
		profile.add(medicalHistory);
		return profile;
	}
	
	public Doctor getDoctor(){
		return doctor;
	}
	
	public void setDoctor(Doctor newDoctor){
		this.doctor=newDoctor;
	}
	
	public String getID(){
		return id;
	}
	
	// No need to use. Used to automatically add when the post is created
	public boolean addPost(Post post){
		return posts.add(post);
	}
	
	// IMPORTANT: For admission details page
	public List<Post> getPosts(){
		return posts;
	}
	
	public String getName(){
		return name;
	}
	
}

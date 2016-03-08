package post;

import user.Patient;
import user.User;

/* A Comment can be published by any user using methods in User file. */

public class Comment extends Post {

	private String comment;
	
	public Comment(User author, Patient patient, String comment) {
		super(author, patient);
		this.comment=comment;
	}
	
	public String getComment(){
		return comment;
	}

}

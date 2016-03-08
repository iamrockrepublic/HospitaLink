package post;
import java.util.Date;

import user.User;
import user.Patient;

/* Abstract generalisation class */

abstract public class Post {
	private User author;
	private Date date;
	
	public Post(User author, Patient patient){
		this.date=new Date();
		this.author=author;
		patient.addPost(this);
	}
	
	public String getDate(){
		return date.toString();
	}
	
	public User getAuthor(){
		return author;
	}
}

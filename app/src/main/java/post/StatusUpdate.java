package post;

import user.Patient;
import user.User;

/* Abstract generalisation class to use in screen where user choses what StatusUpdate to publish. */

abstract class StatusUpdate extends Post {

	public StatusUpdate(User author, Patient patient) {
		super(author, patient);
	}
	
}

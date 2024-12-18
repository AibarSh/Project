package ResearchWork;

import Users.User;

public class UserDecorator{

	protected User decoratedUser;
	

	public UserDecorator(User u1){
		this.decoratedUser = u1;
	}


	public User getDecoratedUser() {
		return this.decoratedUser;	
	}
	
}


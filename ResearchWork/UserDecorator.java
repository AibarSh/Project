package ResearchWork;

import Platform.Appeals;
import Platform.News;
import Users.User;
import Users.UserDatabase;

public class UserDecorator extends User{

	protected User decoratedUser;
	

	public UserDecorator(User u1){
		this.decoratedUser = u1;
	}


	public User getDecoratedUser() {
		return this.decoratedUser;	
	}
	
	public String showCommands() {
		return super.showCommands();
	}
	
	public void console(News news, Journal journal, Appeals appeals, UserDatabase database) {
		super.console(news, journal, appeals, database);
	}
	
}


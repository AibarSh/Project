package Users;
import java.util.Set;
import java.util.HashSet;

public class UserDatabase{

	private Set<User> Users = new HashSet<>();
	

	public UserDatabase(Set<User> u){
		this.Users = u;
	}
	
	public UserDatabase() {
		
	}

	public Set<User> getUsers(){
		return this.Users;
	}
	public void addToDatabase(User parameter) {
		Users.add(parameter);
	}
	
	
	public void removeFromDatabase(User parameter) {
		Users.remove(parameter);
	}
	
	public void dataBaseCheck() {
		for(User u1 : Users) {
			System.out.println("|User: " + u1.getName() + " |Ocupation: " + u1.getClass() + " |Access to platform: " + u1.accessToPlatform() + " |");
		}
	}
}


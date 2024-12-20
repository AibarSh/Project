package Users;
import Platform.Request;
import java.util.Base64;

public class User {

	private String userID;
	private String name;
	private String hashPassword;
	private int age;
	private Languages language;
	private boolean access = true;
	

	// Constructor
	public User( String userID, String password, String name, int age, Languages language) {
		this.language = language;
		this.userID = userID;
		this.name = name;
		this.age = age;
		this.hashPassword = Base64.getEncoder().encodeToString(password.getBytes());
	}
	
	public User() {
		
	}

	// Getters and Setters
	public Languages getLanguage() {
		return language;
	}

	public void setLanguage(Languages language) {
		this.language = language;
		System.out.println("| Language changed | \n");
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	

	public String getPassword() {
		return new String(Base64.getDecoder().decode(this.hashPassword));
	}

	public void setPassword(String password1, String password2) {
		if ( password1.equals(new String(Base64.getDecoder().decode(this.hashPassword)))) {
			this.hashPassword = Base64.getEncoder().encodeToString(password2.getBytes());
		}
		else System.out.println("| Wrong password! |");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// Methods
	public boolean accessToPlatform() {
		if(this.access == true) return true;
		else return false;
		
	}
	
	public void changeAccess(boolean bool) {
		if (bool == true) this.access = true;
		else this.access = false;
	}


	public Request makeRequest(String contents) {
		return new Request(contents); 
	}

	public void viewJournal() {
		// Implementation to view the journal
	}


	public String showCommands() {
		return "| 1 - Set language | 2 - Make a request | 3 - See news | 4 - View journal | 5 - Change password | ";  // В других классах отчет идет дальше. Для примера сморти Employee
	}
}



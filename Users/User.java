package Users;
import Platform.*;

import ResearchWork.Journal;

import java.util.Base64;
import Main.InputUtil;
import Main.InvalidInputException;
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
			System.out.println("| Password set |");
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



	public String showCommands() {
		return "| 0 - Exit | 1 - Set language | 2 - Make a request | 3 - See news | 4 - View journal | 5 - Change password | ";  // В других классах отчет идет дальше. Для примера сморти Employee
	}
	
	public void console(News news, Journal journal, Appeals appeals) {
		 InputUtil inputint = new InputUtil();
	     InputUtil inputstr = new InputUtil();
		 boolean running = true;	
			while(running) {
				
				System.out.println(showCommands());
				int input = inputint.getIntInput("Enter your command: \n");
				
				if(input == 0) {
					running = false;
					System.out.println("=====                     Exiting...                   =====");
					break;
				}
				
				switch(input) {
					case(1):
							try {
								int inpt = inputint.getIntInput("| English - 1 | Russian - 2 | Kazakh - 3 | ");
								if (inpt < 4 && inpt > 0) {
									if (inpt == 1) {
										setLanguage(Languages.English);
										
									}
									else if (inpt == 2) {
										setLanguage(Languages.Russian);
										
									}
									else {
										setLanguage(Languages.Kazakh);
																		
									}
						
								}
								else System.out.println("| Invalid input, try again | ");
								
							}
							catch(Exception e) {
								System.out.println("| Error occured... | \n");
							}
							break;
							
					case(2):
						try {
							String bait = inputstr.getStringInput(""); // нужен для очистки стрима
							String contents = inputstr.getStringInput("Enter request contents: ");
							Request req = new Request(contents);
							appeals.addToRequestList(req);		
							System.out.println("| Request send | \n");
						}
							
						catch(Exception e) {
							System.out.println("| Error occured... | \n");
						}
						break;
					
					case(3):
						try {
							news.getNews();
						}
						
						catch(Exception e ) {
							System.out.println("| Error occured... | \n");
						}
						break;
						
						
					case(4):
						try {
							journal.viewJournal();
							
						}
						catch(Exception e) {
							System.out.println("| Error occured... | \n");
						}
						break;
						
					case(5):
						try {
							String bait = inputstr.getStringInput(""); // нужен для очистки стрима
							String currentPassword = inputstr.getStringInput("Enter your current password: ");
							String newPassword = inputstr.getStringInput("\nEnter your new password: ");
							setPassword(currentPassword, newPassword);
							
						}
						catch(Exception e) {
							
						}
						break;
				}
				}
			}
}



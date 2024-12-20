package Users;
import java.util.Date;

import Platform.Courses;
import ResearchWork.Journal;

public class Admin extends Employee {

	// Constructor
	public Admin(Languages language, String userID, String password, String name, int age, int salary, Date dateOfEmployment) {
		super(language, userID, password, name, age, salary, dateOfEmployment);
	}
	public Admin() {
	
	}

	// Methods
	public void addToDatabase(UserDatabase base, User u1) {
		base.addToDatabase(u1);
		System.out.println("| "+ u1.getClass() + " " + u1.getName() +  " has been added to the database| "); 
	}
	
	
	public User findInDatabase(UserDatabase base1,  String userID, String password) {
		for(User u2 : base1.getUsers()) {
			if(userID.equals(u2.getUserID())) {
				if(password.equals(u2.getPassword())) {
					return u2;
				}
			}
		}
		return null;
		
	}

	public void removeFromDatabase(UserDatabase base, User u1) {
		base.removeFromDatabase(u1);
		System.out.println("| "+ u1.getClass() + " " + u1.getName() + " has been removed from the database | "); 
	}

	public void manageAccess(User user, boolean bool) {
			user.changeAccess(bool);
	}
	
	public User createUser(String userID, String password, String name, int age, Languages language) {
		return new User(userID, password, name, age,language);
	}
	
	public Student createStudent(Languages language, String userID, String password, String name, int age,
			   Faculties faculty, Courses course, Journal journal) {
		return new Student(language, userID, password, name, age, faculty, course, journal);
	}
	
//	public Employee createEmployee(Languages language, String userID, String password, String name, int age,
//			HealthStatuses healthStatus, FamilyStatuses familyStatus,
//			int salary, Date dateOfEmployment) {
//		return new Employee(language, userID, password, name, age, healthStatus, familyStatus, salary, dateOfEmployment);
//	}


	@Override
	public String showCommands() {
		return super.showCommands() + "8 - Add to database | 9 - Remove from database | 10 - Manage access to the database | 11 - create user | "; 
	}//  Не забывай. Цифры могут повторятся для разных классов

}


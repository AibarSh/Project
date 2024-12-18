package Users;
import java.util.Date;

import Platform.Courses;
import ResearchWork.Journal;

public class Admin extends Employee {

	// Constructor
	public Admin(Languages language, String userID, String password, String name, int age,
				 HealthStatuses healthStatus, FamilyStatuses familyStatus,
				 int salary, Date dateOfEmployment) {
		super(language, userID, password, name, age, healthStatus, familyStatus, salary, dateOfEmployment);
	}
	public Admin() {
	
	}

	// Methods
	public void addToDatabase(UserDatabase base, User u1) {
		base.addToDatabase(u1);
		System.out.println("| "+ u1.getClass() + " " + u1.getName() +  " has been added to the database| "); 
	}

	public void removeFromDatabase(UserDatabase base, User u1) {
		base.removeFromDatabase(u1);
		System.out.println("| "+ u1.getClass() + " " + u1.getName() + " has been removed from the database | "); 
	}

	public void manageAccess(User user, boolean bool) {
			user.changeAccess(bool);
	}
	
	public User createUser(String userID, String password, String name, int age,
			HealthStatuses healthStatus, FamilyStatuses familyStatus, Languages language) {
		return new User(userID, password, name, age, healthStatus, familyStatus, language);
	}
	
	public Student createStudent(Languages language, String userID, String password, String name, int age,
			   HealthStatuses healthStatus, FamilyStatuses familyStatus, 
			   Faculties faculty, Courses course, Journal journal, Organizations organization, Position position) {
		return new Student(language, userID, password, name, age, healthStatus, familyStatus, faculty, course, journal, organization, position );
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


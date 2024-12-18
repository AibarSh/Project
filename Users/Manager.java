package Users;
import java.util.Date;
import Platform.Course;

public class Manager extends Employee
{

	private Faculties department;
	

	public Manager(Languages language, String userID, String password, String name, int age,
				   HealthStatuses healthStatus, FamilyStatuses familyStatus,
				   int salary, Date dateOfEmployment, Faculties department){
		super(language, userID, password, name, age, healthStatus, familyStatus,  salary, dateOfEmployment);
		this.department = department;

	}

	public Faculties getDepartment() {
		return department;
	}

	public void setDepartment(Faculties department) {
		this.department = department;
	}


	public void viewComplaints() {
		// TODO implement me	
	}
	

	public Course makeSchedule() {
		// TODO implement me
		return null;	
	}

	
	public void platformRestriction(User parameter, boolean parameter2) {
		// TODO implement me	
	}

	
	public String showCommands() {
		// TODO implement me
		return "";	
	}

	
	public void addNews() {
		// TODO implement me	
	}

	
	public void deleteNews() {
		// TODO implement me	
	}

	
	public void updateNews() {
		// TODO implement me	
	}

	
	public void viewrequest(Employee e) {
		// TODO implement me	
	}
	
	public void createstat(Student parameter) {
		// TODO implement me	
	}

	
	
}


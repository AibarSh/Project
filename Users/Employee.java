package Users;
import java.util.Date;
import java.util.Vector;
public abstract class Employee extends User {

	private int salary;
	private Date dateOfEmployment;
	private Vector<String> messages = new Vector<>();

	public Employee(Languages language, String userID, String password, String name, int age,
					HealthStatuses healthStatus, FamilyStatuses familyStatus,
					int salary, Date dateOfEmployment) {
		super(userID, password, name, age, healthStatus, familyStatus, language);
		this.salary = salary;
		this.dateOfEmployment = dateOfEmployment;
	}
	
	public Employee() {
		
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getDateOfEmployment() {
		return dateOfEmployment;
	}

	public void setDateOfEmployment(Date dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}

	public void sendMessage(Employee to, String message) {
		to.addMessage(message);
	}
	
	public void addMessage(String message) {
		messages.add(message);
	}
	
	public void showMessages() {
		for(String ms : messages) {
			System.out.println("ms");
		}
	}
	

	@Override
	public String showCommands() {
	
		return super.showCommands() + "6 - Send message | 7 - Show messages | ";  // Начало в юзере, делай продолжение для всех подклассов и про студентов не забудь
	} // посмотри как у админа дальше идет
}



package Users;
import java.util.Date;
import Platform.Complaint;
import Platform.Request;

public class Dean extends Employee {

	public Dean(Languages language, String userID, String password, String name, int age,
				int salary, Date dateOfEmployment) {
		super(language, userID, password, name, age, salary, dateOfEmployment);
	}

	// Methods
	public void viewComplaint(Complaint parameter) {
		// TODO implement the logic to view a complaint
	}

	public void viewRequest(Request parameter) {
		// TODO implement the logic to view a request
	}

	public void acceptRequest(Request parameter) {
		// TODO implement the logic to accept a request
	}

	public void declineRequest(Request parameter) {
		// TODO implement the logic to decline a request
	}

	@Override
	public String showCommands() {
		return "8 - View Complaint | 9 - View Request | 10 - Accept Request | 11 - Decline Request";
	}


	
}



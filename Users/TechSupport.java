package Users;
import java.util.Vector;

import Platform.Appeals;
import Platform.Order;

import java.util.Date;

public class TechSupport extends Employee {

	// Attributes
	private Vector<Order> orders = new Vector<>();

	// Constructor
	public TechSupport(Languages language, String userID, String password, String name, int age,
					   HealthStatuses healthStatus, FamilyStatuses familyStatus,
					   int salary, Date dateOfEmployment) {
		super(language, userID, password, name, age, healthStatus, familyStatus,  salary, dateOfEmployment);
		this.orders = orders;
	}

	// Getters and Setters
	public Vector<Order> getOrders() {
		return orders;
	}

	public void setOrders(Vector<Order> orders) {
		this.orders = orders;
	}

	// Methods
	public void getOrders(Appeals appealOrder) {
		// Implementation to fetch specific orders based on Appeals_Order
	}

	public void executeOrders() {
		// Implementation to execute orders
	}

	@Override
	public String showCommands() {
		// Implementation to show tech support-specific commands
		return "List of tech support commands"; // Placeholder
	}

	
}


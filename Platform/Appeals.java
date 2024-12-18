package Platform;
import java.util.Vector;

public class Appeals {
	private Vector<Request> requestList = new Vector<>();;
	private Vector<Complaint> complaintList = new Vector<>();;
	private Vector<Order> orderList = new Vector<>();;
	protected static int idCounter = 0;

	public Appeals(Vector<Request> requestList, Vector<Complaint> complaintList, Vector<Order> orderList) {
		this.requestList = requestList;
		this.complaintList = complaintList;
		this.orderList = orderList;
	}
	
	public Appeals() {
		
	}
	
	// Getters and setters for requestList, complaintList, and orderList
	public Vector<Request> getRequestList() {
		return requestList;
	}

	public void setRequestList(Vector<Request> requestList) {
		this.requestList = requestList;
	}

	public Vector<Complaint> getComplaintList() {
		return complaintList;
	}

	public void setComplaintList(Vector<Complaint> complaintList) {
		this.complaintList = complaintList;
	}

	public Vector<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(Vector<Order> orderList) {
		this.orderList = orderList;
	}
	
	public void addToRequestList(Request req) {
		req.setRequestID(++idCounter);
		this.requestList.add(req);
	}
	
	public void addToComplaintList(Complaint com) {
		com.setComplaintID(++idCounter);
		this.complaintList.add(com);
	}
	
	public void addToOrderList(Order ord) {
		ord.setOrderID(++idCounter);
		this.orderList.add(ord);
	}
	

	@Override
	public String toString() {
		return "Appeals{" +
				"requestList=" + requestList +
				", complaintList=" + complaintList +
				", orderList=" + orderList +
				'}';
	}
}

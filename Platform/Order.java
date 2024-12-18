package Platform;

public class Order {

	private int  orderID;
	private String orderContents;

	public Order(String c) {
		this.orderContents = c;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getOrderContents() {
		return orderContents;
	}

	public void setOrderContents(String orderContents) {
		this.orderContents = orderContents;
	}

	@Override
	public String toString() {
		return "Order{" +
				"orderID=" + orderID +
				", orderContents='" + orderContents + '\'' +
				'}';
	}
}

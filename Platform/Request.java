package Platform;

public class Request {
	private int requestID;
	private String reqContents;

	public Request(String con) {
		this.reqContents = con;
	}
	
	public void setRequestID(int id) {
		this.requestID = id;
	}

	public int getRequestID() {
		return requestID;
	}

	public String getReqContents() {
		return reqContents;
	}

	public void setReqContents(String reqContents) {
		this.reqContents = reqContents;
	}

	@Override
	public String toString() {
		return "Request{" +
				"requestID=" + requestID +
				", reqContents='" + reqContents + '\'' +
				'}';
	}
}

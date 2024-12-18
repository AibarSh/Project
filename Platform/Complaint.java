package Platform;

public class Complaint {
	private int complaintID;
	private String comContents;

	public Complaint(String c) {
		this.comContents = c;
	}

	public int getComplaintID() {
		return complaintID;
	}

	public void setComplaintID(int complaintID) {
		this.complaintID = complaintID;
	}

	public String getComContents() {
		return comContents;
	}

	public void setComContents(String comContents) {
		this.comContents = comContents;
	}

	@Override
	public String toString() {
		return "Complaint{" +
				"complaintID=" + complaintID +
				", comContents='" + comContents + '\'' +
				'}';
	}
}

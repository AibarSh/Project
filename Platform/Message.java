package Platform;

public class Message {
	private int messageID;
	private String message;

	public Message(int n, String s) {
		this.messageID = n;
		this.message = s;
	}

	public int getMessageID() {
		return messageID;
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message{" +
				"messageID=" + messageID +
				", message='" + message + '\'' +
				'}';
	}
}

package Platform;

public class Mark {
	private Marks marks;

	public Mark(Marks mark) {
		this.marks = mark;
	}

	public Marks getMarks() {
		return marks;
	}

	public void setMarks(Marks marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Mark{" +
				"marks=" + marks +
				'}';
	}
}

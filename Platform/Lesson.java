package Platform;

import java.util.Vector;

public class Lesson {
	Vector<Integer> marks = new Vector<>();
	public String lesson;
	private int lessonID;
	private int days;
	private LessonTypes lessontype;

	public Lesson(String s1, int n, int s2, LessonTypes t) {
		this.lesson = s1;
		this.lessonID = n;
		this.lessontype = t;
		this.days = s2;
	}

	public void addMarks(int n) {
		marks.add(n);
	}

	public int sumMarks() {
		int sum = 0;
		for (int i = 0; i < marks.size(); i++) {
			sum += marks.elementAt(i);
		}
		return sum;
	}

	public String getLesson() {
		return lesson;
	}

	public void setLesson(String lesson) {
		this.lesson = lesson;
	}

	public int getLessonID() {
		return lessonID;
	}

	public void setLessonID(int lessonID) {
		this.lessonID = lessonID;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public LessonTypes getLessontype() {
		return lessontype;
	}

	public void setLessontype(LessonTypes lessontype) {
		this.lessontype = lessontype;
	}

	@Override
	public String toString() {
		return "Lesson{" +
				"lesson='" + lesson + '\'' +
				", lessonID=" + lessonID +
				", days=" + days +
				", lessontype=" + lessontype +
				", marks=" + marks +
				'}';
	}
}

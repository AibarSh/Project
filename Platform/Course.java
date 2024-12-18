package Platform;

import java.util.Vector;

import Users.Student;

public class Course {
	private int courseID;
	private String courseName;
	private Vector<Student> studentsEnrolled = new Vector<>();
	private Vector<String> instructors = new Vector<>();
	private Vector<String> prereq = new Vector<>();
	public CourseTypes type;
	private Vector<Integer> marks = new Vector<>();

	public Course(int n, String s) {
		this.courseID = n;
		this.courseName = s;
	}

	public void addStudents(Student s) {
		studentsEnrolled.addElement(s);
	}

	public void addInstructors(String s) {
		instructors.addElement(s);
	}

	public void addPrereq(String s) {
		prereq.addElement(s);
	}

	public void addMark(int i) {
		marks.addElement(i);
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return "Course{" +
				"courseID=" + courseID +
				", courseName='" + courseName + '\'' +
				", studentsEnrolled=" + studentsEnrolled +
				", instructors=" + instructors +
				", prereq=" + prereq +
				", type=" + type +
				", marks=" + marks +
				'}';
	}
}

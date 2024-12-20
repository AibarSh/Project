package Users;
import java.util.Date;
import java.util.Vector;

import Platform.Courses;
public class Teacher extends Employee {

	private Faculties faculty;
	private boolean isProfessor;
	private TeacherType teacherType;
	private Vector<Courses> courses;

	public Teacher(Languages language, String userID, String password, String name, int age,
				   int salary, Date dateOfEmployment, Faculties faculty,
				   boolean isProfessor, TeacherType teacherType, Vector<Courses> courses) {
		super(language, userID, password, name, age, salary, dateOfEmployment);
		this.faculty = faculty;
		this.isProfessor = isProfessor;
		this.teacherType = teacherType;
		this.courses = courses;
	}

	// Getters and Setters
	public Faculties getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculties faculty) {
		this.faculty = faculty;
	}

	public boolean isProfessor() {
		return isProfessor;
	}

	public void setProfessor(boolean isProfessor) {
		this.isProfessor = isProfessor;
	}

	public TeacherType getTeacherType() {
		return teacherType;
	}

	public void setTeacherType(TeacherType teacherType) {
		this.teacherType = teacherType;
	}

	public Vector<Courses> getCourses() {
		return courses;
	}

	public void setCourses(Vector<Courses> courses) {
		this.courses = courses;
	}

	public void makeComplaint(Student student, UrgencyLevel urgencyLevel) {
		// Implementation to make a complaint about a student
	}

	public void putMark() {
		// Implementation to put a mark for a student
	}

	public void getCoursesList() {
		// Implementation to get the list of courses
	}

	public TeacherType getType() {
		return this.teacherType;
	}

	public void viewStudent(Student student) {
		// Implementation to view a student's details
	}

	public void viewCourses() {
		// Implementation to view courses taught by the teacher
	}

	public void addLesson() {
		// Implementation to add a new lesson
	}

	@Override
	public String showCommands() {
		// Implementation to show teacher-specific commands
		return "List of teacher commands"; // Placeholder
	}

	
}


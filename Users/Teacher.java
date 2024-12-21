package Users;
import java.util.*;

import Platform.Course;
import Platform.Journal1;

public class Teacher extends Employee {
	private String name;
	private Faculties faculty;
	private boolean isProfessor;
	private TeacherType teacherType;
	private List<Course> courses;

	public Teacher(Languages language, String userID, String password, String name, int age,
				   int salary, Date dateOfEmployment, Faculties faculty,
				   boolean isProfessor, TeacherType teacherType) {
		super(language, userID, password, name, age, salary, dateOfEmployment);
		this.faculty = faculty;
		this.isProfessor = isProfessor;
		this.teacherType = teacherType;
		this.courses = new ArrayList<>();
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

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		courses.add(course);
		course.setTeacherName(this.getName());
	}

	public void viewCourses() {
		if (courses.isEmpty()) {
			System.out.println(name + " has no courses.");
		} else {
			System.out.println(name + " teaches the following courses:");
			for (Course course : courses) {
				System.out.println("Course: " + course.getSubjectName() + ", ID: " + course.getCourseId());
			}
		}
	}

	public void makeComplaint(Student student, UrgencyLevel urgencyLevel) {

	}

	public void putMark(Student student, String subject, String date, int grade) {
		Journal1 journal = student.getJournal();
		journal.addGrade(subject, date, grade);
	}

	public void viewStudentGrades(Student student, String subject) {
		System.out.println("Marks of student " + student.getName() + " for the subject " + subject + ":");
		Map<String, Integer> subjectGrades = student.getJournal().getGrades().get(subject);

		if (subjectGrades == null) {
			System.out.println("  Subject " + subject + " is missing in journal.");
			return;
		}

		for (Map.Entry<String, Integer> entry : subjectGrades.entrySet()) {
			System.out.println("  Date: " + entry.getKey() + ", Grade: " + entry.getValue());
		}
	}

	public void viewStudentCourses(Student student) {
		System.out.println("List of subjects of a student " + student.getName() + ":");
		student.viewCourses();
	}

	public void getCoursesList() {

	}

	public TeacherType getType() {
		return this.teacherType;
	}


	public void addLesson() {

	}

	@Override
	public String showCommands() {
		// Implementation to show teacher-specific commands
		return "List of teacher commands"; // Placeholder
	}

	
}


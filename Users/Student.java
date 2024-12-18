package Users;

import Platform.Course;
import Platform.Courses;
import ResearchWork.Journal;

public class Student extends User {

	private Faculties faculty;
	private Courses course;
	private Journal journal;
	private Organizations organization;
	private Position position;

	public Student(Languages language, String userID, String password, String name, int age,
				   HealthStatuses healthStatus, FamilyStatuses familyStatus, 
				   Faculties faculty, Courses course, Journal journal, Organizations organization, Position position) {
		super( userID, password, name, age, healthStatus, familyStatus, language);
		this.faculty = faculty;
		this.course = course;
		this.journal = journal;
		this.organization = organization;
		this.position = position;
	}

	public Faculties getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculties faculty) {
		this.faculty = faculty;
	}

	public Courses getCourse() {
		return course;
	}

	public void setCourse(Courses course) {
		this.course = course;
	}

	public Journal getJournal() {
		return journal;
	}

	public void setJournal(Journal journal) {
		this.journal = journal;
	}

	public Organizations getOrganization() {
		return organization;
	}

	public void setOrganization(Organizations organization) {
		this.organization = organization;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void viewCourses() {
		// Implementation for viewing courses
	}

	public void registrationForCourses() {
		// Implementation for course registration
	}

	public String getCourseInfo() {
		// Implementation to get course info
		return "Course Info"; // Placeholder
	}

	public void viewMarks(Course course) {
		// Implementation to view marks for a course
	}

	public void viewTranscript() {
		// Implementation to view transcript
	}

	public String getTranscript() {
		// Implementation to get transcript as string
		return "Transcript"; // Placeholder
	}

	public void rateTeacher() {
		// Implementation to rate a teacher
	}

	@Override
	public String showCommands() {
		return "List of student commands"; // Placeholder
	}

	@Override
	public void viewJournal() {
		// Implementation to view journal for student
	}
}


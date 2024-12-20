package Users;
import Platform.Course;
import Platform.Courses;
import Platform.Journal1;
import Platform.Marks;
import ResearchWork.Journal;

import java.util.Map;
import java.util.Scanner;

public class Student extends User {

	private Faculties faculty;
	private Courses course;
	private Journal1 journal;
	private Organizations organization;
	private Position position;
	private String name;
	private String userId;
	private int yearofe;
	public Student(Languages language, String userID, String password, String name, int age,
				   HealthStatuses healthStatus, FamilyStatuses familyStatus, 
				   Faculties faculty, Courses course, Organizations organization, Position position, int yearofe) {
		super( userID, password, name, age, healthStatus, familyStatus, language);
		this.faculty = faculty;
		this.course = course;
		this.organization = organization;
		this.position = position;
		this.journal=new Journal1(userID);
		this.yearofe=yearofe;
	}

	public Faculties getFaculty() {
		return faculty;
	}

	public Journal1 getJournal() {return journal;}

	public void setFaculty(Faculties faculty) {
		this.faculty = faculty;
	}

	public int getCourse() {
		return yearofe;
	}

	public void setCourse(int course) { this.yearofe = course; }

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
		Map<String, Map<String, Integer>> grades = journal.getGrades();
		if (grades.isEmpty()) {
			System.out.println("Student " + name + " does not have any courses yet.");
			return;
		}

		System.out.println("List of courses of student " + name + ":");
		for (String subject : grades.keySet()) {
			System.out.println("  - " + subject);
		}
	}

	public void registrationForCourses() {
	}

	public String getCourseInfo() {
		// Implementation to get course info
		return "Course Info"; // Placeholder
	}

	public Marks viewMarks() {
		Scanner subjname = new Scanner(System.in);
		System.out.println("Please enter the course name: ");
		String courseName = subjname.nextLine();
		Marks totalMarks = journal.getFullMark(courseName);
		return totalMarks;
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

	public void displayJournal(String subject) {
		Map<String, Map<String, Integer>> grades = journal.getGrades();
		Map<String, Integer> subjectGrades = grades.get(subject);

		if (subjectGrades == null) {
			System.out.println("Subject " + subject + " cannot be found for " + name + ".");
			return;
		}

		System.out.println("Grades for " + subject + " for " + name + ":");
		for (Map.Entry<String, Integer> entry : subjectGrades.entrySet()) {
			System.out.println("  Date: " + entry.getKey() + ", Grade: " + entry.getValue());
		}
	}

	@Override
	public String showCommands() {
		return "List of student commands"; // Placeholder
	}


}


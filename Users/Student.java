package Users;
import Platform.*;
import ResearchWork.*;
import Main.*;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;
public class Student extends User {

	private Faculties faculty;
	private Courses course;
	private StudentJournal journal;
	private Organizations organization;
	private Position position;
	private String name;
	private String userId;
	private Vector<Course> courseslist;
	public Student(Languages language, String userID, String password, String name, int age,
				   Faculties faculty, Courses course, Vector<Course> courseslist) {
		super( userID, password, name, age, language);
		this.faculty = faculty;
		this.course = course;
		this.journal=new StudentJournal(userID);
		this.courseslist=courseslist;

	}

	public Faculties getFaculty() {
		return faculty;
	}

	public StudentJournal getJournal() {return journal;}

	public void setFaculty(Faculties faculty) {
		this.faculty = faculty;
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

	public void viewCourseList() {
		for (Course value : courseslist) {
			System.out.println(value.getCourseId() + " - " + value.getSubjectName());
		}
	}

	public void registrationForCourses(String courseId) {
		for (Course value : courseslist) {
			if (value.getCourseId().equals(courseId)) {
				value.addStudent(this.userId, this.name);
				this.getJournal().addGrade(value.getSubjectName(), LocalDate.now().toString(), 1);
			}
		}
	}

	public String getCourseInfo() {
		// Implementation to get course info
		return "Course Info"; // Placeholder
	}

	public Marks viewMarks(String courseName) {
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
			System.out.println("Subject " + subject + " cannot be found for " + this.name + ".");
			return;
		}

		System.out.println("Grades for " + subject + " for " + this.name + ":");
		for (Map.Entry<String, Integer> entry : subjectGrades.entrySet()) {
			System.out.println("  Date: " + entry.getKey() + ", Grade: " + entry.getValue());
		}
	}

	@Override
	public String showCommands() {
		return super.showCommands() + "6 - View Courses | 7 - Registration for Courses | " +
				"8 - Display Journal | 9 - View Marks";
	}


	public void console(News news, Journal journal, Appeals appeals, UserDatabase users) {
		InputUtil inputint = new InputUtil();
		InputUtil inputstr = new InputUtil();
		boolean running = true;
		while(running) {

			System.out.println(showCommands());
			int input = inputint.getIntInput("Enter your command: \n");

			if(input == 0) {
				running = false;
				System.out.println("=====                     Exiting...                   =====");
				break;
			}

			switch(input) {
				case(1):
					try {
						int inpt = inputint.getIntInput("| English - 1 | Russian - 2 | Kazakh - 3 | ");
						if (inpt < 4 && inpt > 0) {
							if (inpt == 1) {
								setLanguage(Languages.English);

							}
							else if (inpt == 2) {
								setLanguage(Languages.Russian);

							}
							else {
								setLanguage(Languages.Kazakh);

							}

						}
						else System.out.println("| Invalid input, try again | ");

					}
					catch(Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case(2):
					try {
						String bait = inputstr.getStringInput(""); // нужен для очистки стрима
						String contents = inputstr.getStringInput("Enter request contents: ");
						Request req = new Request(contents);
						appeals.addToRequestList(req);
						System.out.println("| Request send | \n");
					}

					catch(Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case(3):
					try {
						news.getNews();
					}

					catch(Exception e ) {
						System.out.println("| Error occured... | \n");
					}
					break;


				case(4):
					try {
						journal.viewJournal();

					}
					catch(Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case(5):
					try {
						String bait = inputstr.getStringInput(""); // нужен для очистки стрима
						String currentPassword = inputstr.getStringInput("Enter your current password: ");
						String newPassword = inputstr.getStringInput("\nEnter your new password: ");
						setPassword(currentPassword, newPassword);

					}
					catch(Exception e) {

					}
					break;

				case(6):
					try {
						viewCourseList();
					} catch (Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case(7):
					try{
						String bait = inputstr.getStringInput("");
						System.out.println("List of Available Courses: \n");
						viewCourseList();

						String courseIdReg = inputstr.getStringInput("Enter the course's ID you want to register: ");
						boolean courseFound = false;

						for (Course value : courseslist) {
							if (courseIdReg.equals(value.getCourseId())) {
								courseFound = true;
								break;
								}
							}

						if (courseFound) {
							registrationForCourses(courseIdReg);
							System.out.println("Registration Successful.");

							}
						else{
							System.out.println("Course not found. Please check the course ID and try again.");
							}
						} catch (Exception e) {
							System.out.println("| Error occured... | \n");
						}
						break;

				case(8):
					try {
						String bait = inputstr.getStringInput("");
						String subject = inputstr.getStringInput("Enter the subject which journal you want to see: ");
						displayJournal(subject);
					}
					catch (Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case(9):
					try{
						String bait = inputstr.getStringInput("");
						String cn = inputstr.getStringInput("Enter the course name: ");
						System.out.println(viewMarks(cn));
							} catch (Exception e) {
								System.out.println("| Error occured... | \n");
							}
							break;
					}
			}
		}


	}

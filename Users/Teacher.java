package Users;
import java.util.*;

import Main.InputUtil;
import java.time.LocalDate;
import Platform.*;
import ResearchWork.Journal;

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

	public void addCourse(String Id) {
		for(int i=0; i<courses.size(); i++) {
			if(Id == courses.get(i).getCourseId()){
				courses.add(courses.get(i));
				courses.get(i).setTeacherName(this.getName());
			}
			else {
				System.out.println("Course not found");
			}
		}
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
		StudentJournal journal = student.getJournal();
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

	public TeacherType getType() {
		return this.teacherType;
	}


	public void addLesson() {

	}

	@Override
	public String showCommands() {
		return super.showCommands() + "8 - Add Course | 9 - View Courses | 10 - Put Mark | " +
				"11 - View Student Grades | 12 - View Student Courses | 13 - Get Courses List ";
	}
	public void console(News news, Journal journal, StudentJournal stdJournal, Course course, Appeals appeals, UserDatabase Users) {
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
					try{
						String bait = inputstr.getStringInput("");
						String recipient = inputstr.getStringInput("Enter your recipient name: ");
						String message = inputstr.getStringInput("Enter your message: ");
						sendMessage(this, message);
					}
					catch(Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case(7):
					try {
						showMessages();
					}
					catch(Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case(8):
					try{
						String id = inputstr.getStringInput("Enter ID of course: ");
						addCourse(id);
					}
					catch(Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case(9):
					try{
						viewCourses();
					}
					catch(Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case(10):
					try {
						String stid = inputstr.getStringInput("Enter Student ID: ");
						int grade = inputint.getIntInput("Enter your grade: ");
						String subj = inputstr.getStringInput("Enter your subject: ");
						Set<Student> list = Users.getAllStudents();
						for (Student element : list) {
							if(element.getUserID().equals(stid)) {
								putMark(element,subj , LocalDate.now().toString(), grade);
							}
							else {
								System.out.println("Student with ID" + element.getUserID() + " does not exist.");
							}
						}
					}
					catch(Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case(11):
					try {
						String stid = inputstr.getStringInput("Enter Student ID: ");
						String subj = inputstr.getStringInput("Enter your subject: ");
						Set<Student> list = Users.getAllStudents();
						for (Student element : list) {
							if(element.getUserID().equals(stid)) {
								viewStudentGrades(element, subj);
							}
							else {
								System.out.println("Student with ID" + element.getUserID() + " does not exist.");
							}
						}
					}
					catch(Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case(12):
					try {
						String stid = inputstr.getStringInput("Enter Student ID: ");
						Set<Student> list = Users.getAllStudents();
						for (Student element : list) {
							if(element.getUserID().equals(stid)) {
								viewStudentCourses(element);
							}
							else {
								System.out.println("Student with ID" + element.getUserID() + " does not exist.");
							}
						}
					}
					catch(Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case(13):
					try {
						for(Course element : courses) {
							System.out.println(element.getCourseId()+" - "+element.getSubjectName());
						}
					}
					catch(Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;
			}
		}
	}
}

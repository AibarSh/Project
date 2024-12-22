package Users;
import java.time.LocalDateTime;
import java.util.*;

import Main.InputUtil;
import java.time.LocalDate;
import Platform.*;
import ResearchWork.Journal;
import ResearchWork.ResearchPaper;
import ResearchWork.ResearchProject;

public class Teacher extends Employee {
	private final ArrayList<Course> listofcourses;
	private String name;
	private Faculties faculty;
	private boolean isProfessor;
	private TeacherType teacherType;
	private Vector<Course> courses;
	private boolean isResearcher;
	private Vector<ResearchPaper> researchPapers;
	private Vector<ResearchProject> researchProjects;

	public Teacher(Languages language, String userID, String password, String name, int age,
				   int salary, Date dateOfEmployment, Faculties faculty, Vector<Course> courses,
				   boolean isProfessor, TeacherType teacherType,Vector<ResearchPaper> researchPapers,Vector<ResearchProject> researchProjects) {
		super(language, userID, password, name, age, salary, dateOfEmployment);
		this.faculty = faculty;
		this.isProfessor = isProfessor;
		this.teacherType = teacherType;
		this.listofcourses = new ArrayList<>();
		this.courses = courses;
		this.isResearcher = false;
		this.researchPapers = researchPapers;
		this.researchProjects = researchProjects;
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
        for (Course cours : courses) {
            if (cours.getCourseId().equals(Id)) {
                listofcourses.add(cours);
                cours.setTeacherName(this.getName());
				break;
            }
        }
	}

	public void viewCourses() {
		if (listofcourses.isEmpty()) {
			System.out.println(name + " has no courses.");
		} else {
			System.out.println(name + " teaches the following courses:");
			for (Course course : listofcourses) {
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

		subjectGrades.forEach((k,v) -> System.out.println("Date = "
				+ k + ", Grade = " + v));
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

	public void turnToResearcher(){
		this.isResearcher = true;
	}

	@Override
	public String showCommands() {
		if (isResearcher) {
			return super.showCommands() + "8 - Add Course | 9 - View Courses |\n| 10 - Put Mark | " +
					"11 - View Student Grades | 12 - View Student Courses | 13 - Get Courses List |\n| 15 - Print papers | 16 - Start project | 17 - Leave project |";
		} else {
			return super.showCommands() + "8 - Add Course | 9 - View Courses |\n| 10 - Put Mark | " +
					"11 - View Student Grades | 12 - View Student Courses | 13 - Get Courses List | 14 - Start Research";

		}
	}

	public void console(News news, Journal journal, StudentJournal stdJournal, Vector<Course> course, Appeals appeals, UserDatabase Users, Vector<ResearchPaper> v1, Vector<ResearchProject> v2) {
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
						String bait = inputstr.getStringInput(""); // нужен для очистки стрима
						String id = inputstr.getStringInput("Enter ID of course: ");
						this.addCourse(id);
					}
					catch(Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case(9):
					try{
						for(Course c : listofcourses) {
							System.out.println(c.getSubjectName() + " - " + c.getCourseId());
						}
					}
					catch(Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case 10:
					try {
						// Clearing the stream buffer
						String bait = inputstr.getStringInput("");

						// Getting user inputs
						String stid = inputstr.getStringInput("Enter Student ID: ");
						String subj = inputstr.getStringInput("Enter your subject: ");
						int grade = inputint.getIntInput("Enter your grade: ");



						// Getting the list of all students
						Set<Student> list = Users.getAllStudents();

						// Finding the student with the given ID and assigning the grade
						boolean studentFound = false;
						for (Student element : list) {
							if (element.getUserID().equals(stid)) {
								this.putMark(element, subj, LocalDateTime.now().toString(), grade);
								studentFound = true;
								System.out.println("Grade assigned successfully.");
								break;
							}
						}

						if (!studentFound) {
							System.out.println("Student not found with ID: " + stid);
						}
					} catch (Exception e) {
						System.out.println("| Error occurred: " + e.getMessage() + " | \n");
					}
					break;

				case(11):
					try {
						// Очистка потока (если требуется)
						inputstr.getStringInput("");

						// Ввод данных
						String stid = inputstr.getStringInput("Enter Student ID: ");
						String subj = inputstr.getStringInput("Enter your subject: ");

						// Получение списка студентов
						Set<Student> list = Users.getAllStudents();

						// Поиск студента по ID
						Optional<Student> student = list.stream()
								.filter(element -> element.getUserID().equals(stid))
								.findFirst();

						// Проверка результата и вывод оценок
						if (student.isPresent()) {
							this.viewStudentGrades(student.get(), subj);
						} else {
							System.out.println("No student found with ID: " + stid);
						}
					} catch (Exception e) {
						System.out.println("| Error occurred... | \n");
						e.printStackTrace(); // Полезно для отладки
					}
					break;


				case(12):
					try {
						String bait = inputstr.getStringInput(""); // нужен для очистки стрима
						String stid = inputstr.getStringInput("Enter Student ID: ");
						Set<Student> list = Users.getAllStudents();
						for (Student element : list) {
							if(element.getUserID().equals(stid)) {
								this.viewStudentCourses(element);
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

				case(14):
					try{
						turnToResearcher();
					}
					catch(Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case(15):
					try{
						for(ResearchPaper element : researchPapers) {
							System.out.println(element.getTitle());
						}
					}
					catch (Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case(16):
					try{
						String bait = inputstr.getStringInput("");
						String pn = inputstr.getStringInput("Enter project name: ");
						for(ResearchProject element : researchProjects) {
							if(element.getName().equals(pn)) {
								element.participants.add(this);
							}
						}
					}
					catch (Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case(17):
					try{
						String bait = inputstr.getStringInput("");
						String pn = inputstr.getStringInput("Enter project name: ");
						for(ResearchProject element : researchProjects) {
							if(element.getName().equals(pn)) {
								element.participants.remove(this);
							}
						}
					}
					catch (Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case(18):
					try{
						System.out.println("Project list: ");
						for(ResearchProject element : researchProjects) {
							if(element.participants.contains(this)) {
								System.out.println(element.getName());
							}
						}
					}
					catch (Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;
			}
		}
	}
}

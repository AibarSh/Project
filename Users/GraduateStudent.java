package Users;

import java.util.Vector;

import Platform.Courses;
import ResearchWork.Journal;
import ResearchWork.ResearchProject;
import ResearchWork.ResearcherType;

public class GraduateStudent extends Student {

	private User researchSupervisor;
	private String degree;
	private ResearcherType researcherType;
	private Vector<ResearchProject> diplomaProjects;

	public GraduateStudent(Languages language, String userID, String password, String name, int age,
						   Faculties faculty, Courses course, Journal journal,  User researchSupervisor, String degree,
						   ResearcherType researcherType) {
		super(language, userID, password, name, age, faculty, course);
		this.researchSupervisor = researchSupervisor;
		this.degree = degree;
		this.researcherType = researcherType;
		this.diplomaProjects = new Vector<>();
	}

	public User getResearchSupervisor() {
		return researchSupervisor;
	}

	public void setResearchSupervisor(User researchSupervisor) {
		this.researchSupervisor = researchSupervisor;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public ResearcherType getResearcherType() {
		return researcherType;
	}

	public void setResearcherType(ResearcherType researcherType) {
		this.researcherType = researcherType;
	}

	public Vector<ResearchProject> getDiplomaProjects() {
		return diplomaProjects;
	}

	public void setDiplomaProjects(Vector<ResearchProject> diplomaProjects) {
		this.diplomaProjects = diplomaProjects;
	}

	public String getDegreeDetails() {
		return degree;
	}

	public Vector<ResearchProject> getDiplomaProjectsList() {
		return diplomaProjects;
	}

	@Override
	public String showCommands() {
		return super.showCommands() + "10 - Get Degree Details | 11 -  Get Diploma Projects List | ";
	}

	public void console(News news, Journal journal, Appeals appeals) {
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
						viewCourses();
					} catch (Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case(7):
					try{
						System.out.println("List of Available Courses: \n");
						viewCourseList();
						String courseIdReg = inputstr.getStringInput("Enter the course you want to register: ");
						registrationForCourses(courseIdReg);
					} catch (Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case(8):
					try {
						String subject = inputstr.getStringInput("Enter the subject which journal you want to see: ");
						displayJournal(subject);
					} catch (Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case(9):
					try{
						viewMarks();
					} catch (Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case(10):
					try{
						getDegreeDetails();
					} catch (Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;

				case(11):
					try{
						getDiplomaProjectsList();
					} catch (Exception e) {
						System.out.println("| Error occured... | \n");
					}
			}
		}
	}
}

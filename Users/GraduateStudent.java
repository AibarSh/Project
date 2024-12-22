package Users;

import Platform.*;
import ResearchWork.*;
import Main.*;

import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class GraduateStudent extends Student {

	private User researchSupervisor;
	private String degree;
	private ResearcherType researcherType;
	private Vector<ResearchProject> diplomaProjects;
	private ResearcherDecorator researcherDecorator;

	public GraduateStudent(Languages language, String userID, String password, String name, int age,
						   Faculties faculty, Courses course, Vector<Course> courseslist,  User researchSupervisor, String degree, ResearcherType researcherType, Vector<ResearchProject> diplomaProjects) {
		super(language, userID, password, name, age, faculty, course, courseslist);
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

	public void getDiplomaProjectsList() {
		if (diplomaProjects == null || diplomaProjects.isEmpty()) {
			System.out.println("No diploma projects available.");
			return;
		}
		for (ResearchProject project : diplomaProjects) {
			System.out.println(project);
		}
	}


	@Override
	public String showCommands() {
		return super.showCommands() + "| 10 - Get Degree Details | 11 -  Get Diploma Projects List | ";
	}

	@Override
	public void console(News news, Journal journal, Appeals appeals) {
		InputUtil inputint = new InputUtil();
		InputUtil inputstr = new InputUtil();
		boolean running = true;

		while (running) {
			System.out.println(showCommands());
			int input = inputint.getIntInput("Enter your command: \n");

			if (input == 0) {
				running = false;
				System.out.println("=====                     Exiting...                   =====");
				break;
			}

			switch (input) {
				case 1 -> {
					try {
						String bait = inputstr.getStringInput("");
						int langInput = inputint.getIntInput("| English - 1 | Russian - 2 | Kazakh - 3 | ");
						if (langInput >= 1 && langInput <= 3) {
							setLanguage(langInput == 1 ? Languages.English :
									langInput == 2 ? Languages.Russian : Languages.Kazakh);
						} else {
							System.out.println("| Invalid input, try again | ");
						}
					} catch (Exception e) {
						System.out.println("| Error occurred while changing language. |");
					}
				}

				case 2 -> {
					try {
						String bait = inputstr.getStringInput("");
						String contents = inputstr.getStringInput("Enter request contents: ");
						Request req = new Request(contents);
						appeals.addToRequestList(req);
						System.out.println("| Request sent successfully. |");
					} catch (Exception e) {
						System.out.println("| Error occurred while sending the request. |");
					}
				}

				case 3 -> {
					try {
						news.getNews();
					} catch (Exception e) {
						System.out.println("| Error occurred while fetching news. |");
					}
				}

				case 4 -> {
					try {
						journal.viewJournal();
					} catch (Exception e) {
						System.out.println("| Error occurred while viewing journal. |");
					}
				}

				case 5 -> {
					try {
						String bait = inputstr.getStringInput("");
						String currentPassword = inputstr.getStringInput("Enter your current password: ");
						String newPassword = inputstr.getStringInput("Enter your new password: ");
						setPassword(currentPassword, newPassword);
					} catch (Exception e) {
						System.out.println("| Error occurred while changing password. |");
					}
				}

				case 6 -> {
					try {
						viewCourseList();
					} catch (Exception e) {
						System.out.println("| Error occurred while viewing course list. |");
					}
				}

				case 7 -> {
					try {
						String bait = inputstr.getStringInput("");
						System.out.println("List of Available Courses: \n");
						viewCourseList();
						String courseIdReg = inputstr.getStringInput("Enter the course's ID you want to register: ");
						boolean courseFound = courseslist.stream().anyMatch(c -> c.getCourseId().equals(courseIdReg));

						if (courseFound) {
							registrationForCourses(courseIdReg);
							System.out.println("Registration Successful.");
						} else {
							System.out.println("Course not found. Please check the course ID and try again.");
						}
					} catch (Exception e) {
						System.out.println("| Error occurred while registering for the course. |");
					}
				}

				case 8 -> {
					try {
						String bait = inputstr.getStringInput("");
						String subject = inputstr.getStringInput("Enter the subject for which you want to see the journal: ");
						displayJournal(subject);
					} catch (Exception e) {
						System.out.println("| Error occurred while displaying the journal. |");
					}
				}

				case 9 -> {
					try {
						viewMarks();
					} catch (Exception e) {
						System.out.println("| Error occurred while viewing marks. |");
					}
				}

				case 10 -> {
					try {
						System.out.println("Degree Details: " + getDegreeDetails());
					} catch (Exception e) {
						System.out.println("| Error occurred while fetching degree details. |");
					}
				}

				case 11 -> {
					try {
						getDiplomaProjectsList();
					} catch (Exception e) {
						System.out.println("| Error occurred while fetching diploma projects list. |");
					}
				}
				

			}
		}
	}

}

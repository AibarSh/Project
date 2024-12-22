package Users;

import Platform.*;
import ResearchWork.*;
import Main.*;
import ResearchWork.ResearcherDecorator;

import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class GraduateStudent extends Student {

	private User researchSupervisor;
	private String degree;
	private ResearcherType researcherType;
	private Vector<ResearchProject> diplomaProjects;
	ResearcherDecorator researcherDecorator;
	Vector<ResearchProject> researchProjects;

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
		return super.showCommands() + "| 10 - Get Degree Details | 11 -  Get Diploma Projects List | " +
				"12 - Print papers | 13 - Get Hindex | 14 - Create new Project | 15 - Leave the Project | ";
	}

	@Override
	public void console(News news, Journal journal, Appeals appeals, UserDatabase database) {
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
					break;
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
					break;
				}

				case 3 -> {
					try {
						news.getNews();
					} catch (Exception e) {
						System.out.println("| Error occurred while fetching news. |");
					}
					break;
				}

				case 4 -> {
					try {
						journal.viewJournal();
					} catch (Exception e) {
						System.out.println("| Error occurred while viewing journal. |");
					}
					break;
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
					break;
				}

				case 6 -> {
					try {
						viewCourseList();
					} catch (Exception e) {
						System.out.println("| Error occurred while viewing course list. |");
					}
					break;
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
					break;
				}

				case 8 -> {
					try {
						String bait = inputstr.getStringInput("");
						String subject = inputstr.getStringInput("Enter the subject for which you want to see the journal: ");
						displayJournal(subject);
					} catch (Exception e) {
						System.out.println("| Error occurred while displaying the journal. |");
					}
					break;
				}

				case 9 -> {
					try {
						viewMarks();
					} catch (Exception e) {
						System.out.println("| Error occurred while viewing marks. |");
					}
					break;
				}

				case 10 -> {
					try {
						System.out.println("Degree Details: " + getDegreeDetails());
					} catch (Exception e) {
						System.out.println("| Error occurred while fetching degree details. |");
					}
					break;
				}

				case 11 -> {
					try {
						getDiplomaProjectsList();
					} catch (Exception e) {
						System.out.println("| Error occurred while fetching diploma projects list. |");
					}
					break;
				}

				case 12 -> {
					try {
						String bait = inputstr.getStringInput("");
						int inpt = inputint.getIntInput("Order by: 1 - date, 2 - citations, 3 - lenght \n");
						if (inpt == 1) {
							ResearchPaperComparator comp = new CompareByDate();
							researcherDecorator.printPapers(comp);
						} else if (inpt == 2) {
							ResearchPaperComparator comp = new CompareByCitation();
							researcherDecorator.printPapers(comp);
						} else if (inpt == 3) {
							ResearchPaperComparator comp = new CompareByLength();
							researcherDecorator.printPapers(comp);
						} else {
							System.out.println("| Enter right number |");
						}
					} catch (Exception e) {
						System.out.println("\"| Error occurred while fetching research papers list. |\"");


					}
				}

				case 13 -> {
					try {
						String bait = inputstr.getStringInput("");
						researcherDecorator.calculateHIndex();
						System.out.println("| Your HIndex is: " + researcherDecorator.getHIndex());
					}

					catch(Exception e) {
						System.out.println("| Error occured... | \n");
					}
					break;
				}

				case 14 -> {
					try {
						String bait = inputstr.getStringInput("");
						String inpt = inputstr.getStringInput("Name your project: ");
						ResearchProject prj = new ResearchProject(inpt, new Vector<ResearchPaper>(), new Vector<User>());
						diplomaProjects.add(prj);
						System.out.println("Your new project " + inpt + " was created");
					}

					catch(Exception e ) {
						System.out.println("| Error occured... | \n");
					}
					break;
				}

				case 15 -> {
					try {
						String bait = inputstr.getStringInput("");
						System.out.println("List of your projects: ");
						for(ResearchProject pr : diplomaProjects) {
							System.out.println(pr.getName());
						}
						String inpt = inputstr.getStringInput("Enter the name of the project you want to leave: ");
						for(ResearchProject pr : diplomaProjects) {
							if( pr.getName().equals(inpt)) {
								System.out.println("You exited the project " + pr.getName());
								diplomaProjects.remove(pr);
							}
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
}

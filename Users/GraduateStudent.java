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
						   HealthStatuses healthStatus, FamilyStatuses familyStatus, 
						   Faculties faculty, Courses course, Journal journal, Organizations organization,
						   Position position, User researchSupervisor, String degree,
						   ResearcherType researcherType, Vector<ResearchProject> diplomaProjects) {
		super(language, userID, password, name, age, healthStatus, familyStatus,
				faculty, course, journal, organization, position);
		this.researchSupervisor = researchSupervisor;
		this.degree = degree;
		this.researcherType = researcherType;
		this.diplomaProjects = diplomaProjects;
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
		// Implementation to show graduate student-specific commands
		return "List of graduate student commands"; // Placeholder
	}
}

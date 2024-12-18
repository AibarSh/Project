package ResearchWork;
import java.util.Collections;
import java.util.Vector;
import Users.User;


public class ResearcherDecorator extends UserDecorator{
	
	private int researcherID;
	private ResearcherType researcherType;
	private int hIndex; 
	private  Vector<ResearchPaper> researchPapers;
	private  Vector<ResearchProject>researchProjects;
	

	public ResearcherDecorator(User u1, int id, ResearcherType type, int indx, Vector<ResearchPaper> papers, Vector<ResearchProject> projects){
		super(u1);
		this.researcherID = id;
		this.researcherType = type;
		this.hIndex = indx;
		this.researchPapers = papers;
		this.researchProjects = projects;
	}
	
	public void printPapers(ResearchPaperComparator parameter) {
		Collections.sort(researchPapers, parameter);
		System.out.print("Research Papers: ");
		for(ResearchPaper pap : researchPapers) {
			System.out.print(pap + " ");
		}
	}
	
	public int getHIndex() {
		return this.hIndex;	
	}

	public int calculateHIndex() {
		int tempIndex = 0;
		int i  = 1;
		for(ResearchPaper pap : researchPapers) {
			int temp = pap.getCitationNum();
			if (temp >= i) tempIndex++;
			i++;
		}
		this.hIndex = tempIndex;	
		return this.hIndex;
	}

	public void joinProject(ResearchProject pr) {
			this.researchProjects.add(pr);
	}
	
	public String showCommands() {
		return "";	
	}
	
}


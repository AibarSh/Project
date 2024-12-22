package ResearchWork;
import java.util.Collections;

import java.util.Vector;
import Platform.*;
import Users.*;
import Main.*;

public class ResearcherDecorator{
	
	protected static int researcherID = 0;
	private ResearcherType researcherType;
	private int hIndex; 
	private  Vector<ResearchPaper> researchPapers = new Vector<>();
	private  Vector<ResearchProject>researchProjects = new Vector<>();
	

	public ResearcherDecorator(ResearcherType type, Vector<ResearchPaper> papers, Vector<ResearchProject> projects){
		this.researcherID += 1;
		this.researcherType = type;
		this.hIndex = calculateHIndex();
		this.researchPapers = papers;
		this.researchProjects = projects;
	}
	
	public ResearcherDecorator( ResearcherType type){
		this.researcherID += 1;
		this.researcherType = type;
		this.hIndex = calculateHIndex();
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
		if( researchPapers.isEmpty()) {
			return 0;
		}
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
	
	public void leaveProject(ResearchProject pr) {
		this.researchProjects.remove(pr);
	}
	
	public String showCommands() {
		return "| p - Print papers | h - Get HIndex | s - Start project | l - Leave project | ";
	}
	
	public void console(News news, Journal journal, Appeals appeals, UserDatabase database) {
		 InputUtil inputint = new InputUtil();
	     InputUtil inputstr = new InputUtil();
		 boolean running = true;	
			while(running) {
				
				System.out.println(showCommands());
				String input = inputstr.getStringInput("Enter your command: \n");
				
				if(input == "0") {
					running = false;
					System.out.println("=====                     Exiting...                   =====");
					break;
				}
				
				switch(input) {
					case("p"):
							try {
								int inpt = inputint.getIntInput("Order by: 1 - date, 2 - citations, 3 - lenght \n");
								if (inpt == 1) {
									ResearchPaperComparator comp = new CompareByDate();
									printPapers(comp);
								}
								else if (inpt == 2) {
									ResearchPaperComparator comp = new CompareByCitation();
									printPapers(comp);									
								}
								else if (inpt == 3) {
									ResearchPaperComparator comp = new CompareByLength();
									printPapers(comp);
								}
								else {
									System.out.println("| Enter right number |");
								}
							}
							catch(Exception e) {
								System.out.println("| Error occured... | \n");
							}
							break;
					
					case("P"):
						try {
							int inpt = inputint.getIntInput("Order by: 1 - date, 2 - citations, 3 - lenght \n");
							if (inpt == 1) {
								ResearchPaperComparator comp = new CompareByDate();
								printPapers(comp);
							}
							else if (inpt == 2) {
								ResearchPaperComparator comp = new CompareByCitation();
								printPapers(comp);									
							}
							else if (inpt == 3) {
								ResearchPaperComparator comp = new CompareByLength();
								printPapers(comp);
							}
							else {
								System.out.println("| Enter right number |");
							}
						}
						catch(Exception e) {
							System.out.println("| Error occured... | \n");
						}
						break;
							
					case("h"):
						try {
							calculateHIndex();
							System.out.println("| Your HIndex is: " + getHIndex());
						}
							
						catch(Exception e) {
							System.out.println("| Error occured... | \n");
						}
						break;
					
					case("H"):
						try {
							calculateHIndex();
							System.out.println("| Your HIndex is: " + getHIndex());
						}
							
						catch(Exception e) {
							System.out.println("| Error occured... | \n");
						}
						break;
					
					case("s"):
						try {
							String inpt = inputstr.getStringInput("Name your project: ");
							ResearchProject prj = new ResearchProject(inpt, new Vector<ResearchPaper>(), new Vector<User>());
							System.out.println("Your new project " + inpt + " was created");
						}
						
						catch(Exception e ) {
							System.out.println("| Error occured... | \n");
						}
						break;
						
					case("S"):
						try {
							String inpt = inputstr.getStringInput("Name your project: ");
							ResearchProject prj = new ResearchProject(inpt, new Vector<ResearchPaper>(), new Vector<User>());
							System.out.println("Your new project " + inpt + " was created");
						}
						
						catch(Exception e ) {
							System.out.println("| Error occured... | \n");
						}
						break;
						
						
					case("l"):
						try {
							System.out.println("List of your projects: ");
							for(ResearchProject pr : researchProjects) {
								System.out.println(pr.getName());
							}
							String inpt = inputstr.getStringInput("Enter the name of the project you want to leave: ");
							for(ResearchProject pr : researchProjects) {
								if( pr.getName().equals(inpt)) {
									System.out.println("You exited the project " + pr.getName());
									leaveProject(pr);
								}
							}
							
						}
						catch(Exception e) {
							System.out.println("| Error occured... | \n");
						}
						break;
						
					case("L"):
						try {
							System.out.println("List of your projects: ");
							for(ResearchProject pr : researchProjects) {
								System.out.println(pr.getName());
							}
							String inpt = inputstr.getStringInput("Enter the name of the project you want to leave: ");
							for(ResearchProject pr : researchProjects) {
								if( pr.getName().equals(inpt)) {
									System.out.println("You exited the project " + pr.getName());
									leaveProject(pr);
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


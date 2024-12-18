package ResearchWork ;
import java.util.Vector;
import java.util.Comparator;

public class Journal implements UseResearchPapers{

	private String journalName;
	private Vector<ResearchPaper> publishedPapers;


	public Journal(String jN){
		this.journalName = jN;
		
	}

	public void addPaper(ResearchPaper parameter) {
		this.publishedPapers.add(parameter);
		publishedPapers.sort(Comparator.comparingInt(ResearchPaper::getID));
	}

	public void removePaper(ResearchPaper parameter) {
		this.publishedPapers.remove(parameter);
	}
	
	public void viewJournal() {
		System.out.println("Papers: ");
		for(ResearchPaper p : publishedPapers) {
			System.out.println(" | Authors: " + p.getAuthors() + " | Title: " + p.getTitle() + " | ");
				
			
		}
	}
	
}


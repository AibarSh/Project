package ResearchWork ;
import java.util.Vector;
import Users.User;

public class ResearchProject implements UseResearchPapers{

	protected static int projectID = 0;
	private String topic;
	private Vector<ResearchPaper>publishedPapers;	
	public Vector<User> participants;

	public ResearchProject( String topic, Vector<ResearchPaper> pp, Vector<User> part){
		this.projectID += 1;
		this.topic = topic;
		this.publishedPapers = pp;
		this.participants = part;
	}
	
	public void addParticipant(User parameter) {
		this.participants.add(parameter);
	}

	public void removeParticipant(User parameter) {
		this.participants.remove(parameter);
	}
	
	public String getName() {
		return this.topic;
	}

	public Vector<String> getPapers() {
		Vector<String> papers = new Vector<>();
		for(ResearchPaper p : publishedPapers) {
			papers.add(p.getTitle());
		}
		return papers;
	}

	public Vector<User> getParticipants() {
		return this.participants;
	}


	@Override
	public void addPaper(ResearchPaper parameter) {
		this.publishedPapers.add(parameter);
		
	}

	@Override
	public void removePaper(ResearchPaper parameter) {
		this.publishedPapers.remove(parameter);
		
	}
	
}


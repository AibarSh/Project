package ResearchWork ;
import java.util.Vector;
import Users.User;

public class ResearchProject implements UseResearchPapers{

	private int projectID;
	private String topic;
	private Vector<ResearchPaper>publishedPapers;	
	public Vector<User> participants;

	public ResearchProject(int id, String topic, Vector<ResearchPaper> pp, Vector<User> part){
		this.projectID = id;
		this.topic = topic;
		this.publishedPapers = pp;
		this.participants = part;
	}
	
	public void addParticipant(User parameter) {
		
	}

	public void removeParticipant(User parameter) {
		this.participants.remove(parameter);
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


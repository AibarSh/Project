package ResearchWork ;
import java.util.Vector;
import Users.User;
import java.util.Date;


public class ResearchPaper{

	private int paperID;
	private String title;
	private  Vector<String> authors;
	private int numberOfPages;
	private Date publicationDate;
	public Journal journal;
	public int citationNumber;

	public ResearchPaper(int id, String t, Vector<String> a, int nump, Date p, Journal j, int citnum){
		this.paperID = id;
		this.title = t;
		this.authors = a;
		this.numberOfPages = nump;
		this.publicationDate = p;
		this.journal = j;
		this.citationNumber = citnum;
	}

	public void getCitation(Format f) {
		System.out.println("Citation: " + citationNumber);
	}
	
	public int getLength() {
		return this.numberOfPages;
	}
	
	public int getCitationNum() {
		return this.citationNumber;
	}
	
	public Date getDate() {
		return this.publicationDate;
	}
	
	public int getID() {
		return this.paperID;
	}
	
	public String getTitle() {
		return this.title;
	}

	public void addAuthors(User u1) {
		this.authors.add(u1.getName());
	}
	
	public void removeAuthors(User u1) {
		this.authors.remove(u1.getName());
	}
	
	public Vector<String> getAuthors() {
		return this.authors;
		
	}
	
}


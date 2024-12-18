package ResearchWork ;


public class CompareByCitation extends ResearchPaperComparator{


	public int compare(ResearchPaper o1, ResearchPaper o2) {
		return Integer.compare(o2.getCitationNum(), o1.getCitationNum());
	}
	
}


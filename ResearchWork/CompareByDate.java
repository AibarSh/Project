package ResearchWork ;


public class CompareByDate extends ResearchPaperComparator{

	public int compare(ResearchPaper o1, ResearchPaper o2) {
		return o1.getDate().compareTo(o2.getDate());
	}
	
}


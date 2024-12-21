package Platform;
import java.util.*;
public class News {
	private Vector<Integer> newsID = new Vector<>();
	private Vector<String> news = new Vector<>();
	protected static int idCounter = 0;
	public News(int n, String s) {
		this.newsID.add(n);
		this.news.add(s);
	}

	public Vector<Integer> getNewsID() {
		return newsID;
	}

	public void setNewsID(int n, int n1) {
		this.newsID.set(n, n1);
	}

	public void getNews() {
		for(int i=0; i<newsID.size(); i++) {
			System.out.println(news.get(i));
		}
	}

	public void setNews(int n,String s) {
		this.news.set(n,s);
	}

	@Override
	public String toString() {
		return "News{" +
				"newsID=" + newsID +
				", news='" + news + '\'' +
				'}';
	}
}

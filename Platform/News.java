package Platform;

public class News {
	private int newsID;
	private String news;

	public News(int n, String s) {
		this.newsID = n;
		this.news = s;
	}

	public int getNewsID() {
		return newsID;
	}

	public void setNewsID(int newsID) {
		this.newsID = newsID;
	}

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	@Override
	public String toString() {
		return "News{" +
				"newsID=" + newsID +
				", news='" + news + '\'' +
				'}';
	}
}


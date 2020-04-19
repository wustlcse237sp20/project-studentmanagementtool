import javax.swing.DefaultListModel;

public class StudentToolController {
	private NewsFeed feed1 = getNewsFeed("https://feeds.npr.org/1001/rss.xml");
	private NewsFeed feed2 = getNewsFeed("http://feeds.bbci.co.uk/news/world/us_and_canada/rss.xml?edition=int");

	public NewsFeed getNewsFeed(String url) {
		RSSNewsFeedParser parser = new RSSNewsFeedParser(url);
		NewsFeed feed = parser.readFeed();
		return feed;
	}
	
	public DefaultListModel<String> getHeadlinesTestingMethod(NewsFeed feed) {
//		System.out.println(feed);
		DefaultListModel<String> headlines = new DefaultListModel<String>();
		for (NewsItem item : feed.getItems()) {
			headlines.addElement(item.title);
			
		}
		return headlines;
	}
	
	public DefaultListModel<String> getHeadlinesFeed1() {
		DefaultListModel<String> headlines = new DefaultListModel<String>();
		for (NewsItem item : feed1.getItems()) {
			headlines.addElement(item.title);

		}
		return headlines;
	}
	
	public DefaultListModel<String> getHeadlinesFeed2() {
		DefaultListModel<String> headlines = new DefaultListModel<String>();
		for (NewsItem item : feed2.getItems()) {
			headlines.addElement(item.title);

		}
		return headlines;
	}

	public String getItemUrl(String title) {
		String itemUrl = "";
		for (NewsItem item : feed1.getItems()) {
			if (item.getTitle() == title) {
				itemUrl = item.getLink();
			}
		}
		for (NewsItem item : feed2.getItems()) {
			if (item.getTitle() == title) {
					itemUrl = item.getLink();
			}	
		}
		return itemUrl;
	}
}

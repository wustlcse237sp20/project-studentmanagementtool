import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;

public class ParserTest {

	//Create a feed from known, non-changing XML file
	final String feedName = "FeedForAll Sample Feed";
	final String feedDescription = "FeedForAll Sample Feed";
	final String feedLink = "http://www.feedforall.com/industry-solutions.htm";
	
	final String feedItem1Name = "RSS Resources";
	final String feedItem1Description = "Be sure to take a look at some of our favorite RSS Resources<br> <a href=\"http://www.rss-specifications."
			+ "com\">RSS Specifications</a><br> <a href=\"http://www.blog-connection.com\">Blog Connection</a><br> <br>";

	final String feedItem1Link = "http://www.feedforall.com";
	
	final String feedItem2Name = "Recommended Desktop Feed Reader Software";
	final String feedItem2Description = "<b>FeedDemon</b> enables you to quickly read and gather information from hundreds of web sites - "
			+ "without having to visit them. Don't waste any more time checking your favorite web sites for updates. Instead, use FeedDemon "
			+ "and make them come to you. <br> More <a href=\"http://store.esellerate.net/a.asp?c=1_SKU5139890208_AFL403073819\">FeedDemon Information</a>";
	final String feedItem2Link = "http://www.feedforall.com/feedforall-partners.htm";
	
	final String feedItem3Name = "Recommended Web Based Feed Reader Software";
	final String feedItem3Description = "<b>FeedScout</b> enables you to view RSS/ATOM/RDF feeds from different sites directly in Internet Explorer."
			+ " You can even set your Home Page to show favorite feeds. Feed Scout is a plug-in for Internet Explorer, so you won't have to learn anything "
			+ "except for how to press 2 new buttons on Internet Explorer toolbar. <br> More <a href=\"http://www.bytescout.com/feedscout.html\">Information"
			+ " on FeedScout</a><br> <br> <br> <b>SurfPack</b> can feature search tools, horoscopes, current weather conditions, LiveJournal diaries, humor,"
			+ " web modules and other dynamically updated content. <br> More <a href=\"http://www.surfpack.com/\">Information on SurfPack</a><br>";
	final String feedItem3Link = "http://www.feedforall.com/feedforall-partners.htm";
	
	RSSNewsFeedParser parser = new RSSNewsFeedParser("https://www.feedforall.com/sample-feed.xml");
	NewsFeed testFeed = parser.readFeed();	
    
	@Test
	public void failIfWrongFeedName() {
		String parsedFeedName = testFeed.getTitle();
		assertEquals(parsedFeedName, feedName);
	}
	
	@Test
	public void failIfWrongFeedDescription() {
		String parsedFeedDescription = testFeed.getDescription();
		assertEquals(parsedFeedDescription, feedDescription);
	}
	
	@Test
	public void failIfWrongFeedLink() {
		String parsedFeedLink = testFeed.getLink();
		assertEquals(parsedFeedLink, feedLink);
	}
	
	@Test
	public void failIfWrongFeedItem1Name() {
		String parsedFeedName = testFeed.getItemByIndex(0).getTitle();
		assertEquals(parsedFeedName, feedItem1Name);
	}
	
	@Test
	public void failIfWrongFeedItem1Description() {
		String parsedFeedDescription = testFeed.getItemByIndex(0).getDescription();
		assertEquals(parsedFeedDescription, feedItem1Description);
	}
	
	@Test
	public void failIfWrongFeedFeedItem1Link() {
		String parsedFeedLink = testFeed.getItemByIndex(0).getLink();
		assertEquals(parsedFeedLink, feedItem1Link);
	}
	
	@Test
	public void failIfWrongFeedItem2Name() {
		String parsedFeedName = testFeed.getItemByIndex(1).getTitle();
		assertEquals(parsedFeedName, feedItem2Name);
	}
	
	@Test
	public void failIfWrongFeedItem2Description() {
		String parsedFeedDescription = testFeed.getItemByIndex(1).getDescription();
		assertEquals(parsedFeedDescription, feedItem2Description);
	}
	
	@Test
	public void failIfWrongFeedFeedItem2Link() {
		String parsedFeedLink = testFeed.getItemByIndex(1).getLink();
		assertEquals(parsedFeedLink, feedItem2Link);
	}
	
	@Test
	public void failIfWrongFeedItem3Name() {
		String parsedFeedName = testFeed.getItemByIndex(2).getTitle();
		assertEquals(parsedFeedName, feedItem3Name);
	}
	
	@Test
	public void failIfWrongFeedItem3Description() {
		String parsedFeedDescription = testFeed.getItemByIndex(2).getDescription();
		assertEquals(parsedFeedDescription, feedItem3Description);
	}
	
	@Test
	public void failIfWrongFeedFeedItem3Link() {
		String parsedFeedLink = testFeed.getItemByIndex(2).getLink();
		assertEquals(parsedFeedLink, feedItem3Link);
	}

}

import static org.junit.Assert.*;

import javax.swing.DefaultListModel;

import org.junit.Test;

public class StudentToolControllerTest {
	StudentToolController testController = new StudentToolController();
	NewsFeed sampleFeed = new NewsFeed("sampleTitle", "sampleLink", "sampleDescription");
	NewsItem sampleItem1 = new NewsItem();

	//note we are testing on the getHeadlinesTestingMethod since the feed variable is dynamic since it pulls from an rss feed link that is constantly changing.
	@Test
	public void testGetHeadlines() {
		sampleItem1.setTitle("sampleTitle1");
		sampleItem1.setDescription("sampleDescription1");
		sampleItem1.setLink("sampleLink1");
		sampleFeed.getMessages().add(sampleItem1);

		DefaultListModel<String> testHeadlines = testController.getHeadlinesTestingMethod(sampleFeed);

		DefaultListModel<String> sampleHeadlines = new DefaultListModel<String>();
		
		for (NewsItem item : sampleFeed.getMessages()) {
			sampleHeadlines.addElement(item.title);
			
		}
		assertEquals(sampleHeadlines.get(0),testHeadlines.get(0));
	}
	
	@Test
	public void testGetItemUrl() {
		
	}

}


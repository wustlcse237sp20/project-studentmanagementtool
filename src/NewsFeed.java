
import java.util.ArrayList;
import java.util.List;

/*
 * Stores an RSS feed
 */
public class NewsFeed {

    final String title;
    final String link;
    final String description;


    final List<NewsItem> entries = new ArrayList<NewsItem>();

    public NewsFeed(String title, String link, String description) {
        this.title = title;
        this.link = link;
        this.description = description;
    }

    public List<NewsItem> getItems() {
        return entries;
    }
    
    public NewsItem getItemByIndex(int index) {
        return entries.get(index);
    }
    
    public int getFeedSize() {
        return entries.size();
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
    	return "NewsFeed [" + title + ", " + description
                + ", " + link + "]";
    }

}
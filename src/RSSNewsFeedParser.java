
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

public class RSSNewsFeedParser {
	static final String TITLE = "title";
	static final String DESCRIPTION = "description";
	static final String CHANNEL = "channel";
	static final String LINK = "link";
	static final String AUTHOR = "author";
	static final String ITEM = "item";

	final URL url;

	public RSSNewsFeedParser(String feedUrl) {
		try {
			this.url = new URL(feedUrl);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	public NewsFeed readFeed() {
		NewsFeed feed = null;
		try {
			XMLEventReader eventReader = setupXMLReader();
			feed = parseXML(feed, eventReader);
		} catch (XMLStreamException e) {
			throw new RuntimeException(e);
		}
		return feed;
	}

	private XMLEventReader setupXMLReader() throws FactoryConfigurationError, XMLStreamException {
		// First create a new XMLInputFactory
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		// Setup a new eventReader
		InputStream inputStream = readInputStream();
		XMLEventReader eventReader = inputFactory.createXMLEventReader(inputStream);
		return eventReader;
	}
	
	private InputStream readInputStream() {
		try {
			return url.openStream();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private NewsFeed parseXML(NewsFeed feed, XMLEventReader eventReader) throws XMLStreamException {
		// Set header values initially to the empty string
		String description = "";
		String title = "";
		String link = "";
		// read the XML document
		boolean isFeedHeader = true;
		while (eventReader.hasNext()) {
			XMLEvent event = eventReader.nextEvent();
			if (event.isStartElement()) {
				String localPart = event.asStartElement().getName().getLocalPart();
				switch (localPart) {
				case ITEM:
					if (isFeedHeader) {
						isFeedHeader = false;
						feed = new NewsFeed(title, link, description);	
					}
					event = eventReader.nextEvent();
					break;
				case TITLE:
					title = getCharacterData(event, eventReader);
//					System.out.println(title);
					break;
				case DESCRIPTION:
					description = getCharacterData(event, eventReader);
					break;
				case LINK:
					link = getCharacterData(event, eventReader);
					break;
				}
			} else if (event.isEndElement()) {
				if (event.asEndElement().getName().getLocalPart() == (ITEM)) {
					NewsItem message = new NewsItem();
					message.setTitle(title);
					message.setDescription(description);
					message.setLink(link);
					feed.getItem().add(message);
					event = eventReader.nextEvent();
					continue;
				}
			}
		}
		return feed;
	}

	private String getCharacterData(XMLEvent event, XMLEventReader eventReader) throws XMLStreamException {
		String result = "";
		event = eventReader.nextEvent();
		if (event instanceof Characters) {
			result = event.asCharacters().getData();
		}
		return result;
	}

}
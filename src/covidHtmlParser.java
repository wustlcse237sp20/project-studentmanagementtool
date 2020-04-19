

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class covidHtmlParser {
	
	private static String totalCases;
	private static String newCases;
	private static String totalDeaths;
	private static String newDeaths;
	private static String recovered;
	
	public static void main(String args[]){
		Document document;

		try {
			
			document = Jsoup.connect("https://www.worldometers.info/coronavirus/country/us/").get();
			getData(document);
			print( "Total Cases " + totalCases);
			print( "New Cases " + newCases);
			print( "Total Deaths " + totalDeaths);
			print( "New Deaths " + newDeaths);
			print( "Recovered " + recovered);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void getData(Document document) {
		
		Elements mainStats = document.select(".maincounter-number"); //Get core stats
		Elements fullStats = document.select("tbody > tr > td"); // get full stats
		getTotalCases(mainStats);
		getNewCases(fullStats);
		getTotalDeaths(mainStats);
		getNewDeaths(fullStats);
		getRecovered(mainStats);
	}

	private static void getRecovered(Elements mainStats) {
		recovered = mainStats.get(2).text();
	}

	private static void getNewDeaths(Elements fullStats) {
		newDeaths = fullStats.get(4).text();
	}

	private static void getTotalDeaths(Elements mainStats) {
		totalDeaths = mainStats.get(1).text();
	}

	private static void getNewCases(Elements fullStats) {
		newCases = fullStats.get(2).text();
	}

	private static void getTotalCases(Elements mainStats) {
		totalCases = mainStats.get(0).text();
	}

	public static void print(String string) {
		System.out.println(string);
	}

}
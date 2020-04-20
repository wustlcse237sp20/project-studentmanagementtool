

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class CovidHtmlParser {
	
	private static String totalCases;
	private static String newCases;
	private static String totalDeaths;
	private static String newDeaths;
	private static String recovered;
	private static CovidStats usStats;

	
	public static void main(String args[]){
		
		CovidStats usStats = new CovidStats();

			print( "Total Cases " + totalCases);
			print( "New Cases " + newCases);
			print( "Total Deaths " + totalDeaths);
			print( "New Deaths " + newDeaths);
			print( "Recovered " + recovered);

		
	}

	public CovidStats getData() {	
		Document document = null;
		try {
			document = Jsoup.connect("https://www.worldometers.info/coronavirus/country/us/").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Elements mainStats = document.select(".maincounter-number"); //Get core stats
		Elements fullStats = document.select("tbody > tr > td"); // get full stats
		

		
		usStats = new CovidStats();
		
		usStats.setTotalCases(getTotalCases(mainStats));
		usStats.setNewCases(getNewCases(fullStats));
		usStats.setNewDeaths(getNewDeaths(fullStats));
		usStats.setRecovered(getRecovered(mainStats));
		usStats.setTotalDeaths(getTotalDeaths(mainStats));
		return usStats;
		
		
	}

	private static String getRecovered(Elements mainStats) {
		recovered = mainStats.get(2).text();
		return recovered;
	}

	private static String getNewDeaths(Elements fullStats) {
		newDeaths = fullStats.get(4).text();
		return newDeaths;
	}

	private static String getTotalDeaths(Elements mainStats) {
		totalDeaths = mainStats.get(1).text();
		return totalDeaths;
	}

	private static String getNewCases(Elements fullStats) {
		newCases = fullStats.get(2).text();
		return newCases;
	}

	private static String getTotalCases(Elements mainStats) {
		totalCases = mainStats.get(0).text();
		return totalCases;
	}

	public static void print(String string) {
		System.out.println(string);
	}

}
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CovidStats {

	String totalCases;
	String newCases;
	String totalDeaths;
	String newDeaths;
	String recovered;
	


//	public CovidStats() {
////		String totalInfected, String newInfected, String totalDead, String newDead, String recoveries
//		this.totalCases = totalInfected;
//		this.newCases = newInfected;
//		this.totalDeaths = totalDead;
//		this.newDeaths = newDead;
//		this.recovered = recoveries;
//
//	}

	public static void main(String[] args) throws IOException {


		
//		System.out.println(covidData.getRecovered());
	}

	public String getTotalCases() {
		return this.totalCases;
	}

	public void setTotalCases(String totalCases) {
		this.totalCases = totalCases;
	}

	public String getNewCases() {
		return this.newCases;
	}

	public void setNewCases(String newCases) {
		this.newCases = newCases;
	}

	public String getTotalDeaths() {
		return this.totalDeaths;
	}

	public void setTotalDeaths(String totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	public String getNewDeaths() {
		return this.newDeaths;
	}

	public void setNewDeaths(String newDeaths) {
		this.newDeaths = newDeaths;
	}

	public String getRecovered() {
		return this.recovered;
	}

	public void setRecovered(String recovered) {
		this.recovered = recovered;
	}
}

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Weather {
	public String temperature;
	public String location;
	public String condition;
	private ArrayList<String> l;
	private ArrayList<String> t;
	private ArrayList<String> condList;
	
	/**
	 * Uses Jsoup and scrapes the Location, Temperature and Condition from www.accuweather.com.
	 * Location and Temperature are scraped from the little panel towards the top of the website
	 * just above the menu. 
	 * 
	 * Uses a 'for' block to get the current conditions because it is scraped from the weather panel next to the map
	 * and the selection returns 3 conditions. So I add them to a list, and get the first entry because it is always the conditions for your 
	 * current city. 
	 * 
	 */
	
	public void getWeather() throws IOException {

		Document doc = Jsoup.connect("http://www.accuweather.com/").get();
		//t = new ArrayList<String>();
		//l = new ArrayList<String>();
		condList = new ArrayList<String>(); //ArrayList used to store the conditions
		location = doc.select("span.current-city").text(); //declares location
		temperature = doc.select("span.local-temp").text(); //declares temperature
		
		/*
		for (Element weather : doc.select("a.tab")) {
			String tempLocation = weather.select(".current-city").text();
			String tempTemperature = weather.select(".local-temp").text();
			t.add(tempTemperature);
			l.add(tempLocation);			
		} 
		*/
		
		//location = l.get(1);
		//temperature = t.get(1);
		
		/*
		 * Loops through all the conditions under div.cond on the website and adds them to condList
		 */
		for (Element condition : doc.select("div.cond")) { 
			String tempCondition = condition.select("div.cond").text();
			condList.add(tempCondition);			
		}
		condition = condList.get(0);
	}
}

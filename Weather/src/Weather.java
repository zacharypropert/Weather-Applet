import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/*
 * Uses Jsoup to scrape the temperature and your current location from accuweather.com
 * 
 * Had to use ArrayLists to store the data because the for loop receives multiple null values
 * for the temperature and location. The ArrayList takes all the values and the second value of each ArrayList
 * is always the desired value.
 */

public class Weather {
	public String temperature;
	public String location;
	public String condition;
	private ArrayList<String> l;
	private ArrayList<String> t;
	private ArrayList<String> c;
	
	public void getWeather() throws IOException {

		Document doc = Jsoup.connect("http://www.accuweather.com/").get();
		t = new ArrayList<String>();
		l = new ArrayList<String>();
		c = new ArrayList<String>();
		for (Element weather : doc.select("a.tab")) {
			String tempLocation = weather.select(".current-city").text();
			String tempTemperature = weather.select(".local-temp").text();
			t.add(tempTemperature);
			l.add(tempLocation);			
		}
		for (Element condition : doc.select("li.bg-s")) {
			String tempCondition = condition.select(".cond").text();
			c.add(tempCondition);			
		}
		location = l.get(1);
		temperature = t.get(1);
		try {
		condition = c.get(0);
		}
		catch (IndexOutOfBoundsException e){
			condition = " ";
		}
	}
}

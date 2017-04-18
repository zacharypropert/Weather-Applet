import java.io.IOException;

/**
 * 
 * @author Zach Propert
 * 
 * Runs the weather app.
 *
 */
public class Run {
	public Weather w;
	public GUI gui;
	
	public static void main(String[] args) throws IOException{
		Weather w = new Weather();
		GUI gui = new GUI();
		
		w.getWeather();
		gui.build(w.location,w.temperature,w.condition);
	}
}

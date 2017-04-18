import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class GUI {

	private static JFrame frame;
    private static Container contentPane;
    private Dimension window;
    private JPanel weather;
    private JPanel content;
    private JLabel locLabel;
    private JLabel tempLabel;
    private JLabel condLabel;

   /*
    * Builds the GUI with values passed through from Run.java
    */
   public void build(String loc, String temp, String cond){
		window = new Dimension(); 
		
		if(loc.length() >= cond.length()){
			window.setSize(loc.length()*10, 90);
		}else{
			window.setSize(cond.length()*10, 90);
		}
		
		Font calibri = new Font("Calibri", Font.PLAIN, 20);
		frame = new JFrame("Weather");
		frame.setResizable(false);
		BufferedImage img = null;
        try {
            img = ImageIO.read(new File("weather icon.png"));
        } catch (IOException e) {
        }
      
        frame.setIconImage(img);
		
		contentPane = frame.getContentPane();
		
		content = new JPanel();
		content.setPreferredSize(window);
		content.setBackground(Color.WHITE);
		weather = new JPanel(new GridLayout(3,1));	
		
		locLabel = new JLabel(loc, JLabel.CENTER);
		locLabel.setFont(calibri);
		tempLabel = new JLabel(temp, JLabel.CENTER);
		tempLabel.setFont(calibri);
		condLabel = new JLabel(cond, JLabel.CENTER);
		condLabel.setFont(calibri);
		
		weather.add(locLabel);
		weather.add(tempLabel);
		weather.add(condLabel);
		weather.setBackground(Color.WHITE);
		
		content.add(weather);
		contentPane.add(content);
		
		screenCenter(window);
		frame.pack();
		frame.setVisible(true);
	}
	
	/*
	 * Aligns the graphics to the center of the screen.
	 * 
	 */
	public static void screenCenter(Dimension window){
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((d.getWidth()-window.getWidth())/2);
		int y = (int) ((d.getHeight()-window.getHeight())/2);
		frame.setLocation(x,y);
	}
}

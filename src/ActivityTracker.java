import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class ActivityTracker {
	
	public static int numberOfActivities = 0;
	static ArrayList<String> activities = new ArrayList<String>();
	static JFrame frame;
	static JPanel panel;
	static JLabel finalGPA;
	
	public static void main(String [ ] args) {
		
		numberOfActivities = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of activities you want to complete today: "));
		
		trackActivities(numberOfActivities);
	}
	
	public static ArrayList<String> trackActivities(double numberOfActivities) {
		activities.clear();
		
		for(int i = 0; i < numberOfActivities; i++) {
			String newActivity = JOptionPane.showInputDialog(null, "Enter activity " + (i + 1) + " for the day: ");
			
			activities.add(newActivity);
		}
		
		return activities;
	}
}

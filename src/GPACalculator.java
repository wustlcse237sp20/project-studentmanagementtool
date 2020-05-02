import java.awt.*;
import javax.swing.*;

public class GPACalculator extends JPanel {
		
	public static double numOfCourses = 0.0;
	public static String courseGrade = "";
	public static double courseCredits = 0.0;
	public static double totalCredits = 0.0;
	public static double rawTotalPoints = 0;
	static JFrame frame;
	static JPanel panel;
	static JLabel finalGPA;
	
	
	public static void main(String [ ] args) {
		
		int courses = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of courses you are taking this semester: "));

		calculateGPA(courses);
	}
	
	public static double calculateGPA(double courses) {

		for(int i = 0; i < courses; i++) {
			String courseGrade = JOptionPane.showInputDialog(null, "Enter the letter grade you recieved for course " + (i + 1) + ": ");

			int courseCredits = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of credits you recieved for course " + (i + 1) + ": "));

			totalCredits += courseCredits;
			
			//Info taken from WashU GPA calculations
			if(courseGrade.equals("A") || courseGrade.equals("a") || courseGrade.equals("A+") || courseGrade.equals("a+")) {
				rawTotalPoints += (4.0 * courseCredits);
			}
			else if(courseGrade.equals("A-") || courseGrade.equals("a-")) {
				rawTotalPoints += (3.7 * courseCredits);
			}
			else if(courseGrade.equals("B+") || courseGrade.equals("b+")) {
				rawTotalPoints += (3.3 * courseCredits);
			}
			else if(courseGrade.equals("B") || courseGrade.equals("b")) {
				rawTotalPoints += (3.0 * courseCredits);
			}
			else if(courseGrade.equals("B-") || courseGrade.equals("b-")) {
				rawTotalPoints += (2.7 * courseCredits);
			}
			else if(courseGrade.equals("C+") || courseGrade.equals("c+")) {
				rawTotalPoints += (2.3 * courseCredits);
			}
			else if(courseGrade.equals("C") || courseGrade.equals("c")) {
				rawTotalPoints += (2.0 * courseCredits);
			}
			else if(courseGrade.equals("C-") || courseGrade.equals("c-")) {
				rawTotalPoints += (1.7 * courseCredits);
			}
			else if(courseGrade.equals("D+") || courseGrade.equals("d+")) {
				rawTotalPoints += (1.3 * courseCredits);
			}
			else if(courseGrade.equals("D") || courseGrade.equals("d")) {
				rawTotalPoints += (1.0 * courseCredits);
			}
			else if(courseGrade.equals("D-") || courseGrade.equals("d-")) {
				rawTotalPoints += (0.7 * courseCredits);
			}
			else if(courseGrade.equals("F") || courseGrade.equals("f")) {
				rawTotalPoints += (0.0 * courseCredits);
			}
			else {
				System.out.println("Invalid grade. Please put the letter grade for your course in the format 'A+ or a+'");
				break;
			}
		}
		
		//User GPA is the number of raw total GPA points divided by the number of credits they took
//		frame = new JFrame("GPA Calculator");
//		panel = new JPanel();
//		finalGPA = new JLabel("Your GPA for the semester is: " + rawTotalPoints / totalCredits);
		
//		frame.getContentPane().add(panel);
//		frame.setSize(300, 100);
//		frame.setVisible(true);
//		frame.setResizable(false);
		//thanks to https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
//		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

//		panel.add(finalGPA);
		frame = new JFrame("GPA Calculator");
		panel = new JPanel();
		finalGPA = new JLabel("Your GPA for the semester is: " + rawTotalPoints / totalCredits);
		
		frame.getContentPane().add(panel);
		frame.setSize(300, 100);
		frame.setVisible(true);
		frame.setResizable(false);
		//thanks to https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

		panel.add(finalGPA);

		return rawTotalPoints / totalCredits;
	}
}
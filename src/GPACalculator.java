import java.util.Scanner;

public class GPACalculator {
	public static void main(String [ ] args) {
		
		double numOfCourses = 0.0;
		String courseGrade = "";
		double courseCredits = 0.0;
		double totalCredits = 0.0;
		double rawTotalPoints = 0;
		
		Scanner console = new Scanner(System.in);
		
		//User inputs the number of courses they are taking in order to begin GPA calculation
		System.out.print("Enter the number of courses you are taking this semester: ");
		
		numOfCourses = console.nextDouble();
		
		//Loop through each course and determine the GPA for that course based on information the user gives
		for(int i = 0; i < numOfCourses; i++) {
			System.out.print("Enter the letter grade you recieved for course " + (i + 1) + ": ");
			courseGrade = console.next();
			System.out.print("Enter the number of credits you recieved for course " + (i + 1) + ": ");
			courseCredits = console.nextDouble();
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
		System.out.println("Your GPA for the semester is: " + rawTotalPoints / totalCredits);
	}
}

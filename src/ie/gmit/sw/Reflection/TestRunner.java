package ie.gmit.sw.Reflection;

/**
 * Created to fully test the application and display the results in the console. 
 * This class was used extensively to ensure everything was working correctly,
 * before continuing on to the GUI part of the this application. 
 * 
 * @author Will Hogan
 * @category Advanced Object oriented Programming
 */
public class TestRunner {

	public static void main(String[] args) throws ClassNotFoundException {
		
		// Create an Instance of the CalculateMetrics class 
		CalculateMetrics cm = new CalculateMetrics();
		
		 /*Call on the below method using the above instance to run the application 
		 * and display all the values in the console [For testing purposes] */
		cm.calculateMetrics();
	}
}
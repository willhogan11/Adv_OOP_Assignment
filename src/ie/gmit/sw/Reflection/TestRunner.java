package ie.gmit.sw.Reflection;


public class TestRunner {

	public static void main(String[] args) throws ClassNotFoundException {
		
		// Create an Instance of the CalculateMetrics class 
		CalculateMetrics cm = new CalculateMetrics();
		
		 /*Call on the below method using the above instance to run the application 
		 * and display all the values in the console [For testing purposes] */
		cm.calculateMetrics();
	}
}
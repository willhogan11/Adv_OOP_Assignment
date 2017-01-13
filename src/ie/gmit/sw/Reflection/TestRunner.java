package ie.gmit.sw.Reflection;


public class TestRunner {

	public static void main(String[] args) throws ClassNotFoundException {
		
		// Create an Instance of the CalculateMetrics class 
		CalculateMetrics cm = new CalculateMetrics();
		
		// Display all values from the Application in the console [For testing purposes]
		cm.calculateMetrics();
	}
}
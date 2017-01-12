package ie.gmit.sw.Reflection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TestRunner {

	public static void main(String[] args) throws ClassNotFoundException {
		
		// Create an Instance of the CalculateMetrics class 
		CalculateMetrics cm = new CalculateMetrics();
		
		cm.calculateMetrics();
		
		
		/*// Create a new HashMap to hold the map values returned from the above class instance
		Map<String, Metric> newMetricMap = new HashMap<String, Metric>();
		
		// Assign values from the returned hashmap to the 'newMetricMap'
		newMetricMap = r.calculateMetrics();
		
		// Display all values in the 'newMetricMap' to confirm that it has been populated
		for ( Entry<String, Metric> entry : newMetricMap.entrySet()) {
		    String key = entry.getKey();
		    Metric value = entry.getValue();
		    System.out.println("Key : " + key 
		    							 + "\nValues(Metrics) : \n\tClass Name : " + value.getClassName()
		    							 + "\n\tInDegree : " + value.getInDegree() 
		    							 + "\n\tOutDegree : " + value.getOutDegree() 
		    							 + "\n\tStability : " + value.getStability() + "\n");
		}*/
	}
}
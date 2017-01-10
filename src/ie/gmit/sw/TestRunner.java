package ie.gmit.sw;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TestRunner {

	public static void main(String[] args) throws ClassNotFoundException {
		
		// Create an Instance of the CalculateMetrics class 
		CalculateMetrics r = new CalculateMetrics();
		
		// Create a new HashMap to hold the map values returned from the above class instance
		Map<String, Metric> newMetricMap = new HashMap<String, Metric>();
		
		// Assign values from the returned hashmap to the 'newMetricMap'
		newMetricMap = r.calculateMetrics();
		
		// Display all values in the 'newMetricMap' to confirm that it has been populated
		for ( Entry<String, Metric> entry : newMetricMap.entrySet()) {
		    String key = entry.getKey();
		    Metric value = entry.getValue();
		    System.out.println("Keys : " + key 
		    							 + "--------------------Class Name : " + value.getClassName()
		    							 + "--------------------InDegree : " + value.getInDegree() 
		    							 + "--------------------OutDegree : " + value.getOutDegree() 
		    							 + "--------------------Stability : " + value.getStability());
		}
	}
}
package ie.gmit.sw;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TestRunner {

	public static void main(String[] args) throws ClassNotFoundException {
		
		CalculateMetrics r = new CalculateMetrics();
		Map<String, Metric> newMetricMap = new HashMap<String, Metric>();
		
		newMetricMap = r.calcCouplings();
		
		System.out.println(newMetricMap.size());
		
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
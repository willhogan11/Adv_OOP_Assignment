package ie.gmit.sw;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TestRunner {

	public static void main(String[] args) {
		
		Map<String, Metric> metricMap = new HashMap<String, Metric>();
		
		Metric metric = new Metric();
		
		metric.setOutDegree(3);
		metric.setInDegree(1);
		
		metricMap.put("ie.gmit.sw.test.class", metric);
		
		for ( Entry<String, Metric> entry : metricMap.entrySet()) {
		    String key = entry.getKey();
		    Metric value = entry.getValue();
		    
		    System.out.println("In Degree of Class: " + value.getInDegree());
		    System.out.println("Out Degree of Class: " + value.getOutDegree());
		    System.out.println("Key : " + key + " >=======>\nStability of Class : " + value.getStability());
		}
	}
}
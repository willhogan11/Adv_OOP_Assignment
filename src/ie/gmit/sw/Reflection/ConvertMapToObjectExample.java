package ie.gmit.sw.Reflection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ConvertMapToObjectExample {

	public static void main(String[] args) {
		
		HashMap<String, Metric> metricMap = new HashMap<String, Metric>();
		Object[][] metricData = new Object[metricMap.size()][2];
		Set<Entry<String, Metric>> entries = metricMap.entrySet();
		Iterator<Entry<String, Metric>> entriesIterator = entries.iterator();
		
		int i = 0;
		
		Metric metric = new Metric();
		Metric metric1 = new Metric();
		
		metric.setClassName("ie.gmit.sw.testClass");
		metric.setInDegree(5);
		metric.setOutDegree(6);
		
		metric.setClassName("ie.gmit.sw.anotherTestClass");
		metric.setInDegree(2);
		metric.setOutDegree(5);
		
		metricMap.put("ie.gmit.sw.testClass", metric);
		metricMap.put("ie.gmit.sw.anotherTestClass", metric1);
		
		
		while(entriesIterator.hasNext()) {
			
			Map.Entry mapping = (Map.Entry) entriesIterator.next();
			
			metricData[i][0] = mapping.getKey();
			metricData[i][1] = mapping.getValue();
			
			System.out.println(mapping.getKey() + " : " + mapping.getValue());
			
			i++;
		}
	}	
}
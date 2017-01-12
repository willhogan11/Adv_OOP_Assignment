package ie.gmit.sw.Reflection;

import java.util.HashMap;
import java.util.Map;


public class ConvertMapToObjectExample {

	public static void main(String[] args) {
		
		// Reference http://stackoverflow.com/questions/2265266/convert-hash-map-to-2d-array
		
		
		Map<String, Metric> metricMap = new HashMap<String, Metric>();
		
		Metric metric = new Metric();
		
		metric.setClassName("ie.gmit.sw.testClass");
		metric.setInDegree(5);
		metric.setOutDegree(6);
		metric.setStability(metric.getStability());
		
		metricMap.put("ie.gmit.sw.testClass", metric);

		
		Object[][] array = new Object[metricMap.size()][5];
		int cols = 4;
		int rows = metricMap.size();
		int count = 0;
		
		
		for(Map.Entry<String, Metric> entry : metricMap.entrySet()){
		    // array[count][0] = entry.getKey();
		    array[count][0] = "Class Name: " + entry.getValue().getClassName();
		    array[count][1] = "In Degree: " + entry.getValue().getInDegree();
		    array[count][2] = "Out Degree: " + entry.getValue().getOutDegree();
		    array[count][3] = "Stability: " + entry.getValue().getStability();
		    count++;
		}
		
		System.out.println("Size of 2d Array is: " + metricMap.size());
		System.out.println();
		
		for (int i = 0; i < rows ; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.println(array[i][j] + " ");
			}
		}
		
		
		
		
		
		
		
		
		
/*		int i = 0;
		
		for (Metric m : metricMap.values()) {
			array[i][0] = m.getClassName();
			array[i][1] = m.getInDegree();
			array[i][2] = m.getOutDegree();
			array[i][3] = m.getStability();
			
			i++;
		}
		
		
		for (int k = 0; k < rows ; k++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(array[k][j] + " ");
			}
			System.out.println();
		}*/
		
		
	}	
}
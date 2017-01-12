package ie.gmit.sw.Reflection;

import java.util.Map;

public class ObjectMapAdapter {
	
	private int rows;
	private int cols;
	private Object[][] array;
	
	
	public Object[][] adapt(Map<String, Metric> metricMap, Metric metric) {
		
		int cols = 4;
		int rows = metricMap.size();
		int count = 0;
		array = new Object[rows][cols];
		
		for(Map.Entry<String, Metric> entry : metricMap.entrySet()) {
		    array[count][0] = entry.getValue().getClassName();
		    array[count][1] = entry.getValue().getInDegree();
		    array[count][2] = entry.getValue().getOutDegree();
		    array[count][3] = entry.getValue().getStability();
		    count++;
		}
		
		for (int i = 0; i < rows ; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.println(array[i][j] + " ");
			}
		}
		return array;
	}
	
	public void displayTwoDimObject() {
		
		for (int i = 0; i < rows ; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.println(array[i][j] + " ");
			}
		}
	}
}

	


	/*public static void main(String[] args) {
		
		Metric metric = new Metric();
		Map<String, Metric> metricMap = new HashMap<String, Metric>();
		
		metric.setClassName("ie.gmit.sw.testClass");
		metric.setInDegree(5);
		metric.setOutDegree(6);
		metric.setStability(metric.getStability());
		metricMap.put("ie.gmit.sw.testClass", metric);
		
		ObjectMapAdapter(metricMap, metric);
		
	}	*/
	
	
	/*public static Object[][] ObjectMapAdapter(Map<String, Metric> metricMap, Metric metric) {
		Object[][] array = new Object[metricMap.size()][4];
		int cols = 4;
		int rows = metricMap.size();
		int count = 0;
		
		// Reference http://stackoverflow.com/questions/2265266/convert-hash-map-to-2d-array
		for(Map.Entry<String, Metric> entry : metricMap.entrySet()) {
			
		    array[count][0] = entry.getValue().getClassName();
		    array[count][1] = entry.getValue().getInDegree();
		    array[count][2] = entry.getValue().getOutDegree();
		    array[count][3] = entry.getValue().getStability();
		    count++;
		}
		
		// Display 2dArray Values
		for (int i = 0; i < rows ; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.println(array[i][j] + " ");
			}
		}
		return array;*/
	

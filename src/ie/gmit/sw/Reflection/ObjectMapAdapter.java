package ie.gmit.sw.Reflection;

import java.util.Map;

public class ObjectMapAdapter {
	
	private int rows;
	private int cols;
	private Object[][] array;
	
	
	public Object[][] adapt(Map<String, Metric> metricMap, Metric metric) {
		
		int cols = 5;
		int rows = metricMap.size();
		int count = 0;
		array = new Object[rows][cols];
		
		for(Map.Entry<String, Metric> entry : metricMap.entrySet()) {
			array[count][0] = entry.getValue().fillColumn();
			array[count][1] = entry.getValue().getClassName();
		    array[count][2] = entry.getValue().getInDegree();
		    array[count][3] = entry.getValue().getOutDegree();
		    array[count][4] = entry.getValue().getStability();
		    count++;
		}
		
		/*for (int i = 0; i < rows ; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.println(array[i][j] + " ");
			}
		}*/
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
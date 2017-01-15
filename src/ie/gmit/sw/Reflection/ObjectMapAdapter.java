package ie.gmit.sw.Reflection;

import java.util.Map;


/**
 * A Class that holds a single method that takes in a Map and returns a 2d Object Array and
 * takes both a required Map and a Metric Object as arguments.   
 * The purpose of creating this class and class method was to deal with returning 
 * the data to the <b>View</b> / GUI Front end section of the application. 
 * A given {@link Metric} object is saved using a HashMap<K,V>
 * where the Key is the class package name, and the Value is the Metric object itself
 * that contains the ClassName, InDegree, OutDegree and Stability. However, it made more sense to have 
 * a 2d Object Array display the details of the Metrics in the JTable. Essentially this is a Customised
 * version of an <b>Adapter Pattern</b>, designed to work with the general spirit of it and may not be exactly how the pattern 
 * was intended to be used. 
 * 
 * @author Will Hogan
 * @category Advanced Object oriented Programming
 */
public class ObjectMapAdapter {
	
	/**
	 * @param metricMap
	 * @param metric
	 * @return array
	 */
	public Object[][] adapt(Map<String, Metric> metricMap, Metric metric) {
		
		// Create the local variables accessible within the scope of this class only  
		int cols = 5;
		int rows = metricMap.size();
		int count = 0;
		Object[][] array = new Object[rows][cols];
		
		// For each value the in the HashMap, add to the 2d Object Array
		for(Map.Entry<String, Metric> entry : metricMap.entrySet()) {
			array[count][0] = entry.getValue().fillColumn();
			array[count][1] = entry.getValue().getClassName();
		    array[count][2] = entry.getValue().getInDegree();
		    array[count][3] = entry.getValue().getOutDegree();
		    array[count][4] = entry.getValue().getStability();
		    count++;
		}
		
		// For testing purposes, displays the details of the 2d Array in the console  
		displayObject(array, rows, cols);
		
		// Return the 2d Object Array
		return array;
	}
	
	/**
	 *  When called, Displays the Contents of the 2d Object Array in the console. 
	 * 
	 * @param array
	 * @param rows
	 * @param cols
	 */
	public void displayObject(Object[][] array, int rows, int cols) {
		for (int i = 0; i < rows ; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.println(array[i][j] + " ");
			}
		}
	}
}
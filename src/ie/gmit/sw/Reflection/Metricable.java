package ie.gmit.sw.Reflection;

import java.util.Map;

/** 
 * An Interface that contains all declarative methods required by the {@link CalculateMetrics} class. 
 * This <b>Abstraction</b> was created with the purpose of providing an opportunity to create any desired implementation.
 *  
 * @author Will Hogan
 */
public interface Metricable {

	/**
	 * For each class name in the List object returned from the {@link ReadJarFileData} class, 
	 * add to the Key section of a Map and create a new Metric Object as the value (See the populateMap method in this class). 
	 * As the Metrics are calculated, each Metric object in the map is updated with the Class Name, In Degree, Out Degree and Stability. 
	 * To calculate the metrics for each class, Interfaces, Constructors, Fields and Methods are analysed and the data added to the HashMap. 
	 * The calculateMetrics() class returns the 2d Object Array that's then used bu the <b>View</b> or GUI section of the Application. 
	 * 
	 * @return arrayObject
	 */
	public abstract Object[][] calculateMetrics() throws ClassNotFoundException;
	
	/**
	 * Display Values stored in the Map. 
	 * This displays the stored values for the Key(Class Names) and Metric Object(ClassName, InDegree, OutDegree, Stability)
	 * 
	 * @param metricMap Takes a Map as an argument
	 */
	public abstract void displayMapValues(Map<String, Metric> metricMap);
	
	/**
	 * A method that returns a Map. The map uses the returned values from the ListClass object, 
	 * to populate the Key of the map and a new Metric Object is placed as the value for each class Name in the list. 
	 * 
	 * @return metricMap
	 */
	public abstract Map<String, Metric> populateMap();
}
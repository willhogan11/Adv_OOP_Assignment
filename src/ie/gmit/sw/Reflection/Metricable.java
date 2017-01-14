package ie.gmit.sw.Reflection;

import java.util.Map;

/** 
 * An Interface that contains all declarative methods required by the {@link CalculateMetrics} class. 
 * This Abstraction was created with the purpose of providing an opportunity to create any desired implementation.
 *  
 * @author Will Hogan
 * @category Advanced Object oriented Programming
 */
public interface Metricable {

	public abstract Object[][] calculateMetrics() throws ClassNotFoundException;
	public abstract void displayMapValues(Map<String, Metric> metricMap);
	public abstract Map<String, Metric> populateMap();
}
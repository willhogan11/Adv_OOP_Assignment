package ie.gmit.sw.Reflection;

import java.util.Map;

public interface Metricable {

	public abstract Object[][] calculateMetrics() throws ClassNotFoundException;
	public abstract void displayMapValues(Map<String, Metric> metricMap);
	public abstract Map<String, Metric> populateMap();
}
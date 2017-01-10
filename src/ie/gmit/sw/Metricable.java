package ie.gmit.sw;

import java.util.List;
import java.util.Map;

public interface Metricable {

	public abstract List<String> readJarFile();
	public abstract Map<String, Metric> calcCouplings() throws ClassNotFoundException;
	public abstract void displayMapValues(Map<String, Metric> metricMap);
	public abstract Map<String, Metric> populateMap(List<String> listOfClasses);
}
package ie.gmit.sw.Reflection;

/** 
 * A Factory class that creates a Single instance of the Metric class
 * I chose the Metric class to use to implement the Factory Pattern, as at any one time, there
 * will only be one instance of a Metric object per run. 
 * 
 * @author Will Hogan
 * @category Advanced Object oriented Programming
 */
public class MetricFactory {
	
	// Create an instance of this class 
	private static MetricFactory fact = new MetricFactory();
	
	/**
	 * Create a private constructor that disallows anyone from creating their own instance of this class.
	 */
	private MetricFactory() {
	}
	
	/**
	 * Returns the Singleton instance variable declared in this class. 
	 * 
	 * @return MetricFactory fact
	 */
	public static MetricFactory getInstance() {
		return fact;
	}
	
	/**
	 * Returns the new Metric Object. 
	 * @return new Metric()
	 */
	public Metric getMetricObject() {
		return new Metric();
	}
}
package ie.gmit.sw.Reflection;

public class MetricFactory {
	
	// Create an instance of this class 
	private static MetricFactory fact = new MetricFactory();
	
	// Create a private constructor that disallows anyone from creating their own instance of this class. 
	private MetricFactory() {
	}
	
	// Return the Singleton instance from this getInstance method
	public static MetricFactory getInstance() {
		return fact;
	}
	
	// Return a new Metric instance
	public Metric getMetricObject() {
		return new Metric();
	}
}
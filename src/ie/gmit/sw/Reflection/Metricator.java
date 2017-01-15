package ie.gmit.sw.Reflection;

/** 
 * An Interface that contains all declarative methods required by the {@link Metric} class. 
 * This <b>Abstraction</b> was created with the purpose of providing an opportunity to create any desired implementation.
 *  
 * @author Will Hogan
 */
public interface Metricator {

	/**
	 * Returns the class name.
	 * 
	 * @return String className
	 */
	public abstract String getClassName();
	
	/**
	 * Takes a string as an argument and sets the value of the class name.
	 * 
	 * @param className
	 */
	public abstract void setClassName(String className);
	
	/**
	 * Returns the In Degree
	 * 
	 * @return int inDegree
	 */
	public abstract int getInDegree();
	
	/**
	 * Takes an int as an argument and sets the value of the in degree.
	 * 
	 * @param inDegree
	 */
	public abstract void setInDegree(int inDegree);
	
	/**
	 * Returns the Out Degree
	 * 
	 * @return int OutDegree
	 */
	public abstract int getOutDegree();
	
	/**
	 * Takes an int as an argument and sets the value of the out degree.
	 * 
	 * @param outDegree
	 */
	public abstract void setOutDegree(int outDegree);
	
	/**
	 * Takes a float as an argument and sets the value of the calculated stability. 
	 * 
	 * @param stability
	 */
	public abstract void setStability(float stability);
	
	/**
	 * A method that calculates the stability of a given class by methods mentioned earlier. 
	 * 
	 * @return float stability
	 */
	public abstract float getStability();
}
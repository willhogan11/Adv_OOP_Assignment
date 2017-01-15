package ie.gmit.sw.Reflection;

/**
 * A 'Bean' class that contains Getters and Setters for a given Metric object. 
 * As the instance variables are declared as private, only the get and set methods are visible,
 * which <b>Encapsulates</b> them from an outside class.
 *  
 * A Metric object will hold the following:
 * <ul>
 * <li>The Class Name that is being scrutinised. </li>
 * <li>The In Degree or Afferent Couplings(Ca), which is the number of edges incident on a given class. </li>
 * <li>The Out Degree or Efferent Couplings(Ce), which is the number of edges emanating from a class. </li>
 * <li>The Stability of the class, that is calculated by using the below formula </li>
 * <li><b><i>i = ce / ca + ce</i></b><br></li>
 * </ul>
 * 
 * 
 * @author Will Hogan
 */
public class Metric implements Metricator {

	// Private instance variables
	private int inDegree;
	private int outDegree;
	private String className;
	
	/**
	 * Returns the class name.
	 * 
	 * @return className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * Takes a string as an argument and sets the value of the class name.
	 * 
	 * @param className
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * Returns the In Degree
	 * 
	 * @return int inDegree
	 */
	public int getInDegree() {
		return inDegree;
	}
	
	/**
	 * Takes an int as an argument and sets the value of the in degree.
	 * 
	 * @param inDegree
	 */
	public void setInDegree(int inDegree) {
		this.inDegree = inDegree;
	}

	/**
	 * Returns the Out Degree
	 * 
	 * @return int OutDegree
	 */
	public int getOutDegree() {
		return outDegree;
	}
	
	/**
	 * Takes an int as an argument and sets the value of the out degree.
	 * 
	 * @param outDegree
	 */
	public void setOutDegree(int outDegree) {
		this.outDegree = outDegree;
	}
	
	// Fills the First column in the JTable with the value 'Details'. 
	public String fillColumn(){
		return "Details";
	}
	
	/**
	 * Takes a float as an argument and sets the value of the calculated stability. 
	 * 
	 * @param stability
	 */
	public void setStability(float stability){
		getStability();
	}
	
	/**
	 * A method that calculates the stability of a given class by methods mentioned earlier. 
	 * 
	 * @return float stability
	 */
	public float getStability() {
		float stability = 0;
		float inPlusOut = inDegree + outDegree;
		stability = outDegree / inPlusOut;
		return stability;
	}
}
package ie.gmit.sw.Reflection;

import java.util.ArrayList;
import java.util.List;

/**
 * A Customised List class that implements the {@link ListClassable} interface and delegates calls to the java.util.list package, 
 * which performs a number of required operations. 
 * Created and used to provide a good example of <b>Composition and Delegation</b>, 
 * ie that a metric to be calculated {@link CalculateMetrics} 'HAS-A' List of classes associated with it and that 
 * by implementing a customised version of the java.util.list class, demonstrates the use of Delegation. 
 * 
 * @author Will Hogan
 * @category Advanced Object oriented Programming
 */
public class ListClass implements ListClassable {
	
	// Create and initialise a new ArrayList of type List. 
	private List<String> list = new ArrayList<String>();
	
	/**
	 * Takes a String as an argument and adds it to the list. 
	 * 
	 *  @param String str
	 *  @return boolean list.add(str)
	 */
	public boolean add(String str) {
		return list.add(str);
	}
	
	/**
	 * Takes a String as an argument and check if that string is in the list.
	 * 
	 *  @param String str
	 *  @return boolean list.contains(str)
	 */
	public boolean containsValue(String str) {
		return list.contains(str);
	}
	
	/**
	 * Retrieves the value at a given index in the list.
	 * 
	 * @param int i
	 * @return String list.get(i)
	 */
	public String retrieve(int i) {
		return list.get(i);
	}
	
	/**
	 * Returns the size of the list.
	 * 
	 * @return int list.size()
	 */
	public int length() {
		return list.size();
	}
	
	/**
	 * A method that displays the contents of the list. 
	 */
	public void displayList() {
		for (String string : list) {
			System.out.println(string);
		}
	}
}
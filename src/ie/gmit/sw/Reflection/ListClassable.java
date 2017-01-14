package ie.gmit.sw.Reflection;

/** 
 * An interface that contains all declarative methods required by the {@link ListClass} class 
 *  
 * @author Will Hogan
 * @category Advanced Object oriented Programming
 */
public interface ListClassable {

	/**
	 * Takes a String as an arguement and adds it to the list. 
	 * 
	 *  @param String str
	 *  @return boolean list.add(str)
	 */
	public abstract boolean add(String str);
	
	/**
	 * Takes a Strig as an arguement and check if that string is in the list.
	 * 
	 *  @param String str
	 *  @return boolean list.contains(str)
	 */
	public abstract boolean containsValue(String str);
	
	/**
	 * Retrieves the value at a given index in the list.
	 * 
	 * @param int i
	 * @return String list.get(i)
	 */
	public abstract String retrieve(int i);
	
	/**
	 * Returns the size of the list.
	 * 
	 * @return int list.size()
	 */
	public abstract int length();
	
	/**
	 * A method that displays the contents of the list. 
	 */
	public abstract void displayList();
}
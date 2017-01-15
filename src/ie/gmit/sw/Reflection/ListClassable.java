package ie.gmit.sw.Reflection;

/** 
 * An Interface that contains all declarative methods required by the {@link ListClass} class. 
 * This <b>Abstraction</b> was created with the purpose of providing an opportunity to create any desired implementation.
 *  
 * @author Will Hogan
 */
public interface ListClassable {

	/**
	 * Takes a String as an argument and adds it to the list. 
	 * 
	 *  @param str
	 *  @return list.add(str)
	 */
	public abstract boolean add(String str);
	
	/**
	 * Takes a String as an argument and check if that string is in the list.
	 * 
	 *  @param str
	 *  @return list.contains(str)
	 */
	public abstract boolean containsValue(String str);
	
	/**
	 * Retrieves the value at a given index in the list.
	 * 
	 * @param i
	 * @return list.get(i)
	 */
	public abstract String retrieve(int i);
	
	/**
	 * Returns the size of the list.
	 * 
	 * @return list.size()
	 */
	public abstract int length();
	
	/**
	 * A method that displays the contents of the list. 
	 */
	public abstract void displayList();
}
package ie.gmit.sw.Reflection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * A Class used to read the contents of a given Jar File into a List. 
 * The method below was created to use the methods associated with the {@link ListClass}, Customised class.
 * It performs a number of specific tasks. Using the <b>Decorator Design Pattern</b>, a level of nesting has been implemented
 * to enable a File, to be converted into a Jar input stream. 
 * 
 * Here are the details for the single method in this class;
 * <ul>
 * <li>Read in the Jar File</li>
 * <li>Parse out anything that's not a Fully packaged name</li>
 * <li>Add all the package names to a List</li>
 * <li>Return the List</li>
 * </ul>
 * 
 * @author Will Hogan
 * @category Advanced Object oriented Programming
 */
public class ReadJarFileData {
	
	/**
	 * A Method used to read the contents of a given Jar File into a List.
	 * 
	 * @return ListClass listOfClasses
	 */
	public ListClass readJarFile() { 
		
		
		ListClass listOfClasses = new ListClass();
		
		try {
			
			JarFileName jarFileName = new JarFileName();
			JarInputStream in = new JarInputStream(new FileInputStream(new File(jarFileName.getFile())));
			JarEntry next = in.getNextJarEntry();
			
			while (next != null) {
				
				if (next.getName().endsWith(".class")) {
					String name = next.getName().replaceAll("/", "\\.");
					name = name.replaceAll(".class", "");
					
					if (!name.contains("$")) name.substring(0, name.length() - ".class".length());
					listOfClasses.add(name);
				}
				next = in.getNextJarEntry();
			}
			in.close();

			// Using the displayList() method from the ListClass to display contents of the list. 
			listOfClasses.displayList(); 
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listOfClasses;
	}
}
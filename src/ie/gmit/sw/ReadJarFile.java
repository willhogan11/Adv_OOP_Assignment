package ie.gmit.sw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;


public class ReadJarFile {
	
	private static List<String> listOfClasses = new ArrayList<String>();	
	private static Map<String, Metric> metricMap = new HashMap<String, Metric>();
	private static Metric metric = new Metric();
	private static Class cls;
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		// Testing to see if i can manually calculate the OutDegree.... 
	/*	for (int i = 0; i < metricMap.size(); i++) {
			
			// Display all names in the list
			cls = Class.forName(listOfClasses.get(i));
			
			System.out.println("Name: " + cls.getSimpleName() + " :  Is Interface? " + cls.isInterface());
			// Metric m = metricMap.get(cls.getName());
		}*/

		
		
		// Grab each name returned from reading the Jar File and store in a list 
		listOfClasses = readJarFile();
		
		
		// Add each class in the list to a Map along with a New Metric Object
		for (String string : listOfClasses) {
			metricMap.put(string, new Metric());
		}
		
		// Display the details of the Map
	/*	for ( Entry<String, Metric> entry : metricMap.entrySet()) {
		    String key = entry.getKey();
		    metric = entry.getValue();
		    
		    System.out.println("Keys Stored in Map =====> " + key);
		}*/
		
		
		// Display the Names of each class name associated with the 'cls' instance
		for (int i = 0; i < metricMap.size(); i++) {
		
			cls = Class.forName(listOfClasses.get(i));
			System.out.println("Get Name: " + cls.getName());
		}
		
		Class[] interfaces = cls.getInterfaces();
		boolean isInterface = cls.isInterface();
		
		
		for(Class c : interfaces){
			System.out.println(c.getInterfaces());
		}
		
	}



	//...Need to clone the below list and return that clone, for 100% encapsulation
	public static List<String> readJarFile() { // Map<String, Metric>
		
		// Read in jar file working. 
		try {
			JarInputStream in = new JarInputStream(new FileInputStream(new File("string-service.jar")));
			JarEntry next = in.getNextJarEntry();
			
			while (next != null) {
				
				if (next.getName().endsWith(".class")) {
					String name = next.getName().replaceAll("/", "\\.");
					name = name.replaceAll(".class", "");
					metric.setClassName(name);
					
					if (!name.contains("$")) name.substring(0, name.length() - ".class".length());
						
						listOfClasses.add(metric.getClassName());
				}
				next = in.getNextJarEntry();
			}
			in.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return listOfClasses;
	}
	
	
	
	public static void calcCouplings(Class cls) {
		
		int inDegree = 0;
		int outDegree = 0;
		
		listOfClasses = readJarFile();
		
		for (String string : listOfClasses) {
	
			metricMap.put(string, new Metric());
		}
		
		Class[] interfaces = cls.getInterfaces();
		boolean isInterface = cls.isInterface();
		
		System.out.println();
	}
	
		
	
	public HashMap<String, Metric> fillHashMap(List<String> listOfClasses){
		
		Metric m = new Metric();
		
		for (String string : listOfClasses) {
			metricMap.put(m.getClassName(), new Metric());
			System.out.println("From the 'fillHashMap' method : " + string);
		}
		return (HashMap<String, Metric>) metricMap;
	}
	
}	
package ie.gmit.sw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;


public class ReadJarFile {
	
	private List<String> listOfClasses = new ArrayList<String>();	
	private Map<String, Metric> metricMap = new HashMap<String, Metric>();
	private Metric metric = new Metric();
	private static Class cls;
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		ReadJarFile r = new ReadJarFile(cls);
		
	}
	
	
	public ReadJarFile(Class cls) throws ClassNotFoundException{
		this.cls = cls;
		calcCouplings(cls);
	}


	//...Need to clone the below list and return that clone, for 100% encapsulation
	public List<String> readJarFile() { 
		
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
	
	
	
	public void calcCouplings(Class cls) throws ClassNotFoundException {
		
		int inDegree = 0;
		int outDegree = 0;
		
		metricMap = populateMap(listOfClasses);
	
		// Display the Names of each class name associated with the 'cls' instance
		for (int i = 0; i < metricMap.size(); i++) {

			cls = Class.forName(listOfClasses.get(i));
			// System.out.println("Name : " + cls.getName());
			
			Class[] interfaces = cls.getInterfaces();
			
			for (Class c : interfaces) {
				
				// Ignore anything outside of this package
				if(metricMap.containsKey(c.getName())) {
					System.out.println(c.getName() + " : " + c.isInterface());
					
					outDegree++;
					
					Metric m = metricMap.get(c.getName());
					m.setInDegree(m.getInDegree() + 1);
				}
			}
			metricMap.get(cls.getName()).setOutDegree(outDegree);
		}
	
		/* Display Values in the Map, <String, Metric>
		 * This displays the stored values for the Key(Class Names) and Metric Object(InDegree, OutDegree, Stability)
		 */
		for ( Entry<String, Metric> entry : metricMap.entrySet()) {
		    String key = entry.getKey();
		    Metric value = entry.getValue();
		    System.out.println("Keys : " + key + "--------------------InDegree : " 
										 + value.getInDegree() + "--------------------OutDegree : " 
										 + value.getOutDegree() + "--------------------Stability : "
										 + value.getStability());
		}
	}
	
	
	public Map<String, Metric> populateMap(List<String> listOfClasses){
		
		listOfClasses = readJarFile();
		
		for (String names : listOfClasses) {
			metricMap.put(names, new Metric());
		}
		return metricMap;
	}
}	
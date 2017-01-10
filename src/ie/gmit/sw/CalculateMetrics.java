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


public class CalculateMetrics {
	
	private static List<String> listOfClasses = new ArrayList<String>();	
	private static Map<String, Metric> metricMap = new HashMap<String, Metric>();
	private static Metric metric = new Metric();
	private static Class cls;
	
	
	// public static void main(String[] args) throws ClassNotFoundException {
		
	/*	CalculateMetrics r = new CalculateMetrics(cls, metric);
		r.readJarFile();
		r.calcCouplings(cls);
		// r.displayMapValues(metricMap);
		
		Map<String, Metric> newMetricMap = new HashMap<String, Metric>();
		
		for (int i = 0; i < metricMap.size(); i++) {
			newMetricMap.put(listOfClasses.get(i), metricMap.get(i));
		}
		
		System.out.println(newMetricMap.size());
		
		for ( Entry<String, Metric> entry : metricMap.entrySet()) {
		    String key = entry.getKey();
		    metric = entry.getValue();
		    System.out.println("Keys : " + key 
		    							 + "--------------------Class Name : " + metric.getClassName()
		    							 + "--------------------InDegree : " + metric.getInDegree() 
		    							 + "--------------------OutDegree : " + metric.getOutDegree() 
		    							 + "--------------------Stability : " + metric.getStability());
		}*/
		
	// }
	
	
	public CalculateMetrics() throws ClassNotFoundException{
		this.cls = cls;
		this.metric = metric;
		readJarFile();
		calcCouplings();
		displayMapValues(metricMap);
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
	
	
	
	public Metric calcCouplings() throws ClassNotFoundException {
		
		int outDegree = 0;
		
		// Populate a hashmap, with a filled list of Class Names and Metric Objects
		metricMap = populateMap(listOfClasses);
		
		// Display the Names of each class name associated with the 'cls' instance
		for (int i = 0; i < metricMap.size(); i++) {

			cls = Class.forName(listOfClasses.get(i));
			// System.out.println("Name : " + cls.getName());
			
			Class[] interfaces = cls.getInterfaces();
			
			for (Class c : interfaces) {
				
				// Ignore anything outside of this package
				if(metricMap.containsKey(c.getName())) {
					// System.out.println(c.getName() + " : " + c.isInterface());
					
					metric = metricMap.get(c.getName());
					metric.setOutDegree(metric.getOutDegree() + 1);
					metric.setInDegree(metric.getInDegree() + 1);
					
					outDegree = metric.getOutDegree();
				}
			}
			metricMap.get(cls.getName()).setOutDegree(outDegree);

		} //  End metricMap.size()	
		
		return metric;
	}
	
	
	/* Display Values in the Map, <String, Metric>
	 * This displays the stored values for the Key(Class Names) and Metric Object(InDegree, OutDegree, Stability) */
	public void displayMapValues(Map<String, Metric> metricMap) {
		
		for ( Entry<String, Metric> entry : metricMap.entrySet()) {
		    String key = entry.getKey();
		    Metric value = entry.getValue();
		    System.out.println("Keys : " + key 
		    							 + "--------------------Class Name : " + value.getClassName()
		    							 + "--------------------InDegree : " + value.getInDegree() 
		    							 + "--------------------OutDegree : " + value.getOutDegree() 
		    							 + "--------------------Stability : " + value.getStability());
		}
	}
	
	
	public Map<String, Metric> populateMap(List<String> listOfClasses){
		
		listOfClasses = readJarFile();
		
		for (String names : listOfClasses) {
			metricMap.put(names, new Metric());
			metricMap.get(names).setClassName(names);
		}
		return metricMap;
	}
}	
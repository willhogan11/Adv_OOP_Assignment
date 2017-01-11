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


public class CalculateMetrics implements Metricable {
	
	private List<String> listOfClasses = new ArrayList<String>();	
	private Map<String, Metric> metricMap = new HashMap<String, Metric>();
	private Metric metric = new Metric();
	private Class<?> cls;
	
	
	public CalculateMetrics() throws ClassNotFoundException {
		
		readJarFile();
		calculateMetrics();
		
		// For Testing, displays all the Values in the HashMap [See below method body]
		// displayMapValues(metricMap); 
	}


	//...Need to clone the below list and return that clone, for 100% encapsulation
	public List<String> readJarFile() { 
		
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
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return listOfClasses;
	}
	
	
	
	public Map<String, Metric> calculateMetrics() throws ClassNotFoundException {
		
		int outDegree = 0;
		
		// Populate a hashmap, with a filled list of Class Names and Metric Objects
		metricMap = populateMap(listOfClasses);
		
		// Display the Names of each class name associated with the 'cls' instance
		for (int i = 0; i < metricMap.size(); i++) {

			cls = Class.forName(listOfClasses.get(i));
			
			// Interfaces
			Class[] interfaces = cls.getInterfaces();
			
			for (Class c : interfaces) {
				
				// Ignore anything outside of this package
				if(metricMap.containsKey(c.getName())) {
					
					metric = metricMap.get(c.getName());
					metric.setOutDegree(metric.getOutDegree() + 1);
					metric.setInDegree(metric.getInDegree() + 1);
					
					outDegree = metric.getOutDegree();
				}
			}
			
			// Constructors
			Constructor ctorlist[] = cls.getDeclaredConstructors();
			
			for (Constructor constructor : ctorlist) {
				
				Class[] ctorParams = constructor.getParameterTypes();
				
				for (Class ctorparams : ctorParams) {
					
					if(metricMap.containsKey(ctorparams.getName())){
						
						metric = metricMap.get(ctorparams.getName());
						metric.setOutDegree(metric.getOutDegree() + 1);
						metric.setInDegree(metric.getInDegree() + 1);
						
						outDegree = metric.getOutDegree();
					}
				}
			}
			
			// Fields
			Field fieldlist[] = cls.getDeclaredFields();
			
			for (Field field : fieldlist) {
				
				if(metricMap.containsKey(field.getName())) {
					
					metric = metricMap.get(field.getName());
					metric.setOutDegree(metric.getOutDegree() + 1);
					metric.setInDegree(metric.getInDegree() + 1);
					
					outDegree = metric.getOutDegree();
				}
			}
			
			// Methods
			Method methlist[] = cls.getDeclaredMethods();
			
			for (Method method : methlist) {
				
				Class[] methodParams;
				Class methReturnType = method.getReturnType();
				
				if(metricMap.containsKey(methReturnType.getName())) {
					
					metric = metricMap.get(methReturnType.getName());
					metric.setOutDegree(metric.getOutDegree() + 1);
					metric.setInDegree(metric.getInDegree() + 1);
					
					outDegree = metric.getOutDegree();
				}
			}
			
			metricMap.get(cls.getName()).setOutDegree(outDegree);

		} //  End metricMap.size()	
		
		return metricMap;
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
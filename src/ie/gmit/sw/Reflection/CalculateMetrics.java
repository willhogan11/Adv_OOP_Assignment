package ie.gmit.sw.Reflection;

import java.lang.reflect.*;
import java.util.*;
import java.util.Map.Entry;


/**
 * A class that is used to calculate the Afferent and Efferent couplings and Stability of a given class / jar file.
 * For each class name in the List object returned from the {@link ReadJarFileData} class, 
 * add to the Key section of a Map and create a new Metric Object as the value (See the populateMap method in this class). 
 * As the Metrics are calculated, each Metric object in the map is updated with the Class Name, In Degree, Out Degree and Stability. 
 * To calculate the metrics for each class, Interfaces, Constructors, Fields and Methods are analysed and the data added to the HashMap. 
 * The calculateMetrics() class returns the 2d Object Array that's then used bu the <b>View</b> or GUI section of the Application. 
 * 
 * @author Will Hogan
 * @category Advanced Object oriented Programming
 */
public class CalculateMetrics implements Metricable {
	
	private ListClass listOfClasses;	
	private Map<String, Metric> metricMap;
	private Metric metric;
	private MetricFactory metricFactory;
	private Class<?> cls;
	private ReadJarFileData readJarFileData;
	
	/**
	 * For each class name in the List object returned from the {@link ReadJarFileData} class, 
	 * add to the Key section of a Map and create a new Metric Object as the value (See the populateMap method in this class). 
	 * As the Metrics are calculated, each Metric object in the map is updated with the Class Name, In Degree, Out Degree and Stability. 
	 * To calculate the metrics for each class, Interfaces, Constructors, Fields and Methods are analysed and the data added to the HashMap. 
	 * The calculateMetrics() class returns the 2d Object Array that's then used bu the <b>View</b> or GUI section of the Application. 
	 * 
	 * @return arrayObject
	 * @throws ClassNotFoundException
	 */
	public Object[][] calculateMetrics() throws ClassNotFoundException {
	
		// Initialising private instance, and local variables  
		listOfClasses = new ListClass();
		metricMap = new HashMap<String, Metric>();
		metricFactory = MetricFactory.getInstance();
		metric = metricFactory.getMetricObject();
		int outDegree = 0;
		
		
		// Populate a hashmap, with a filled list of Class Names and Metric Objects
		metricMap = populateMap();
		
		// Create new ObjectMapAdapter and 2d Object Array objects 
		ObjectMapAdapter objectMapAdapter;
		Object[][] arrayObject;
		
		// Display the Names of each class name associated with the 'cls' instance
		for (int i = 0; i < metricMap.size(); i++) {
			
			// For each class name in the list, dynamically load Classes (by name) through invoking the Java class loader
			cls = Class.forName(listOfClasses.retrieve(i));
			
			// Interfaces:
			Class[] interfaces = cls.getInterfaces();
			
			// For each Class that's an Interface....
			for (Class c : interfaces) {
				
				// Ignore anything outside of this package
				// Add the name to the metric name object for that iteration
				// Increment both the out and in degrees
				if(metricMap.containsKey(c.getName())) {
					
					metric = metricMap.get(c.getName());
					metric.setOutDegree(metric.getOutDegree() + 1);
					metric.setInDegree(metric.getInDegree() + 1);
					
					outDegree = metric.getOutDegree();
				}
			}
			
			// Continue with the same structure for each Constructor, Field and Method of that class [See Below] 
			
			// Constructors: 
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
				
				methodParams = method.getParameterTypes();
				
				for (Class mParameters : methodParams) {
					
					if(metricMap.containsKey(mParameters.getName())) {
						
						metric = metricMap.get(mParameters.getName());
						metric.setOutDegree(metric.getOutDegree() + 1);
						metric.setInDegree(metric.getInDegree() + 1);
						
						outDegree = metric.getOutDegree();
					}
				}
			}
			
			// For the class being analysed, get the name of the class and set the incremented out degree
			metricMap.get(cls.getName()).setOutDegree(outDegree);
			
		} //  End metricMap.size()	
		
		// Initialise a new Instance from the ObjectMapAdapter class and assign a new 2d Object arrya with it's returned values. 
		objectMapAdapter = new ObjectMapAdapter();
		arrayObject = objectMapAdapter.adapt(metricMap, metric);
		
		// Return the 2d Object Array
		return arrayObject;		
	}
	
	
	
	/**
	 * Display Values stored in the Map, <String, Metric>
	 * This displays the stored values for the Key(Class Names) and Metric Object(ClassName, InDegree, OutDegree, Stability)
	 * 
	 * @param metricMap
	 */
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
	
	
	/**
	 * A method that returns a Map. The map uses the returned values from the ListClass object, 
	 * to populate the Key of the map and a new Metric Object is placed as the value for each class Name in the list. 
	 * 
	 * @return metricMap
	 */
	public Map<String, Metric> populateMap() {
		readJarFileData = new ReadJarFileData();
		listOfClasses = readJarFileData.readJarFile();
		
		for (int i = 0; i < listOfClasses.length(); i++) {
			metricMap.put(listOfClasses.retrieve(i), new Metric());
			metricMap.get(listOfClasses.retrieve(i)).setClassName(listOfClasses.retrieve(i));
		}
		return metricMap;
	}
}	
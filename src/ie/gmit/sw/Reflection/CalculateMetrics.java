package ie.gmit.sw.Reflection;

import java.lang.reflect.*;
import java.util.*;
import java.util.Map.Entry;


public class CalculateMetrics implements Metricable {
	
	private ListClass listOfClasses;	
	private Map<String, Metric> metricMap;
	private Metric metric;
	private MetricFactory metricFactory;
	private Class<?> cls;
	private ReadJarFileData readJarFileData;
	
	
	public Object[][] calculateMetrics() throws ClassNotFoundException {
	
		listOfClasses = new ListClass();
		metricMap = new HashMap<String, Metric>();
		metricFactory = MetricFactory.getInstance();
		metric = metricFactory.getMetricObject();
		int outDegree = 0;
		
		
		// Populate a hashmap, with a filled list of Class Names and Metric Objects
		metricMap = populateMap();
		
		ObjectMapAdapter objectMapAdapter;
		Object[][] arrayObject;
		
		// Display the Names of each class name associated with the 'cls' instance
		for (int i = 0; i < metricMap.size(); i++) {

			cls = Class.forName(listOfClasses.retrieve(i));
			
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
		
		objectMapAdapter = new ObjectMapAdapter();
		arrayObject = objectMapAdapter.adapt(metricMap, metric);
		
		return arrayObject;		
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
package ie.gmit.sw.Reflection;

import java.util.*;
import java.util.Map.Entry;

import javax.swing.table.AbstractTableModel;

public class MetricModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private Map<String, Metric> metricMap = new HashMap<String, Metric>();
	private Metric metric;

	
	public Metric put(String names, Metric metric) {
		return metricMap.put(names, metric);
	}
	
	public int length() {
		return metricMap.size();
	}
	
	public Metric getMetric() {
		return metric;
	}

	public void setMetric(Metric metric) {
		this.metric = metric;
	}

	public boolean containsKey(HashMap<String, Metric> metricMap) {
		return metricMap.containsKey(metricMap);
	}

	@Override
	public String toString() {
		return "MetricModel [metricMap=" + metricMap + ", metric=" + metric + "]";
	}

	public void display() {
		
		for ( Entry<String, Metric> entry : metricMap.entrySet()) {
		    String key = entry.getKey();
		    Metric value = entry.getValue();
		    System.out.println("Key : " + key 
		    							 + "\nValue(Metrics) : \n\tClass Name : " + value.getClassName()
		    							 + "\n\tInDegree : " + value.getInDegree() 
		    							 + "\n\tOutDegree : " + value.getOutDegree() 
		    							 + "\n\tStability : " + value.getStability() + "\n");
		}
	}

	@Override
	public int getColumnCount() {
		return metricMap.size();
	}

	@Override
	public int getRowCount() {
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		return null;
	}
}
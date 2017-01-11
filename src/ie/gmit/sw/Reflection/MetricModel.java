package ie.gmit.sw.Reflection;

import java.util.*;
import java.util.Map.Entry;

import javax.swing.table.AbstractTableModel;

public class MetricModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private String[] keys;
	private Map<String, Metric> metricMap = new HashMap<String, Metric>();
	private Metric metric;
	
	public String[] getKeys() {
		return keys;
	}

	public void setKeys(String[] keys) {
		this.keys = keys;
	}

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

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return metricMap.size();
	}
	
	@Override
	public Object getValueAt(int row, int col) {
        if (col == 0) {
            return keys[row];
        } else {
            return metricMap.get(keys[row]);
        }
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
}
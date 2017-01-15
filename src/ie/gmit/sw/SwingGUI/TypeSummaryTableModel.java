package ie.gmit.sw.SwingGUI;

import javax.swing.table.*;
import ie.gmit.sw.Reflection.CalculateMetrics;

/**
 * A Class that connects the <b>Model</b> data contained and returned by the {@link CalculateMetrics} class. 
 * Using the various methods in this class, the data is used to populate the JTable on the GUI front end of the application
 * 
 * @author Will Hogan
 * @category Advanced Object oriented Programming
 */
public class TypeSummaryTableModel extends AbstractTableModel {
	
	// Private Instance Variables
	private static final long serialVersionUID = 777L;
	private String[] cols = {"", "Class Name", "In Degree", "Out Degree", "Stability"};
	private CalculateMetrics cm;
	private Object[][] data;
	
	/**
	 * @throws ClassNotFoundException
	 */
	public TypeSummaryTableModel() throws ClassNotFoundException{
		cm = new CalculateMetrics();
		data = cm.calculateMetrics();
	}
	
	/**
	 * @return int cols.length
	 */
	public int getColumnCount() {
        return cols.length;
    }
	
	/**
	 * return int data.length
	 */
    public int getRowCount() {
        return data.length;
	}

    /**
     * @param int col
     * @return String cols[col]
     */
    public String getColumnName(int col) {
    	return cols[col];
    }

    /**
     * @param int row
     * @param int col
     * @return Object data[row][col]
     */
    public Object getValueAt(int row, int col) {
        return data[row][col];
	}
    
    /**
     * @param int c
     * @return Class getValueAt(0, c).getClass()
     */
    public Class<?> getColumnClass(int c) {
        return getValueAt(0, c).getClass();
	}
}
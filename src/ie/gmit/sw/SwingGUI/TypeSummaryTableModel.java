package ie.gmit.sw.SwingGUI;

import javax.swing.table.*;
import ie.gmit.sw.Reflection.CalculateMetrics;


public class TypeSummaryTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 777L;
	
	private String[] cols = {"", "Class Name", "In Degree", "Out Degree", "Stability"};
	private CalculateMetrics cm;
	private Object[][] data;
	
	public TypeSummaryTableModel() throws ClassNotFoundException{
		cm = new CalculateMetrics();
		data = cm.calculateMetrics();
	}
	
	public int getColumnCount() {
        return cols.length;
    }
	
    public int getRowCount() {
        return data.length;
	}

    public String getColumnName(int col) {
    	return cols[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
	}
   
    public Class<?> getColumnClass(int c) {
        return getValueAt(0, c).getClass();
	}
}
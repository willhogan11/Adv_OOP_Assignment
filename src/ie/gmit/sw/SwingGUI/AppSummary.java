package ie.gmit.sw.SwingGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class AppSummary extends JDialog{
	private static final long serialVersionUID = 777L;	
	private TypeSummaryTableModel tm = null;
	private JTable table = null;
	private JScrollPane tableScroller = null;
	private JButton btnClose = null;
	private JPanel tablePanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private Container c;
	
	public AppSummary(JFrame parent, boolean modal) throws ClassNotFoundException{
        super(parent, modal);
        super.setTitle("Summary");
        super.setResizable(true);
        
        this.setSize(new Dimension(800, 400));
        
		c = getContentPane();
		c.setLayout(new FlowLayout());	

		createTable();
        configureButtonPanel();
        
        c.add(tablePanel);
        c.add(buttonPanel);
	}
	
	
	private void createTable() throws ClassNotFoundException{
		tm = new TypeSummaryTableModel();
		table = new JTable(tm);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionBackground(Color.YELLOW);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		TableColumn column = null;
		for (int i = 0; i < table.getColumnCount(); i++){
			column = table.getColumnModel().getColumn(i);
			if (i == 0){
				column.setPreferredWidth(60);
				column.setMaxWidth(60);
				column.setMinWidth(60);
			}else{
				column.setPreferredWidth(175);
				column.setMaxWidth(175);
				column.setMinWidth(175);
			}
		}

		tableScroller = new JScrollPane(table);
		tableScroller.setPreferredSize(new java.awt.Dimension(900, 400));
		tableScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		tablePanel.add(tableScroller, FlowLayout.LEFT);
		tablePanel.setPreferredSize(new java.awt.Dimension(1000, 220));
	}
	
	private void configureButtonPanel(){
    	buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		//Configure the Cancel button
		btnClose = new JButton("Close");		
		btnClose.setToolTipText("Close this Window");
		btnClose.setPreferredSize(new java.awt.Dimension(100, 40));
		btnClose.setMaximumSize(new java.awt.Dimension(100, 40));
		btnClose.setMargin(new java.awt.Insets(2, 2, 2, 2));
		btnClose.setMinimumSize(new java.awt.Dimension(100, 40));
		btnClose.setIcon(new ImageIcon("images/close.gif"));
		btnClose.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
			}
		});

		buttonPanel.add(btnClose);
	}
}

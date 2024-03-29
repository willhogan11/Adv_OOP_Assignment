package ie.gmit.sw.SwingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The Application GUI frame that contains 2 button options, Display Metric Summary and Close. 
 * Clicking the display metric button, launches a JFrame table with the analysed metric data from a given Jar File.  
 * 
 * @author Will Hogan
 */
public class AppWindow {
	private JFrame frame;

	/**
	 * The Constructor for this class. 
	 */
	public AppWindow(){
		//Create a window for the application
		frame = new JFrame();
		frame.setTitle("B.Sc. in Software Development - GMIT");
		frame.setSize(300, 150);
		frame.setResizable(false);
		frame.setLayout(new FlowLayout());
		
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottom.setPreferredSize(new java.awt.Dimension(500, 50));
        bottom.setMaximumSize(new java.awt.Dimension(500, 50));
        bottom.setMinimumSize(new java.awt.Dimension(500, 50));
        
        JButton btnDialog = new JButton("Display Metric Summary"); //Create Quit button
        btnDialog.addActionListener(new java.awt.event.ActionListener() {
            @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent evt) {
            	AppSummary as = null;
				try {
					as = new AppSummary(frame, true);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
            	as.show();
			}
        });
        
        JButton btnQuit = new JButton("Close"); //Create Quit button
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	System.exit(0);
			}
        });
        bottom.add(btnDialog);
        bottom.add(btnQuit);

        frame.getContentPane().add(bottom);       
		frame.setVisible(true);
	}
}
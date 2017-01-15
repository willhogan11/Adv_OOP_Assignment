package ie.gmit.sw.SwingGUI;

/**
 * A class that is used to launch / Run the Application. 
 * 
 * @author Will Hogan
 */
public class Runner {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new AppWindow();
			}
		});
	}
}

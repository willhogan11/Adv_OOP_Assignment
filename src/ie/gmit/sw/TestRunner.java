package ie.gmit.sw;


public class TestRunner {

	public static void main(String[] args) throws ClassNotFoundException {
		
		CalculateMetrics r = new CalculateMetrics();
		
		Metric m = r.calcCouplings();
		
		System.out.println(m.getClassName());
	}
}
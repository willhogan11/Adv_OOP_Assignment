package ie.gmit.sw.Reflection;

public class MetricModelTestRunner {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Metric metric = new Metric();
		
		metric.setClassName("ie.gmit.sw.testClass");
		metric.setInDegree(5);
		metric.setOutDegree(6);
		
		
		MetricModel mm = new MetricModel();
		CalculateMetrics cm = new CalculateMetrics();
		
		mm.put("ie.gmit.sw.testClass", metric);
		
		System.out.println("Size of Map : " + mm.length());
		
		mm.display();
	}
}
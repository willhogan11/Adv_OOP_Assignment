package ie.gmit.sw;

public class Metric {

	private int inDegree;
	private int outDegree;
	private String className;
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getInDegree() {
		return inDegree;
	}
	
	public void setInDegree(int inDegree) {
		this.inDegree = inDegree;
	}
	
	public int getOutDegree() {
		return outDegree;
	}
	
	public void setOutDegree(int outDegree) {
		this.outDegree = outDegree;
	}
	
	public int IncrementInDegree() {
		return inDegree++;
	}

	public int IncrementOutDegree() {
		return outDegree++;
	}
	
	public float getStability() {
		float stability = 0;
		float inPlusOut = inDegree + outDegree;
		stability = outDegree / inPlusOut;
		return stability;
	}
}
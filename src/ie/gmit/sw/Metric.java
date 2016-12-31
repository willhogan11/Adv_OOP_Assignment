package ie.gmit.sw;

public class Metric {

	private int inDegree;
	private int outDegree;
	
	
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
	
	public float getStability() {
		float stability = 0;
		float inPlusOut = inDegree + outDegree;
		stability = outDegree / inPlusOut;
		return stability;
	}
}
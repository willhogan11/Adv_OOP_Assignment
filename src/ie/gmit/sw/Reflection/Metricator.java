package ie.gmit.sw.Reflection;

public interface Metricator {

	public abstract String getClassName();
	public abstract void setClassName(String className);
	public abstract int getInDegree();
	public abstract void setInDegree(int inDegree);
	public abstract int getOutDegree();
	public abstract void setOutDegree(int outDegree);
	public abstract void setStability(float stability);
	public abstract float getStability();
}
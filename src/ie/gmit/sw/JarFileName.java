package ie.gmit.sw;

/* Used to Fully Encapsulate the jar file name. 
 * No one can access this and could even be located off-site*/
public class JarFileName {

	private String jarFileName = "string-service.jar";
	// private String jarFileName = "AssessmentTwo2016.jar";

	public String getFile() {
		return jarFileName;
	}
}
package ie.gmit.sw.Reflection;

/* Used to Fully Encapsulate the jar file name. 
 * No one can access this and could even be located off-site*/

/**
 * Used to Fully Encapsulate the jar file name. 
 * No one can access this and could even be located off-site
 * @author Will Hogan
 * @category Advanced Object oriented Programming
 */
public class JarFileName {

	private String jarFileName = "string-service.jar";

	public String getFile() {
		return jarFileName;
	}
}
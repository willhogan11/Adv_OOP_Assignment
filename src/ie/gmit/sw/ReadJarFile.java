package ie.gmit.sw;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class ReadJarFile {

	public static void main(String[] args) throws IOException {
		
		// Read in jar file working. 
		JarInputStream in = new JarInputStream(new FileInputStream(new File("string-service.jar")));
		JarEntry next = in.getNextJarEntry();
		
		while (next != null) {
			
			if (next.getName().endsWith(".class")) {
				String name = next.getName().replaceAll("/", "\\.");
				name = name.replaceAll(".class", "");
				
				if (!name.contains("$")) name.substring(0, name.length() - ".class".length());
					System.out.println(name);
			}
			next = in.getNextJarEntry();
		}
	}
}
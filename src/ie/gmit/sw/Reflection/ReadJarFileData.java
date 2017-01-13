package ie.gmit.sw.Reflection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class ReadJarFileData {
	
	
	public List<String> readJarFile() { 
		
		List<String> listOfClasses = new ArrayList<String>();
		
		try {
			
			JarFileName jarFileName = new JarFileName();
			JarInputStream in = new JarInputStream(new FileInputStream(new File(jarFileName.getFile())));
			JarEntry next = in.getNextJarEntry();
			
			while (next != null) {
				
				if (next.getName().endsWith(".class")) {
					String name = next.getName().replaceAll("/", "\\.");
					name = name.replaceAll(".class", "");
					
					if (!name.contains("$")) name.substring(0, name.length() - ".class".length());
					listOfClasses.add(name);
				}
				next = in.getNextJarEntry();
			}
			in.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listOfClasses;
	}
}
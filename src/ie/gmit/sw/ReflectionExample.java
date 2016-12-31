package ie.gmit.sw;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class ReflectionExample {

	private static Class c;
   
	public static void main(String args[]) {
		
		// Create a New ArrayList to hold the class names, extracted from the jar file
		List<String> listOfClasses = new ArrayList<String>();	
		
		// Create a new instance of 'ReadJarFile'
		ReadJarFile r = new ReadJarFile();
		
		// Add all the class string names to an ArrayList
		listOfClasses.addAll(r.readJarFile());
		
		// Display the contents of the ArrayList
		for (String names : listOfClasses) {
			System.out.println(names);
		}
		
		System.out.println();

		// Dynamically load classes by invoking the java classloader
	    try {
	    	
	    	for (int i = 0; i < listOfClasses.size(); i++) {
				c = Class.forName(listOfClasses.get(i));
				System.out.println(c.getName());
			}
	    	
			System.out.println();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    
	    // Construct a new Reflection Example using the constructor with the class instance as a parameter
	    new ReflectionExample(c);
//	    System.out.println("Modifiers..." + c.getModifiers());
//	    System.out.println("Simple Name..." + c.getSimpleName());
//	    System.out.println("Type Name..." + c.getTypeName());
	    
	    
	    Package pack = c.getPackage(); //Get the package
	    boolean iface = c.isInterface(); //Is it an interface?
	    
	    Class[] interfaces = c.getInterfaces(); //Get the set of interface it implements
	    Constructor[] cons = c.getConstructors(); //Get the set of constructors
	    
	    for (int i = 0; i < cons.length; i++) {
			Class[] params = cons[i].getParameterTypes(); //Get the parameters
			
		}

	    
	    Field[] fields = c.getFields(); //Get the fields / attributes
	    Method[] methods = c.getMethods(); //Get the set of methods
	    
	    for (int i = 0; i < methods.length; i++) {
			Class c = methods[i].getReturnType(); //Get a method return type
			Class[] params = methods[i].getParameterTypes(); //Get method parameters
			
			System.out.println("Params : " + params.length + " Return Type : " + c);
		}
	    
	    
	}
	

   public ReflectionExample(Class c){
      super();
      this.c = c;

      printConstructors();
      printFields();
      printMethods();
      createArray();
   }

   public void printConstructors(){
      Constructor ctorlist[] = c.getDeclaredConstructors();
      System.out.println("--------------" + ctorlist.length + " Constructors --------------");
      for (int i = 0; i < ctorlist.length; i++) {
         Constructor ct = ctorlist[i];
         System.out.println("\tname  = " + ct.getName());
         System.out.println("\tdecl class = " + ct.getDeclaringClass());

         Class pvec[] = ct.getParameterTypes();
         for (int j = 0; j < pvec.length; j++){
            System.out.println("\tparam #" + j + " " + pvec[j]);
         }

         Class evec[] = ct.getExceptionTypes();
         for (int j = 0; j < evec.length; j++){
            System.out.println("\texc #" + j + " " + evec[j]);
         }
         System.out.println("\t-----");
      }
   }

   public void printFields(){
      Field fieldlist[] = c.getDeclaredFields();
      for (int i = 0; i < fieldlist.length; i++) {
         Field fld = fieldlist[i];
         System.out.println("\tname = " + fld.getName());
         System.out.println("\tdecl class = " + fld.getDeclaringClass());
         System.out.println("\ttype = " + fld.getType());
         int mod = fld.getModifiers();
         System.out.println("\tmodifiers = " + Modifier.toString(mod));
         System.out.println("-----");
      }
   }

   public void printMethods(){
      Method methlist[] = c.getDeclaredMethods();
      System.out.println("--------------" + methlist.length + " Methods --------------");
      for (int i = 0; i < methlist.length;i++) {
      	Method m = methlist[i];
      	System.out.println("\tname = " + m.getName());
      	System.out.println("\tdecl class = " + m.getDeclaringClass());
      	Class pvec[] = m.getParameterTypes();
      	for (int j = 0; j < pvec.length; j++){
         		System.out.println("\tparam #" + j + " " + pvec[j]);
    	}
      	Class evec[] = m.getExceptionTypes();
      	for (int j = 0; j < evec.length; j++){
         		System.out.println("\texc #" + j + " " + evec[j]);
      	}
      	System.out.println("\treturn type = " + m.getReturnType());
      	System.out.println("\t-----");
      }
   }

   public void createArray(){
      try {
         Class cls = Class.forName("java.lang.String");
         Object arr = Array.newInstance(cls, 10);
         Array.set(arr, 5, "Msc OO");
         String s = (String)Array.get(arr, 5);
         System.out.println(s);
      }catch (Throwable e) {
         System.err.println(e);
      }
   }
}
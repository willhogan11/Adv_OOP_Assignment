package ie.gmit.sw.Reflection;

import java.util.ArrayList;
import java.util.List;

public class ListClass implements ListClassable {
	
	private List<String> list = new ArrayList<String>();
	
	public boolean add(String str) {
		return list.add(str);
	}
	
	public boolean containsValue(String str) {
		return list.contains(str);
	}
	
	public String retrieve(int i) {
		return list.get(i);
	}
	
	public int length() {
		return list.size();
	}
	
	public void displayList() {
		for (String string : list) {
			System.out.println(string);
		}
	}
}
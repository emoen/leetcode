package datastructure;

import java.util.ArrayList;
import java.util.List;

public class Stack {
	private List<Object> stack = new ArrayList<Object>();
	private int i = 0;
	
	public void push(Object o) { 
		stack.add(o);
		i++;
	}
	
	public boolean isEmpty() {return i==0;}
	
	public Object pull() {
		if (i==0) return null;
		Object o = stack.get(i-1);
		stack.remove(i-1);
		i--;
		return o; 
	}
}

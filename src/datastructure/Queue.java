package datastructure;

import java.util.ArrayList;
import java.util.List;

public class Queue {
	private List<Object> queue = new ArrayList<Object>();
	private int i = 0;
	
	public void push(Object o) { 
		queue.add(o);
		i++;
	}
	
	public boolean isEmpty() {return i==0;}
	
	public Object pull() {
		if (i==0) return null;
		Object o = queue.get(0);
		queue.remove(0);
		i--;
		return o; 
	}
}

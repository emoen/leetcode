package technical;

import java.util.ArrayList;
import java.util.List;

import datastructure.*;


//Given a binary tree, get the avg value at each level
public class TreeAvgAtLevel {
	private List<Tuple> data = new ArrayList<Tuple>();
	
	public static void main(String[] args) {
		new TreeAvgAtLevel().toTest();
	}
	
	public void toTest() {
		Node root = new Node(4);
		root.left = new Node(7);
		root.left.left = new Node(10);
		root.left.right = new Node(2);
		root.left.right.right = new Node(6);
		root.left.right.right.left = new Node(2);
		
		root.right = new Node(9);
		root.right.right = new Node(6);
		
		collectDepthFirst(root, 0);
		
		double[] avgs = avgFromTuple(data);
		System.out.println("depthFirst:");
		for( int i=0; i<avgs.length; i++) {
			System.out.print(avgs[i]+" ");
		}
		
		System.out.println("");
		Queue q = new Queue();
		data = new ArrayList<Tuple>();
		collectBreathFirst(root, 0, q);
		double[] avgs2 = avgFromTuple(data);
		System.out.println("BreathFirst:");
		for( int i=0; i<avgs.length; i++) {
			System.out.print(avgs2[i]+" ");
		}
	}
	
	
	public void collectDepthFirst(Node curr, int depth) {
		if (curr == null) return;
		
		if (data.size()-1 < depth) {
			Tuple t = new Tuple(curr.value, 1);
			data.add(t);
		} else {
			Tuple t = data.get(depth);
			t.a += curr.value;
			t.b++;
		}
		
		collectDepthFirst(curr.left, depth+1);
		collectDepthFirst(curr.right, depth+1);
		return;
	}
	
	public void collectBreathFirst(Node curr, int depth, Queue q) {
		if (curr == null) return;

		if ( !q.isEmpty() ) {
			curr = (Node) q.pull();
			if (data.size()-1 < depth ) {
				Tuple t = new Tuple(curr.value, 1);
				data.add(t);
			} else {
				Tuple t = data.get(depth);
				t.a += curr.value;
				t.b++;	
			}
			collectBreathFirst(curr, depth, q);
			if (curr.left != null ) {
				q.push(curr.left);
				collectBreathFirst(curr, depth+1, q);
			}
			if (curr.right != null ) {
				q.push(curr.right);
				collectBreathFirst(curr, depth+1, q);
			}
		}
		else if (depth == 0){
			Tuple t = new Tuple(curr.value, 1);
			data.add(t);
			if (curr.left != null ) q.push(curr.left);
			if (curr.right != null ) q.push(curr.right);
			collectBreathFirst(curr, depth+1, q);
		}
		return;
	}
	
	public double[] avgFromTuple(List<Tuple> data) {
		double[] avgs = new double[data.size()];
		for (int i=0; i<avgs.length; i++) {
			Tuple t = data.get(i);
			avgs[i] = t.a / (t.b *(1.0));
		}
		return avgs;
	}
}

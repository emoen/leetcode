package technical.trees;

import java.util.LinkedList;

import datastructure.Node;

public class NumberOfVisibleNodes {
	public static void main(String[] args) {
		new NumberOfVisibleNodes().toTest();
	}

	public void toTest() {

		Node root_1 = new Node(8);
		root_1.left = new Node(3);
		root_1.right = new Node(10);
		root_1.left.left = new Node(1);
		root_1.left.right = new Node(6);
		root_1.right.right = new Node(14);
		root_1.left.right.left = new Node(4);
		root_1.left.right.right = new Node(7);
		root_1.right.right.left = new Node(13);
		int expected_1 = 4;
		int output_1 = visibleNodes(root_1);
		System.out.print(expected_1+" ");
		System.out.println(output_1);

		Node root_2 = new Node(10);
		root_2.left = new Node(8);
		root_2.right = new Node(15);
		root_2.left.left = new Node(4);
		root_2.left.left.right = new Node(5);
		root_2.left.left.right.right = new Node(6);
		root_2.right.left = new Node(14);
		root_2.right.right = new Node(16);

		int expected_2 = 5;
		int output_2 = visibleNodes(root_2);
		System.out.print(expected_2+" ");
		System.out.println(output_2);
		
	    Node root_3 = new Node(10); 
	    root_3.left = new Node(8);
	    root_3.right = new Node(15);
	    root_3.left.left = new Node(4);
	    root_3.left.left.right = new Node(5);
	    root_3.left.left.right.right = new Node(6);
	    root_3.right.left = new Node(14);
	    root_3.right.right = new Node(16);
	    root_3.right.right.right = new Node(16);
	    root_3.right.right.right.right = new Node(16);
	    root_3.right.right.right.right.right = new Node(16);
	    
	    int expected_3 = 6;
	    int output_3 = visibleNodes(root_3);
		System.out.print(expected_3+" ");
		System.out.println(output_3);
		
		Node root4 = new Node(5); 
		root4.left = new Node(3);
		root4.right = new Node(10);
		root4.left.left = new Node(20);
		root4.left.right = new Node(21);
		root4.right.left = new Node(1);
		
	    int expected_4 = 3;
	    int output_4 = visibleNodes(root4);
		System.out.print(expected_4+" ");
		System.out.println(output_4);
	}

	
	public void traverseBreath(int depth) {
		if (depth>max) max=depth;
		if(!queue.isEmpty()) {
			Node next = queue.getFirst();
			queue.removeFirst();
			traverseBreath(depth);
			if (queue.isEmpty()) depth++;
			if (next.left!= null) {
				queue.add(next.left);
			}
			if (next.right != null) { 
				queue.add(next.right);
			}
			traverseBreath(depth);	
		}
		return;
	}
	public void traverseDepth(Node curr, int depth) {
		if (depth>max)max=depth;
		if(curr.left!= null) traverseDepth(curr.left, depth+1);
		if(curr.right!= null) traverseDepth(curr.right, depth+1);
	}
	private LinkedList<Node> queue = new LinkedList<Node>();
	private int max = 0;
	public int visibleNodes(Node root) {
		// Write your code here
		if (root== null) return 0;
		if (root.left != null)
			queue.add(root.left);
		if (root.right != null)
			queue.add(root.right);
		int depth = 1;max = 0;
		traverseBreath(depth);
		System.out.println("breath max:"+max);
		max=0;depth=1;
		traverseDepth(root, depth);
		return max;
	}
}

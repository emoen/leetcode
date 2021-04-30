package technical.trees;

import java.util.ArrayList;
import java.util.List;

public class NodesInASubtree {
	public static void main(String[] args) {
		new NodesInASubtree().toTest();
	}
	
	void printIntegerArray(int[] arr) {
		int len = arr.length;
		System.out.print("[");
		for (int i = 0; i < len; i++) {
			if (i != 0) {
				System.out.print(", ");
			}
			System.out.print(arr[i]);
		}
		System.out.print("]");
	}
	
	public void toTest() {
	    int n_1 = 3, q_1 = 1;
	    String s_1 = "aba";
	    Node root_1 = new Node(1); 
	    root_1.children.add(new Node(2)); 
	    root_1.children.add(new Node(3)); 
	    ArrayList<Query> queries_1 = new ArrayList<>();
	    queries_1.add(new Query(1, 'a'));
//	    int[] output_1 = countOfNodes(root_1, queries_1, s_1); 
//	    int[] expected_1 = {2};
//	    printIntegerArray(expected_1);
//	    System.out.print(" ");
//	    printIntegerArray(output_1);
//	    System.out.println();
	    
	    // Testcase 2
	    int n_2 = 7, q_2 = 3;
	    String s_2 = "abaacab";
	    Node root_2 = new Node(1); 
	    root_2.children.add(new Node(2)); 
	    root_2.children.add(new Node(3)); 
	    root_2.children.add(new Node(7)); 
	    root_2.children.get(0).children.add(new Node(4));
	    root_2.children.get(0).children.add(new Node(5)); 
	    root_2.children.get(1).children.add(new Node(6));
	    ArrayList<Query> queries_2 = new ArrayList<>();
	    queries_2.add(new Query(1, 'a'));
	    queries_2.add(new Query(2, 'b'));
	    queries_2.add(new Query(3, 'a'));
	    int[] output_2 = countOfNodes(root_2, queries_2, s_2); 
	    int[] expected_2 = {4, 1, 2};
	    printIntegerArray(expected_2);
	    System.out.print(" ");
	    printIntegerArray(output_2);
	    System.out.println();
	}
	  // Tree Node 
	  class Node {
	    public int val;
	    public List<Node> children;
	  
	    public Node() {
	      val = 0;
	      children = new ArrayList<Node>();
	    }
	  
	    public Node(int _val) {
	      val = _val;
	      children = new ArrayList<Node>();
	    }
	  
	    public Node(int _val, ArrayList<Node> _children) {
	      val = _val;
	      children = _children;
	    }
	  }

	  class Query {
	    int u; 
	    char c; 
	    Query(int u, char c) {
	      this.u = u; 
	      this.c = c;
	    }
	  }
	  
	  public void traverseSubstring(Node curr, Query q, String s) {
		  List<Node> child = curr.children;
		  for(int i=0;i<child.size();i++) {
			  Node cld = child.get(i);
			  if (q.c == s.charAt(cld.val-1)) 
				  count++;
			  traverseSubstring(cld, q, s);
		  }
	  }
	  
	  public void traverseDepth(Node curr, Query q, String s) {
		  if (q.u == curr.val) {
			  count++;
			  traverseSubstring(curr, q, s);
		  } else if(curr.children.size()>0) {
			  List<Node> child = curr.children;
			  for(int i=0; i<child.size();i++) {
				  traverseDepth(child.get(i), q, s);
			  }
		  }
	  }
	  
	  int count = 0;
	  int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
		    // Write your code here
		  int n = queries.size();
		  int[] answer = new int[n];
		  for (int i=0; i<queries.size();i++) {
			  count = 0;
			  traverseDepth(root, queries.get(i), s);
			  answer[i] = count;
			  count=0;
		  }
		  return answer;
	  }
}

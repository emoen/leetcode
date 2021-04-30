package technical.linkedlist;

import java.util.LinkedList;

public class ReverseOperations {
	public static void main(String[] args) {
		new ReverseOperations().toTest();
	}

	class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
			next = null;
		}
	}

	public void toTest() {
		int[] arr_1 = { 1, 2, 8, 9, 12, 16 };
		int[] expected1 = { 1, 8, 2, 9, 16, 12 };
		Node head_1 = createLinkedList(arr_1);
		Node expected_1 = createLinkedList(expected1);
		Node output_1 = reverse(head_1);

		printLinkedList(expected_1);
		System.out.println("");
		printLinkedList( output_1);
		System.out.println("**");

		int[] arr_2 = { 2, 18, 24, 3, 5, 7, 9, 6, 12 };
		int[] expected2 = { 24, 18, 2, 3, 5, 7, 9, 12, 6 };
		Node head_2 = createLinkedList(arr_2);
		Node expected_2 = createLinkedList(expected2);
		Node output_2 = reverse(head_2);
		printLinkedList(expected_2);
		System.out.println("");
		printLinkedList( output_2);
	}
	
	public void swap(Node curr, Node next) {
		int tmp = curr.data;
		curr.data = next.data;
		next.data = tmp;
	}

	// time =O(n^2) space O(n)
	Node reverse(Node head) {
		LinkedList<Node> stack = new LinkedList<Node>();
		Node curr = head;
		while(curr!=null) {
			if (curr.data % 2==0) {
				stack.add(curr);
				Node next = curr.next;
				while(next != null && next.data%2==0) {
					stack.add(next);
					next = next.next;
				}
				next = stack.pollLast();
				while( !stack.isEmpty()) {
					swap(curr, next);
					curr = curr.next;
					next = stack.pollLast();
				}
			}
			curr=curr.next;
		}
		return head;
	}

	void printLinkedList(Node head) {
		System.out.print("[");
		while (head != null) {
			System.out.print(head.data);
			head = head.next;
			if (head != null)
				System.out.print(" ");
		}
		System.out.print("]");
	}

	Node createLinkedList(int[] arr) {
		Node head = null;
		Node tempHead = head;
		for (int v : arr) {
			if (head == null) {
				head = new Node(v);
				tempHead = head;
			} else {
				head.next = new Node(v);
				head = head.next;
			}
		}
		return tempHead;
	}
}

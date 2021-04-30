package technical.queue;

import java.util.LinkedList;

public class QueueRemoval {
	public static void main(String[] args) {
		new QueueRemoval().toTest();
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
		System.out.println("]");
	}

	public void toTest() {
		int n_1 = 6;
		int x_1 = 5;
		int[] arr_1 = { 1, 2, 2, 3, 4, 5 };
		int[] expected_1 = { 5, 6, 4, 1, 2 };
//		int[] output_1 = findPositions(arr_1, x_1);
//		System.out.println();
//		printIntegerArray(expected_1);
//		printIntegerArray(output_1);

		int n_2 = 13;
		int x_2 = 4;
		int[] arr_2 = { 2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4 };
		int[] expected_2 = { 2, 5, 10, 13 };
		int[] output_2 = findPositions(arr_2, x_2);
		printIntegerArray(expected_2);
		printIntegerArray(output_2);
	}
	
	class Tuple{
		public int val; public int idx;
		public Tuple(int v, int i) { this.val = v; this.idx=i;}
	}

	
	int[] findPositions(int[] arr, int x) {
		// Write your code here
		int n = arr.length;
		int[] positions = new int[x];
		LinkedList<Tuple> queue = new LinkedList<Tuple>();
		for(int i=0;i<arr.length;i++) {
			queue.add(new Tuple(arr[i], i));
		}
		LinkedList<Tuple> popped = new LinkedList<Tuple>();
		Tuple max = new Tuple(-1,0);
		int newIdxForMax = -1;
		int popCount = 0;
		while (popCount < x) {
			max = new Tuple(-1,0);
			int qSize = queue.size();
			for(int i=0;i<x && i<qSize;i++) {
				Tuple t = queue.poll();
				if (t.val > max.val) {
					max = new Tuple(t.val, t.idx);
					newIdxForMax=i;
				}
				if (t.val>0) t.val = t.val-1;
				popped.add(t);
			}
			positions[popCount] = popped.get(newIdxForMax).idx+1;
			popped.remove(newIdxForMax);
			while(!popped.isEmpty())
				queue.add(popped.poll());

			popCount++;
		}
		return positions;
	}
}

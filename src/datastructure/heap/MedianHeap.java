package datastructure.heap;

public class MedianHeap {
	    private Integer[] a;
	    private int N;

	    public MedianHeap(int capacity){
	        this.a = new Integer[capacity+1];// accounts for '0' not being used 
	        this.N = 0;
	    }

	    public void insert(int k) {
	        a[++N] = k;
	        swim(N);
	    }

	    public int delMedian(){
	        int median = findMedian();
	        exch(1, N--);
	        sink(1);
	        a[N+1] = null;
	        return median;
	    }

	    public int findMedian() { 
	    	if (N % 2 == 0) return Math.floorDiv(a[1]+a[2],2);
	    	else return a[1];
		}

	    private void swim(int k){ //entry swims up so that its left child is smaller and right is greater
	    	while(even(k) && k>1 && less(k/2,k)) { 
	            exch(k, k/2);
	            if ((N > k) && less (k+1, k/2)) exch(k+1, k/2);
	            k = k/2;
	        }
	        while(!even(k) && (k>1 && !less(k/2,k))){
	            exch(k, k/2);
	            if (!less (k-1, k/2)) exch(k-1, k/2);
	            k = k/2;
	        }
	    }

	    private void sink (int k){ //if the left child is larger or if the right child is smaller, the entry sinks down
	        while(2*k <= N){
	            int j = 2*k;
	            if (j < N && less (j, k)) j++;
	            if (less(k,j)) break;
	            exch(k, j);
	            k = j;
	        }
	    }

	    private boolean even(int i){
	        if ((i%2) == 0) return true;
	        else return false;
	    }

	    private void exch(int i, int j){
	        int temp = a[i];
	        a[i] = a[j];
	        a[j] = temp;
	    }

	    private boolean less(int i, int j){
	        if (a[i] <= a[j]) return true;
	        else return false;
	    }
	    
	    public static void main(String[] args) {
	    	MedianHeap medianInsertDelete = new MedianHeap(10);
	        for(int i = 1; i <=10; i++){
	            medianInsertDelete.insert(i);
	        }
	        System.out.println("The median is: " + medianInsertDelete.findMedian());
	        medianInsertDelete.delMedian();
	        System.out.println("Original median deleted. The new median is " + medianInsertDelete.findMedian());
	    }
}

package leetcode;

public class AddTwoSums {
	
	public static void main(String[] args) {
		//(pp+qq + carry)/10
//		System.out.println((9+2)/10);
		new AddTwoSums().doTest();
	}
	
	public void doTest() {
		//l1 = [2,4,3];
		ListNode l1 = new ListNode(2);
		ListNode r1 = l1;
		l1.next = new ListNode(4);
		l1 = l1.next;
		l1.next = new ListNode(3);
		
		//l2 = [5,6,4];
		ListNode l2 = new ListNode(5);
		ListNode r2 = l2;
		l2.next = new ListNode(6);
		l2 = l2.next;
		l2.next = new ListNode(4);
		
		//ListNode t = addTwoNumbers(r1, r2);
		
		//[2,4,9]
		l1 = new ListNode(2);
		r1 = l1;
		l1.next = new ListNode(4);
		l1 = l1.next;
		l1.next = new ListNode(9);
		
		//[5,6,4,9]
		l2 = new ListNode(5);
		r2 = l2;
		l2.next = new ListNode(6);
		l2 = l2.next;
		l2.next = new ListNode(4);
		l2 = l2.next;
		l2.next = new ListNode(9);
		
		//ListNode t = addTwoNumbers(r1, r2);
		

		//[9]
		//[1,9,9,9,9,9,9,9,9,9]
		l1 = new ListNode(9);
		r1 = l1;
		
		//[5,6,4,9]
		l2 = new ListNode(1);
		r2 = l2;
		l2.next = new ListNode(9);
		l2 = l2.next;
		l2.next = new ListNode(9);
		l2 = l2.next;
		l2.next = new ListNode(9);
		l2 = l2.next;
		l2.next = new ListNode(9);
		l2 = l2.next;
		l2.next = new ListNode(9);
		l2 = l2.next;
		l2.next = new ListNode(9);
		l2 = l2.next;
		l2.next = new ListNode(9);
		l2 = l2.next;
		l2.next = new ListNode(9);
		l2 = l2.next;
		l2.next = new ListNode(9);
		
		ListNode t = addTwoNumbers(r1, r2);
		System.out.println(t);
		while (t != null) {
			System.out.print(t.val);
			t = t.next;
		}

	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry=0;
        int i=0;
        while (p != null || q != null) {
        	int pp=0;
        	if (p != null) {pp = p.val; p = p.next;}
        	int qq=0;
        	if (q != null) {qq = q.val; q = q.next; }
        	
        	int sum = pp+qq+carry;
        	if ( i>0) curr = curr.next;
        	curr.val = sum % 10;
        	curr.next = new ListNode(0);
        	if ( (pp + qq + carry) / 10 > 0) {
        		carry = ( sum / 10);
        	} else carry=0;
        	i++;

        }
        if (carry > 0)
        	curr.next.val = carry;
        else curr.next = null;
        return dummyHead;
    }
}

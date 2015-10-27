 public class ListNode {
   int val;
   ListNode next;

   ListNode(int x) {
		 val = x;
	 }

	 public static ListNode create(int[] A) {
		 ListNode head = new ListNode(0);
		 ListNode p = head;

		 for (int n : A) {
			 p.next = new ListNode(n);
			 p = p.next;
		 }

		 return head.next;
	 }

	 public static void print(ListNode head) {
		 System.out.print("[ ");
		 while (head != null) {
			 System.out.print(head.val + " ");
			 head = head.next;
		 }
		 System.out.println("]");
	 }
 }


//leetcode submit region begin(Prohibit modification and deletion)

//Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution{
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p3 = head.next.next;

        p2.next = p1;

        p1.next = swapPairs(p3);

        return p2;

    }
}
//leetcode submit region end(Prohibit modification and deletion)



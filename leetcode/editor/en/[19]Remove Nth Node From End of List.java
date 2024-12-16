
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 寫法1.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode x = findFromEnd(dummy,n+1);

        x.next = x.next.next;
        return dummy.next;



    }

    ListNode findFromEnd(ListNode head , int k){
        ListNode p1 = head;

        // p1先走k步
        for(int i = 0 ; i<k;i++){
            p1=p1.next;
        }

        ListNode p2 = head;
        // p1和p2同時往前n-k步,p1會先走到最尾
        while(p1 !=null){
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2現在指向 n-k+1的節點,即倒數第k的節點
        return p2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

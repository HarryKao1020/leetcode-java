
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int skipA = 0;
        int skipB = 0;

//        ListNode intersectVal  = new ListNode(0);
//
//        if()
        ListNode p1 = headA , p2 = headB;
        while(p1 != p2){
            if(p1 == null){
                p1 = headB;
            }else{
                p1=p1.next;
            }
            if(p2 == null){
                p2 = headA;
            }else{
                p2 = p2.next;
            }
        }
        return p1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
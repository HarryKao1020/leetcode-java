
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
        if(headA == null || headB==null){
            return null;
        }
        // 建立兩個虛擬的ListNode
        ListNode p1 = headA,p2=headB;

        while(p1 != p2){

            // 如果p1 == null ,代表遍歷完ListA
            if(p1 ==null){
                p1= headB;
            }else{
                p1=p1.next;
            }

            // 如果p2 == null ,代表遍歷完ListB了
            if(p2 == null){
                p2=headA;
            }else{
                p2=p2.next;
            }

            // 簡寫
//            p1 = p1 == null? headB : p1.next;
//            p2 = p2 == null? headA : p2.next;
        }
        return p1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

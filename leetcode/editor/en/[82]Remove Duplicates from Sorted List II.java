
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
    public ListNode deleteDuplicates(ListNode head) {
        // 將list分成兩個linkedlist,一個放不重複的,一個放重複的,題目說node.val <=100,所以用101當虛擬頭節點
        ListNode dummyUniq = new ListNode(101);
        ListNode dummyDup = new ListNode(101);

        // 定義兩個list的頭點
        ListNode pUniq = dummyUniq , pDup = dummyDup;

        ListNode p = head;

        while (p != null){
            if((p.next !=null && p.val == p.next.val) || p.val == pDup.val){
                pDup.next = p;
                pDup = pDup.next;
            }else{
                pUniq.next = p ;
                pUniq = pUniq.next;
            }

            p = p.next;

            pUniq.next = null;
            pDup.next = null;
        }
        return dummyUniq.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

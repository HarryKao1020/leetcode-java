
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
    public ListNode partition(ListNode head, int x) {
        ListNode large = new ListNode(-1);
        ListNode small = new ListNode(-1);
        ListNode largeHead = large , smallHead = small;

        ListNode p = head;

        while(p!=null){
            if(p.val >= x){
                largeHead.next = p;
                largeHead = largeHead.next;
            }else {
                smallHead.next = p;
                smallHead = smallHead.next;
            }
//            p = p.next;
//            不能直接讓p指針前進,p=p.next
//            斷開原鍊表中的每個節點的next指針
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        smallHead.next = large.next;
        return small.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

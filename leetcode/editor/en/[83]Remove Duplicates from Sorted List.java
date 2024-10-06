
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
        ListNode dummy = new ListNode(0,head);
        while(head!=null && head.next!=null){
            if(head.val == head.next.val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
[1,1,2]
1.
    head!=null
    head.val = 1
    head.next.val = 1
    1=1 true
        head.next = head.next.next
        head.next = 2
        1  -->    2
       head --> head.next

2.
    head!=null head.next!=null : true
    head.val = 1
    head.next =2
    1 != 2 false
        head = head.next
        head = 2
3
    head != null && head.next !=null : false
    return dummy.next



 */
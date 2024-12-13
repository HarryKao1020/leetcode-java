
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        // 虛擬頭節點
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        // priority minHeap
        // lists.length:設定pq的初始化容量; (a,b) ->(a.val-b.val) : 這是一個比較器,如果a.val-b.val小於0,表示a小於b,這樣就是一個升序排列
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length,(a,b) ->(a.val - b.val)
        );

        // 將k個鍊表的頭點加入minHeap
        for(ListNode head : lists){
            if(head !=null){
                pq.offer(head);
            }
        }
        // pq : [1 , 1 , 2] :每個List的head都加進去後做heap排序,第一個元素一定是最小值

        while(!pq.isEmpty()){
            // 獲得最小的頭節點,接到結果鏈表中
            ListNode node = pq.poll();
            p.next = node;

            // node非最後一個,繼續跑
            if(node.next != null){
                pq.offer(node.next);

            }
            p = p.next;
        }

        return dummy.next;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

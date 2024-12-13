# Merge k Sorted Lists(Hard)

## 題目:
### 給一個陣列的linkedlist, linkedlist都已經升序排列了
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
1->4->5,
1->3->4,
2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

## 思考
1. 怎麼快速得出所有list中最小節點？ 用priority queue

## code
```java

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

```
## 圖解
[[1,4,5],[1,3,4],[2,6]] 

第一個for,把每個Lists的第一個node加進pq: 
pq: [1 , 1 ,2] 

第二個while
1. node = pq.poll() --> 把 1 取出來
2. p.next = node --> 把這個1 接到我們結果的鏈表 , p = [-1 --> 1 --> 4 --> 5 --> null]
3. if(node.next != null ), 這個node.next是第一個List的第二個 : 4
4. pq.offer(node.next) , 把4放入pq , pq[1,2,4]
5. p = p.next --> p=1

執行第二次while
1. node = pq.poll() -- > 把1取出來
2. p.next = node --> 把1接到結果 p=[-1,1,1]
3. node.next != null , node.next是3
4. pq.offer(node.next) ,把3放進去 , pq[2,4,3]
5. p = p.next --> p =1

執行第三次while 
1. node = pq.poll() -- > 把2取出來 
2. p.next = node --> 把1接到結果 p=[-1,1,1,2] 
3. node.next != null , node.next是6 
4. pq.offer(node.next) ,把6放進去 , pq=[3,4,6] , pq會自動把最小的排到最前面 
5. p = p.next --> p = 2 

執行第四次while 
1. node = pq.poll() -- > 把3取出來 
2. p.next = node --> 把1接到結果 p=[-1,1,1,2,3] 
3. node.next != null , node.next是4
4. pq.offer(node.next) ,把4放進去 , pq=[4,6,4] 
5. p = p.next --> p = 3

.....以此類推

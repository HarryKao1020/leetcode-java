# 86:Partition List

## 題目:
給定一個List, x為某節點,將小於x的node放在一個List,  
比x大或等於x的放在另一個List,  
最終將兩個List合併成一個List,大的排在小的後面

### ex:
原始List:[1,4,3,2,5,2], x = 3  
List1 = [1,2,2] --> 都比3小  
List2 = [4,3,5] --> 都大於等於3  

## 解題：
這邊一樣用虛擬頭節點  
因為一個List拆成兩個List
所以有兩個虛擬頭

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

```

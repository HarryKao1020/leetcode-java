# 141 Linked List Cycle

## 思路:
使用雙指針
```text
Input: 
head = [3,2,0,-4],
pos = 1 
Output: true 
Explanation: 
There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

```
```text
一個快指針跟一個慢指針
fast = head;
slow = head;

1. 
- fast = 3
- slow = 3

2. 進入判斷fast是不是null跟fast.next是不是null,是null就是return false.
while(fast !=null && fast.next !=null){
}
return false;

3. 進入第一次迴圈
slow = slow.next --> slow = 2
fast = fast.next.next --> fast = 0

4. 進入第二次迴圈
slow = 0
fast = fast.next.next
如果這邊fast.next.next = null ,因為這邊已經代表tail.next =null
代表tail.next沒有接回某個節點,沒有形成cycle
如果fast.next.next有值進入第三次

5. 第三次迴圈
slow = -4
fast = pos, 隨便一個點都可以 我們就用範例的接到第二個節點pos = 1
fast = 2

6. 第四次
slow = 2
fast = -4

7. 第五次
slow = 0
fast = 0

slow = fast 
turn true;
```



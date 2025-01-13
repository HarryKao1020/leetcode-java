# 876 Middle of the Linked List
## 題目
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

Example 1:


Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:  
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4,  
we return the second one.

## 思路
- 用快慢指針
- 慢指針一次走一步,快指針一次往前走兩步
- 當快指針走到尾,慢指針就會指到中間的node
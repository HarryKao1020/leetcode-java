# 24.Swap Nodes in Pairs

## 題目:

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Example 1:

Input: head = [1,2,3,4]

Output: [2,1,4,3]

---
## 解題思路

- 題目理解: 每兩個(每一隊pair)做交換 
- 所以[1,2,3,4],1跟2互換 , 3跟4互換
- [1,2,3],1跟2互換,3不動,因為3.next是null

可以用Recursion來做,如果head.next!=null就要交換

如果head.next = null , 像[1,2,3],3.next就是null就不動


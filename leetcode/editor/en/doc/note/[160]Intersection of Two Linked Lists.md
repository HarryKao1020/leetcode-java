# 160-Intersection of Two Linked List

## 題目:
找到兩個linked list相交的點  
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3 Output: Intersected at '8'

## 解題思路:
- 設定兩個指針p1,p2
- 讓p1開始跑ListA,跑完ListA再跑ListB,
- 讓p2也同時跑ListB,跑完再跑ListA
- 兩者最後碰在一起的點就是相交的點

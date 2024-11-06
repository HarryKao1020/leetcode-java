# 100 Conevert Sorted Array to Binary Search Tree

## BST & 平衡樹觀念

BST定義:
1. 左分支必須小於root
2. 右分支必須大於root

平衡樹:
1. 左右分支的深度相差不超過1

## 題目了解
1. 已經給定一個升序排列的nums陣列
2. 取得原始陣列的中位數(中間) , 把他設成root, 這樣就可以確定好中位數左邊都是屬於左邊,大於的都是右邊樹

## 解題
nums= [-10,-3,0,5,9]

1. 第一次調用helper(nums,0,4)
```text
    left = 0 , right =4
    mid = 2
    nums[2] = 0 --> root

```
```text
    此時樹為:
       0
```

2. 進到處理左子樹 root.left
```text
    left = 0 , right = mid-1 = 1 
    root.left = helper(nums , 0 , 1)
    
    mid = 0 +1 /2 = 0
    nums[0] = -10 --> root
    
    進到root.left=helper(nums , 0 , -1) , 
    但因爲left>right 所以return null; 然後接下跑root.right
    
```
```text
此時樹：
    0
   /
  -10  
```
3. 左子樹裡面去處理右子樹 root.right
```text
left = 0 , right = 1
root.right = helper(nums, 0+1 , 1)
mid = 1+1/2 = 1
nums[1] = -3 --> root

root.left = helper(nums, 0 , 0); --> return null;
root.right = helper(nums, 2, 1 ) --> return null;
```
```text
      0
    /  
  -10   
     \
     -3   
```

4. 處理右子樹
```text
left = 0 , right = nums.legth-1 = 4
mid = 2
root.right = helper(nums, 3, 4);
```
5. root.right = helper(nums,3,4)
```text
mid = 7/2 = 3
root = nums[3] = 5

進去 root.left = helper(nums, 3 , 2)
```
樹
```text
      0
    /   \
  -10    5
     \
     -3   
    
```

6. 進入右子樹的左子樹 root.left = helper(nums,3,2)
```text
retrun null;
```

7. 進入右子樹的右子樹 root.right = helper(nums,4,4)
```text
mid = 8/2 = 4
root = nums[4] = 9
進入 root.left = helper(nums,4,3) --> return null;
進入 root.right = helper(nums,5,4) --> return null;
結束
```
樹
```text
      0
    /   \
  -10    5
     \    \
     -3    9
    
```


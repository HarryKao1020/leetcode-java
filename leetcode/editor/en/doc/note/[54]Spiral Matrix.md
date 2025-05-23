# 54 螺旋矩陣

```text
1. 從左到右遍歷上邊界
for(int j = left_bound ; j<= right_bound; j++)

j = 0 , j<=3 ==> res.add(matrix[0][0]) 1
j = 1 , 1<=3 ==> res.add(matrix[0][1]) 2
j = 2 , 2 <= 3 ==> res.add(matrix[0][2]) 3
j = 3 , 3 <= 3 ==> res.add(matrix[0][3]) 4
跳出迴圈 upper_bound++ => 1 <=2
j= 0 , j <= 3 ==> res.add(matrix[1][0])
j=1 , j <=3 ==> res.add(matrix[1][1])


2. 從上
```
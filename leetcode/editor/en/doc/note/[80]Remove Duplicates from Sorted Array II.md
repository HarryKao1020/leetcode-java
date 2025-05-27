# 80. Remove Duplicates from Sorted Array II
## 解題：雙指針
### 題目:
输入：nums = [1,1,1,2,2,3]  
输出：5, nums = [1,1,2,2,3]  
解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
```text
count=0; // 用來記錄重複的次數
slow=0 , fast=0 ; //紀錄快滿指針

nums=[1,1,1,2,2,3]


if(num[fast] != nums[slow]){
    slow++;
    nums[slow] = nums[fast];
}else{
    count++;
    fast++;
    if(count >=2){
        
    }else{
        
    }
    
}

//=============
while 第一次
nums[0] = nums[0]
count=1
fast=1


//=====
while第二次
nums[1] == nums[1]





```
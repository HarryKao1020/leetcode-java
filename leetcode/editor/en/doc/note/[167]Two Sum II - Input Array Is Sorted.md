# Two Sum || 
他是以排序的數組,跟Two Sum不同  

### Two Sum可以用hashmap解 
- 時間複雜度:O(n)
- 空間複雜度:O(n)

### Two Sum || 用雙指針(左右)
- 時間複雜度:O(n)
- 空間複雜度:O(1)
這個解法非常適合已排序數組，因為：
1. 不需要額外的存儲空間（除了結果數組）
2. 充分利用了數組已排序的特性
3. 每次都能排除部分搜索空間，非常高效

如果題目沒有給出排序數組，那麼 hashmap 解法會更適合，因為排序需要 O(nlogn) 的時間。但在這題中，雙指針是最優解。

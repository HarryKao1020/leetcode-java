

思路解析  
這個問題可以通過兩個步驟來解決：

1. 先沿對角線翻轉（transpose 轉置）：將矩陣 (i,j) 和 (j,i) 位置的元素交換
2. 再水平翻轉（左右翻轉）：將每一行的元素左右翻轉

這兩步相當於完成了順時針旋轉 90 度的效果。

圖解過程
```text
以 3×3 矩陣為例：

1 2 3      1 4 7      7 4 1
4 5 6  =>  2 5 8  =>  8 5 2  (最終結果)
7 8 9      3 6 9      9 6 3
```
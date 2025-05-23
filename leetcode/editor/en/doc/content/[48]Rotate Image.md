<p>You are given an <code>n x n</code> 2D <code>matrix</code> representing an image, rotate the image by <strong>90</strong> degrees (clockwise).</p>

<p>You have to rotate the image <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a>, which means you have to modify the input 2D matrix directly. <strong>DO NOT</strong> allocate another 2D matrix and do the rotation.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/mat1.jpg" style="width: 500px; height: 188px;" /> 
<pre>
<strong>Input:</strong> matrix = [[1,2,3],[4,5,6],[7,8,9]]
<strong>Output:</strong> [[7,4,1],[8,5,2],[9,6,3]]
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/mat2.jpg" style="width: 500px; height: 201px;" /> 
<pre>
<strong>Input:</strong> matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
<strong>Output:</strong> [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>n == matrix.length == matrix[i].length</code></li> 
 <li><code>1 &lt;= n &lt;= 20</code></li> 
 <li><code>-1000 &lt;= matrix[i][j] &lt;= 1000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Math | Matrix</details><br>

<div>👍 18644, 👎 894<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/practice-in-action/2d-array-traversal-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题看起来复杂，但只要掌握了规律就很简单。

先把二维矩阵沿对角线反转，然后反转矩阵的每一行，结果就是顺时针反转整个矩阵。

**详细题解**：
  - [二维数组的花式遍历技巧](https://labuladong.online/algo/practice-in-action/2d-array-traversal-summary/)

</div>





<div id="solution">

## 解法代码



<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        // 先沿对角线反转二维矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // swap(matrix[i][j], matrix[j][i]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 然后反转二维矩阵的每一行
        for (auto& row : matrix) {
            ::reverse(row.begin(), row.end());
        }
    }

    // 反转一维数组
    void reverse(vector<int>& arr) {
        int i = 0, j = arr.size() - 1;
        while (j > i) {
            // swap(arr[i], arr[j]);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def rotate(self, matrix):
        n = len(matrix)
        # 先沿对角线反转二维矩阵
        for i in range(n):
            for j in range(i, n):
                # swap(matrix[i][j], matrix[j][i])
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        
        # 然后反转二维矩阵的每一行
        for row in matrix:
            self.reverse(row)

    # 反转一维数组
    def reverse(self, arr):
        i, j = 0, len(arr) - 1
        while j > i:
            # swap(arr[i], arr[j])
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j -= 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 先沿对角线反转二维矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // swap(matrix[i][j], matrix[j][i]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 然后反转二维矩阵的每一行
        for (int[] row : matrix) {
            reverse(row);
        }
    }

    // 反转一维数组
    void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (j > i) {
            // swap(arr[i], arr[j]);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func rotate(matrix [][]int) {
    n := len(matrix)
    // 先沿对角线反转二维矩阵
    for i := 0; i < n; i++ {
        for j := i; j < n; j++ {
            // swap(matrix[i][j], matrix[j][i]);
            matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        }
    }
    // 然后反转二维矩阵的每一行
    for i := range matrix {
        reverse(matrix[i])
    }
}

// 反转一维数组
func reverse(arr []int) {
    i, j := 0, len(arr)-1
    for j > i {
        // swap(arr[i], arr[j]);
        arr[i], arr[j] = arr[j], arr[i]
        i++
        j--
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var rotate = function(matrix) {
    let n = matrix.length;
    // 先沿对角线反转二维矩阵
    for (let i = 0; i < n; i++) {
        for (let j = i; j < n; j++) {
            // swap(matrix[i][j], matrix[j][i]);
            let temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
    // 然后反转二维矩阵的每一行
    for (let row of matrix) {
        reverse(row);
    }

    // 反转一维数组
    function reverse(arr) {
        let i = 0, j = arr.length - 1;
        while (j > i) {
            // swap(arr[i], arr[j]);
            let temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_rotate-image" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_rotate-image"></div></div>
</details><hr /><br />

</div>
</details>
</div>


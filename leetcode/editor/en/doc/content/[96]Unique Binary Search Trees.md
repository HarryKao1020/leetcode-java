<p>Given an integer <code>n</code>, return <em>the number of structurally unique <strong>BST'</strong>s (binary search trees) which has exactly </em><code>n</code><em> nodes of unique values from</em> <code>1</code> <em>to</em> <code>n</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/uniquebstn3.jpg" style="width: 600px; height: 148px;" /> 
<pre>
<strong>Input:</strong> n = 3
<strong>Output:</strong> 5
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 19</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Math | Dynamic Programming | Tree | Binary Search Tree | Binary Tree</details><br>

<div>👍 10483, 👎 414<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/data-structure/bst-part3/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

假设给算法输入 `n = 5`，也就是说用 `{1,2,3,4,5}` 这些数字去构造 BST。

如果固定 `3` 作为根节点，左子树节点就是 `{1,2}` 的组合，右子树就是 `{4,5}` 的组合：

![](https://labuladong.online/algo/images/bst-iii/1.jpeg)

那么 `{1,2}` 和 `{4,5}` 的组合有多少种呢？只要合理定义递归函数，这些可以交给递归函数去做。

另外，这题存在重叠子问题，可以通过备忘录的方式消除冗余计算。

**详细题解**：
  - [二叉搜索树心法（构造篇）](https://labuladong.online/algo/data-structure/bst-part3/)

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
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

#include <vector>

class Solution {
public:
    // 备忘录
    std::vector<std::vector<int>> memo;

    int numTrees(int n) {
        // 备忘录的值初始化为 0
        memo = std::vector<std::vector<int>>(n + 1, std::vector<int>(n + 1, 0));
        return count(1, n);
    }

private:
    int count(int lo, int hi) {
        if (lo > hi) return 1;
        // 查备忘录
        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }

        int res = 0;
        for (int mid = lo; mid <= hi; mid++) {
            int left = count(lo, mid - 1);
            int right = count(mid + 1, hi);
            res += left * right;
        }
        // 将结果存入备忘录
        memo[lo][hi] = res;

        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    # 备忘录
    def __init__(self):
        self.memo = []

    def numTrees(self, n: int) -> int:
        # 备忘录的值初始化为 0
        self.memo = [[0] * (n + 1) for _ in range(n + 1)]
        return self.count(1, n)

    def count(self, lo: int, hi: int) -> int:
        if lo > hi:
            return 1
        # 查备忘录
        if self.memo[lo][hi] != 0:
            return self.memo[lo][hi]

        res = 0
        for mid in range(lo, hi + 1):
            left = self.count(lo, mid - 1)
            right = self.count(mid + 1, hi)
            res += left * right
        # 将结果存入备忘录
        self.memo[lo][hi] = res

        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 备忘录
    int[][] memo;

    int numTrees(int n) {
        // 备忘录的值初始化为 0
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    int count(int lo, int hi) {
        if (lo > hi) return 1;
        // 查备忘录
        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }

        int res = 0;
        for (int mid = lo; mid <= hi; mid++) {
            int left = count(lo, mid - 1);
            int right = count(mid + 1, hi);
            res += left * right;
        }
        // 将结果存入备忘录
        memo[lo][hi] = res;

        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

func numTrees(n int) int {
    // 备忘录的值初始化为 0
    memo := make([][]int, n+1)
    for i := 0; i <= n; i++ {
        memo[i] = make([]int, n+1)
    }
    return count(1, n, memo)
}

// 二叉搜索树计数函数
// 备忘录
func count(lo int, hi int, memo [][]int) int {
    if lo > hi {
        return 1
    }
    // 查备忘录
    if memo[lo][hi] != 0 {
        return memo[lo][hi]
    }

    res := 0
    for mid := lo; mid <= hi; mid++ {
        left := count(lo, mid-1, memo)
        right := count(mid+1, hi, memo)
        res += left * right
    }
    // 将结果存入备忘录
    memo[lo][hi] = res
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var numTrees = function(n) {
    // 备忘录
    let memo = new Array(n + 1).fill(0).map(() => new Array(n + 1).fill(0));

    // 备忘录的值初始化为 0

    function count(lo, hi) {
        if (lo > hi) return 1;
        // 查备忘录
        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }

        let res = 0;
        for (let mid = lo; mid <= hi; mid++) {
            let left = count(lo, mid - 1);
            let right = count(mid + 1, hi);
            res += left * right;
        }
        // 将结果存入备忘录
        memo[lo][hi] = res;

        return res;
    }
    
    return count(1, n);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_unique-binary-search-trees" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_unique-binary-search-trees"></div></div>
</details><hr /><br />

</div>
</details>
</div>




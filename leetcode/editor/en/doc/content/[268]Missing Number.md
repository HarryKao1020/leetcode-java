<p>Given an array <code>nums</code> containing <code>n</code> distinct numbers in the range <code>[0, n]</code>, return <em>the only number in the range that is missing from the array.</em></p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,0,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [9,6,4,2,3,5,7,0,1]
<strong>Output:</strong> 8
<strong>Explanation:</strong> n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>n == nums.length</code></li> 
 <li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li> 
 <li><code>0 &lt;= nums[i] &lt;= n</code></li> 
 <li>All the numbers of <code>nums</code> are <strong>unique</strong>.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Follow up:</strong> Could you implement a solution using only <code>O(1)</code> extra space complexity and <code>O(n)</code> runtime complexity?</p>

<details><summary><strong>Related Topics</strong></summary>Array | Hash Table | Math | Binary Search | Bit Manipulation | Sorting</details><br>

<div>👍 12471, 👎 3360<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/frequency-interview/bitwise-operation/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

假设 `nums = [0,3,1,4]`：

![](https://labuladong.online/algo/images/missing-elem/1.jpg)

我们先把索引补一位，然后让每个元素和自己相等的索引相对应：

![](https://labuladong.online/algo/images/missing-elem/2.jpg)

这样做了之后，就可以发现除了缺失元素之外，所有的索引和元素都组成一对儿了，现在如果把这个落单的索引 2 找出来，也就找到了缺失的那个元素。

如何找？只要把所有的元素和索引做异或运算，成对儿的数字都会消为 0，只有这个落单的元素会剩下。

**详细题解**：
  - [常用的位操作](https://labuladong.online/algo/frequency-interview/bitwise-operation/)

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
using namespace std;

class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int n = nums.size();
        int res = 0;
        // 先和新补的索引异或一下
        res ^= n;
        // 和其他的元素、索引做异或
        for (int i = 0; i < n; i++)
            res ^= i ^ nums[i];
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
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)
        res = 0
        # 先和新补的索引异或一下
        res ^= n
        # 和其他的元素、索引做异或
        for i in range(n):
            res ^= i ^ nums[i]
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        // 先和新补的索引异或一下
        res ^= n;
        // 和其他的元素、索引做异或
        for (int i = 0; i < n; i++)
            res ^= i ^ nums[i];
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

func missingNumber(nums []int) int {
    n := len(nums)
    res := 0
    // 先和新补的索引异或一下
    res ^= n
    // 和其他的元素、索引做异或
    for i := 0; i < n; i++ {
        res ^= i ^ nums[i]
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var missingNumber = function(nums) {
    let n = nums.length;
    let res = 0;
    // 先和新补的索引异或一下
    res ^= n;
    // 和其他的元素、索引做异或
    for (let i = 0; i < n; i++)
        res ^= i ^ nums[i];
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_missing-number" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_missing-number"></div></div>
</details><hr /><br />

</div>
</details>
</div>


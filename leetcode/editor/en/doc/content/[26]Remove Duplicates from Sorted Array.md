<p>Given an integer array <code>nums</code> sorted in <strong>non-decreasing order</strong>, remove the duplicates <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a> such that each unique element appears only <strong>once</strong>. The <strong>relative order</strong> of the elements should be kept the <strong>same</strong>. Then return <em>the number of unique elements in </em><code>nums</code>.</p>

<p>Consider the number of unique elements of <code>nums</code> to be <code>k</code>, to get accepted, you need to do the following things:</p>

<ul> 
 <li>Change the array <code>nums</code> such that the first <code>k</code> elements of <code>nums</code> contain the unique elements in the order they were present in <code>nums</code> initially. The remaining elements of <code>nums</code> are not important as well as the size of <code>nums</code>.</li> 
 <li>Return <code>k</code>.</li> 
</ul>

<p><strong>Custom Judge:</strong></p>

<p>The judge will test your solution with the following code:</p>

<pre>
int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i &lt; k; i++) {
    assert nums[i] == expectedNums[i];
}
</pre>

<p>If all assertions pass, then your solution will be <strong>accepted</strong>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,2]
<strong>Output:</strong> 2, nums = [1,2,_]
<strong>Explanation:</strong> Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,0,1,1,1,2,2,3,3,4]
<strong>Output:</strong> 5, nums = [0,1,2,3,4,_,_,_,_,_]
<strong>Explanation:</strong> Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>-100 &lt;= nums[i] &lt;= 100</code></li> 
 <li><code>nums</code> is sorted in <strong>non-decreasing</strong> order.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Two Pointers</details><br>

<div>👍 15835, 👎 19360<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/array-two-pointers-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

有序序列去重的通用解法就是我们前文 [双指针技巧](https://labuladong.online/algo/essential-technique/array-two-pointers-summary/) 中的快慢指针技巧。

我们让慢指针 `slow` 走在后面，快指针 `fast` 走在前面探路，找到一个不重复的元素就告诉 `slow` 并让 `slow` 前进一步。这样当 `fast` 指针遍历完整个数组 `nums` 后，**`nums[0..slow]` 就是不重复元素**。

![](https://labuladong.online/algo/images/array-dedup/1.gif)

**详细题解**：
  - [双指针技巧秒杀七道数组题目](https://labuladong.online/algo/essential-technique/array-two-pointers-summary/)

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

#include <vector>
using namespace std;

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.size()) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        slow = 0
        fast = 0
        while fast < len(nums):
            if nums[fast] != nums[slow]:
                slow += 1
                # 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast]
            fast += 1
        # 数组长度为索引 + 1
        return slow + 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func removeDuplicates(nums []int) int {
    if len(nums) == 0 {
        return 0
    }
    slow, fast := 0, 0
    for fast < len(nums) {
        if nums[fast] != nums[slow] {
            slow++
            // 维护 nums[0..slow] 无重复
            nums[slow] = nums[fast]
        }
        fast++
    }
    // 数组长度为索引 + 1
    return slow + 1
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var removeDuplicates = function(nums) {
    if (nums.length === 0) {
        return 0;
    }
    let slow = 0, fast = 0;
    while (fast < nums.length) {
        if (nums[fast] !== nums[slow]) {
            slow++;
            // 维护 nums[0..slow] 无重复
            nums[slow] = nums[fast];
        }
        fast++;
    }
    // 数组长度为索引 + 1
    return slow + 1;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_remove-duplicates-from-sorted-array" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-duplicates-from-sorted-array"></div></div>
</details><hr /><br />

</div>
</details>
</div>






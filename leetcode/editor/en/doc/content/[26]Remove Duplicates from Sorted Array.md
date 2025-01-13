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

**通知：[网站会员](https://labuladong.online/algo/intro/site-vip/) 即将涨价，有需要可以尽快购买/续费，谢谢大家的支持~**



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

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_remove-duplicates-from-sorted-array" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-duplicates-from-sorted-array"></div></div>
</details><hr /><br />

</div>
</details>
</div>




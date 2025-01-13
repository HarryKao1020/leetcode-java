<p>Given an integer array <code>nums</code> and an integer <code>val</code>, remove all occurrences of <code>val</code> in <code>nums</code> <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a>. The order of the elements may be changed. Then return <em>the number of elements in </em><code>nums</code><em> which are not equal to </em><code>val</code>.</p>

<p>Consider the number of elements in <code>nums</code> which are not equal to <code>val</code> be <code>k</code>, to get accepted, you need to do the following things:</p>

<ul> 
 <li>Change the array <code>nums</code> such that the first <code>k</code> elements of <code>nums</code> contain the elements which are not equal to <code>val</code>. The remaining elements of <code>nums</code> are not important as well as the size of <code>nums</code>.</li> 
 <li>Return <code>k</code>.</li> 
</ul>

<p><strong>Custom Judge:</strong></p>

<p>The judge will test your solution with the following code:</p>

<pre>
int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i &lt; actualLength; i++) {
    assert nums[i] == expectedNums[i];
}
</pre>

<p>If all assertions pass, then your solution will be <strong>accepted</strong>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,2,2,3], val = 3
<strong>Output:</strong> 2, nums = [2,2,_,_]
<strong>Explanation:</strong> Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,1,2,2,3,0,4,2], val = 2
<strong>Output:</strong> 5, nums = [0,1,4,0,3,_,_,_]
<strong>Explanation:</strong> Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>0 &lt;= nums.length &lt;= 100</code></li> 
 <li><code>0 &lt;= nums[i] &lt;= 50</code></li> 
 <li><code>0 &lt;= val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Two Pointers</details><br>

<div>👍 3314, 👎 4374<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[网站会员](https://labuladong.online/algo/intro/site-vip/) 即将涨价，有需要可以尽快购买/续费，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/array-two-pointers-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

类似 [26. 删除有序数组中的重复项](/problems/remove-duplicates-from-sorted-array)，需要使用 [双指针技巧](https://labuladong.online/algo/essential-technique/array-two-pointers-summary/) 中的快慢指针：

如果 `fast` 遇到需要去除的元素，则直接跳过，否则就告诉 `slow` 指针，并让 `slow` 前进一步。

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

class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.size()) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        fast, slow = 0, 0
        while fast < len(nums):
            if nums[fast] != val:
                nums[slow] = nums[fast]
                slow += 1
            fast += 1
        return slow
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func removeElement(nums []int, val int) int {
    slow := 0
    for fast := 0; fast < len(nums); fast++ {
        if nums[fast] != val {
            nums[slow] = nums[fast]
            slow++
        }
    }
    return slow
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var removeElement = function(nums, val) {
    let fast = 0, slow = 0;
    while (fast < nums.length) {
        if (nums[fast] !== val) {
            nums[slow] = nums[fast];
            slow++;
        }
        fast++;
    }
    return slow;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_remove-element" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-element"></div></div>
</details><hr /><br />

</div>
</details>
</div>


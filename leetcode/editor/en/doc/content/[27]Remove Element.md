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

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



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

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_remove-element" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-element"></div></div>
</details><hr /><br />

</div>
</details>
</div>




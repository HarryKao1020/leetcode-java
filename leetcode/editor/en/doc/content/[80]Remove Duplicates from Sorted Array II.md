<p>Given an integer array <code>nums</code> sorted in <strong>non-decreasing order</strong>, remove some duplicates <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a> such that each unique element appears <strong>at most twice</strong>. The <strong>relative order</strong> of the elements should be kept the <strong>same</strong>.</p>

<p>Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the <strong>first part</strong> of the array <code>nums</code>. More formally, if there are <code>k</code> elements after removing the duplicates, then the first <code>k</code> elements of <code>nums</code>&nbsp;should hold the final result. It does not matter what you leave beyond the first&nbsp;<code>k</code>&nbsp;elements.</p>

<p>Return <code>k</code><em> after placing the final result in the first </em><code>k</code><em> slots of </em><code>nums</code>.</p>

<p>Do <strong>not</strong> allocate extra space for another array. You must do this by <strong>modifying the input array <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in-place</a></strong> with O(1) extra memory.</p>

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
<strong>Input:</strong> nums = [1,1,1,2,2,3]
<strong>Output:</strong> 5, nums = [1,1,2,2,3,_]
<strong>Explanation:</strong> Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,0,1,1,1,1,2,3,3]
<strong>Output:</strong> 7, nums = [0,0,1,1,2,3,3,_,_]
<strong>Explanation:</strong> Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
 <li><code>nums</code> is sorted in <strong>non-decreasing</strong> order.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Two Pointers</details><br>

<div>👍 7633, 👎 1448<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题和前文 [数组双指针技巧汇总](https://labuladong.online/algo/essential-technique/array-two-pointers-summary/) 中讲的 [26. 删除有序数组中的重复项](/problems/remove-duplicates-from-sorted-array) 解法非常类似，只不过这道题说重复两次以上的元素才需要被去除。

本题解法依然使用快慢指针技巧，在之前的解法中添加一个 `count` 变量记录每个数字重复出现的次数，然后把 26 题的 if 判断额外复制粘贴一份就行了，直接看代码吧。

**详细题解**：
  - [【练习】数组双指针经典习题](https://labuladong.online/algo/problem-set/array-two-pointers/)

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
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        }
        // 快慢指针，维护 nums[0..slow] 为结果子数组
        int slow = 0, fast = 0;
        // 记录一个元素重复的次数
        int count = 0;
        while (fast < nums.size()) {
            if (nums[fast] != nums[slow]) {
                // 此时，对于 nums[0..slow] 来说，nums[fast] 是一个新的元素，加进来
                slow++;
                nums[slow] = nums[fast];
            } else if (slow < fast && count < 2) {
                // 此时，对于 nums[0..slow] 来说，nums[fast] 重复次数小于 2，也加进来
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
            count++;
            if (fast < nums.size() && nums[fast] != nums[fast - 1]) {
                // fast 遇到新的不同的元素时，重置 count
                count = 0;
            }
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
        # 快慢指针，维护 nums[0..slow] 为结果子数组
        slow = 0
        fast = 0
        # 记录一个元素重复的次数
        count = 0
        while fast < len(nums):
            if nums[fast] != nums[slow]:
                # 此时，对于 nums[0..slow] 来说，nums[fast] 是一个新的元素，加进来
                slow += 1
                nums[slow] = nums[fast]
            elif slow < fast and count < 2:
                # 此时，对于 nums[0..slow] 来说，nums[fast] 重复次数小于 2，也加进来
                slow += 1
                nums[slow] = nums[fast]
            fast += 1
            count += 1
            if fast < len(nums) and nums[fast] != nums[fast - 1]:
                # fast 遇到新的不同的元素时，重置 count
                count = 0
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
        // 快慢指针，维护 nums[0..slow] 为结果子数组
        int slow = 0, fast = 0;
        // 记录一个元素重复的次数
        int count = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                // 此时，对于 nums[0..slow] 来说，nums[fast] 是一个新的元素，加进来
                slow++;
                nums[slow] = nums[fast];
            } else if (slow < fast && count < 2) {
                // 此时，对于 nums[0..slow] 来说，nums[fast] 重复次数小于 2，也加进来
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
            count++;
            if (fast < nums.length && nums[fast] != nums[fast - 1]) {
                // fast 遇到新的不同的元素时，重置 count
                count = 0;
            }
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
    // 快慢指针，维护 nums[0..slow] 为结果子数组
    slow, fast := 0, 0
    // 记录一个元素重复的次数
    count := 0
    for fast < len(nums) {
        if nums[fast] != nums[slow] {
            // 此时，对于 nums[0..slow] 来说，nums[fast] 是一个新的元素，加进来
            slow++
            nums[slow] = nums[fast]
        } else if slow < fast && count < 2 {
            // 此时，对于 nums[0..slow] 来说，nums[fast] 重复次数小于 2，也加进来
            slow++
            nums[slow] = nums[fast]
        }
        fast++
        count++
        if fast < len(nums) && nums[fast] != nums[fast-1] {
            // fast 遇到新的不同的元素时，重置 count
            count = 0
        }
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
    // 快慢指针，维护 nums[0..slow] 为结果子数组
    let slow = 0, fast = 0;
    // 记录一个元素重复的次数
    let count = 0;
    while (fast < nums.length) {
        if (nums[fast] !== nums[slow]) {
            // 此时，对于 nums[0..slow] 来说，nums[fast] 是一个新的元素，加进来
            slow++;
            nums[slow] = nums[fast];
        } else if (slow < fast && count < 2) {
            // 此时，对于 nums[0..slow] 来说，nums[fast] 重复次数小于 2，也加进来
            slow++;
            nums[slow] = nums[fast];
        }
        fast++;
        count++;
        if (fast < nums.length && nums[fast] !== nums[fast - 1]) {
            // fast 遇到新的不同的元素时，重置 count
            count = 0;
        }
    }
    // 数组长度为索引 + 1
    return slow + 1;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_remove-duplicates-from-sorted-array-ii" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-duplicates-from-sorted-array-ii"></div></div>
</details><hr /><br />

</div>
</details>
</div>


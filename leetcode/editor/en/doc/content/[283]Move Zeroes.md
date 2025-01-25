<p>Given an integer array <code>nums</code>, move all <code>0</code>'s to the end of it while maintaining the relative order of the non-zero elements.</p>

<p><strong>Note</strong> that you must do this in-place without making a copy of the array.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<pre><strong>Input:</strong> nums = [0,1,0,3,12]
<strong>Output:</strong> [1,3,12,0,0]
</pre>
<p><strong class="example">Example 2:</strong></p> 
<pre><strong>Input:</strong> nums = [0]
<strong>Output:</strong> [0]
</pre> 
<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li> 
</ul>

<p>&nbsp;</p> 
<strong>Follow up:</strong> Could you minimize the total number of operations done?

<details><summary><strong>Related Topics</strong></summary>Array | Two Pointers</details><br>

<div>👍 17370, 👎 497<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[网站会员](https://labuladong.online/algo/intro/site-vip/) 即将涨价，有需要可以尽快购买/续费，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/array-two-pointers-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

可以直接复用 [27. 移除元素](/problems/remove-element) 的解法，先移除所有 0，然后把最后的元素都置为 0，就相当于移动 0 的效果。

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
    void moveZeroes(vector<int>& nums) {
        // 去除 nums 中的所有 0
        // 返回去除 0 之后的数组长度
        int p = removeElement(nums, 0);
        // 将 p 之后的所有元素赋值为 0
        for (; p < nums.size(); p++) {
            nums[p] = 0;
        }
    }

    // 双指针技巧，复用 [27. 移除元素] 的解法。
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
    def moveZeroes(self, nums):
        # 去除 nums 中的所有 0
        # 返回去除 0 之后的数组长度
        p = self.removeElement(nums, 0)
        # 将 p 之后的所有元素赋值为 0
        for i in range(p, len(nums)):
            nums[i] = 0

    # 双指针技巧，复用 [27. 移除元素] 的解法。
    def removeElement(self, nums, val):
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
    public void moveZeroes(int[] nums) {
        // 去除 nums 中的所有 0
        // 返回去除 0 之后的数组长度
        int p = removeElement(nums, 0);
        // 将 p 之后的所有元素赋值为 0
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }

    // 双指针技巧，复用 [27. 移除元素] 的解法。
    int removeElement(int[] nums, int val) {
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

func moveZeroes(nums []int) {
    // 去除 nums 中的所有 0
    // 返回去除 0 之后的数组长度
    p := removeElement(nums, 0)
    // 将 p 之后的所有元素赋值为 0
    for ; p < len(nums); p++ {
        nums[p] = 0
    }
}

// 双指针技巧，复用 [27. 移除元素] 的解法。
func removeElement(nums []int, val int) int {
    fast, slow := 0, 0
    for fast < len(nums) {
        if nums[fast] != val {
            nums[slow] = nums[fast]
            slow++
        }
        fast++
    }
    return slow
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var moveZeroes = function(nums) {
    // 去除 nums 中的所有 0
    // 返回去除 0 之后的数组长度
    var p = removeElement(nums, 0);
    // 将 p 之后的所有元素赋值为 0
    for (; p < nums.length; p++) {
        nums[p] = 0;
    }
    
    // 双指针技巧，复用 [27. 移除元素] 的解法。
    function removeElement(nums, val) {
        let fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] !== val) {
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
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_move-zeroes" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_move-zeroes"></div></div>
</details><hr /><br />

</div>
</details>
</div>


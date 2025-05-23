<p>Given an array of integers <code>nums</code>&nbsp;and an integer <code>target</code>, return <em>indices of the two numbers such that they add up to <code>target</code></em>.</p>

<p>You may assume that each input would have <strong><em>exactly</em> one solution</strong>, and you may not use the <em>same</em> element twice.</p>

<p>You can return the answer in any order.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,7,11,15], target = 9
<strong>Output:</strong> [0,1]
<strong>Explanation:</strong> Because nums[0] + nums[1] == 9, we return [0, 1].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,2,4], target = 6
<strong>Output:</strong> [1,2]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,3], target = 6
<strong>Output:</strong> [0,1]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>2 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
 <li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li> 
 <li><strong>Only one valid answer exists.</strong></li> 
</ul>

<p>&nbsp;</p> 
<strong>Follow-up:&nbsp;</strong>Can you come up with an algorithm that is less than 
<code>O(n<sup>2</sup>)</code>
<font face="monospace">&nbsp;</font>time complexity?

<details><summary><strong>Related Topics</strong></summary>Array | Hash Table</details><br>

<div>👍 58458, 👎 2072<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/practice-in-action/nsum/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

大家都喜欢幽默的人，如果你想调侃自己经常拖延，可以这样调侃下自己（手动狗头）：

背单词背了半年还是 abandon, abandon，刷题刷了半年还是 two sum, two sum...

言归正传，这道题不难，但由于它是 LeetCode 第一题，所以名气比较大，解决这道题也可以有多种思路，我这里说两种最常见的思路。

第一种思路就是靠排序，把 `nums` 排序之后就可以用 [数组双指针技巧汇总](https://labuladong.online/algo/essential-technique/array-two-pointers-summary/) 中讲到的左右指针来求出和为 `target` 的两个数。

不过因为题目要求我们返回元素的索引，而排序会破坏元素的原始索引，所以要记录值和原始索引的映射。

进一步，如果题目拓展延伸一下，让你求三数之和、四数之和，你依然可以用双指针技巧，我在 [一个函数秒杀 nSum 问题](https://labuladong.online/algo/practice-in-action/nsum/) 中写一个函数来解决所有 N 数之和问题。

第二种思路是用哈希表辅助判断。对于一个元素 `nums[i]`，你想知道有没有另一个元素 `nums[j]` 的值为 `target - nums[i]`，这很简单，我们用一个哈希表记录每个元素的值到索引的映射，这样就能快速判断数组中是否有一个值为 `target - nums[i]` 的元素了。

简单说，数组其实可以理解为一个「索引 -> 值」的哈希表映射，而我们又建立一个「值 -> 索引」的映射即可完成此题。

**详细题解**：
  - [一个方法团灭 nSum 问题](https://labuladong.online/algo/practice-in-action/nsum/)
  - [【练习】哈希表更多习题](https://labuladong.online/algo/problem-set/hash-table/)

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
    vector<int> twoSum(vector<int>& nums, int target) {
        // 维护 val -> index 的映射
        unordered_map<int, int> valToIndex;
        for (int i = 0; i < nums.size(); i++) {
            // 查表，看看是否有能和 nums[i] 凑出 target 的元素
            int need = target - nums[i];
            if (valToIndex.find(need) != valToIndex.end()) {
                return {valToIndex[need], i};
            }
            // 存入 val -> index 的映射
            valToIndex[nums[i]] = i;
        }
        return {};
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 维护 val -> index 的映射
        val_to_index = {}
        for i in range(len(nums)):
            # 查表，看看是否有能和 nums[i] 凑出 target 的元素
            need = target - nums[i]
            if need in val_to_index:
                return [val_to_index[need], i]
            # 存入 val -> index 的映射
            val_to_index[nums[i]] = i
        return []
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 维护 val -> index 的映射
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 查表，看看是否有能和 nums[i] 凑出 target 的元素
            int need = target - nums[i];
            if (valToIndex.containsKey(need)) {
                return new int[]{valToIndex.get(need), i};
            }
            // 存入 val -> index 的映射
            valToIndex.put(nums[i], i);
        }
        return null;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func twoSum(nums []int, target int) []int {
    // 维护 val -> index 的映射
    valToIndex := make(map[int]int)
    for i, num := range nums {
        // 查表，看看是否有能和 nums[i] 凑出 target 的元素
        need := target - num
        if j, ok := valToIndex[need]; ok {
            return []int{j, i}
        }
        // 存入 val -> index 的映射
        valToIndex[num] = i
    }
    return nil
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var twoSum = function(nums, target) {
    // 维护 val -> index 的映射
    let valToIndex = new Map();
    for (let i = 0; i < nums.length; i++) {
        // 查表，看看是否有能和 nums[i] 凑出 target 的元素
        let need = target - nums[i];
        if (valToIndex.has(need)) {
            return [valToIndex.get(need), i];
        }
        // 存入 val -> index 的映射
        valToIndex.set(nums[i], i);
    }
    return null;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_two-sum" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_two-sum"></div></div>
</details><hr /><br />

</div>
</details>
</div>






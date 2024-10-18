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

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



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
  - [【强化练习】哈希表更多习题](https://labuladong.online/algo/problem-set/hash-table/)

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
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

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
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

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
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

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




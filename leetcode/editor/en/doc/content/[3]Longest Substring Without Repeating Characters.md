<p>Given a string <code>s</code>, find the length of the <strong>longest</strong> <span data-keyword="substring-nonempty"><strong>substring</strong></span> without repeating characters.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = "abcabcbb"
<strong>Output:</strong> 3
<strong>Explanation:</strong> The answer is "abc", with the length of 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = "bbbbb"
<strong>Output:</strong> 1
<strong>Explanation:</strong> The answer is "b", with the length of 1.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = "pwwkew"
<strong>Output:</strong> 3
<strong>Explanation:</strong> The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li> 
 <li><code>s</code> consists of English letters, digits, symbols and spaces.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Hash Table | String | Sliding Window</details><br>

<div>👍 41137, 👎 1985<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/sliding-window-framework/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题比其他滑动窗口的题目简单，连 `need` 和 `valid` 都不需要，而且更新窗口内数据也只需要简单的更新计数器 `window` 即可。

当 `window[c]` 值大于 1 时，说明窗口中存在重复字符，不符合条件，就该移动 `left` 缩小窗口了。

另外，要在收缩窗口完成后更新 `res`，因为窗口收缩的 while 条件是存在重复元素，换句话说收缩完成后一定保证窗口中没有重复。

**详细题解**：
  - [滑动窗口算法核心代码模板](https://labuladong.online/algo/essential-technique/sliding-window-framework/)

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
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> window;

        int left = 0, right = 0;
        // 记录结果
        int res = 0;
        while (right < s.size()) {
            char c = s[right];
            right++;
            // 进行窗口内数据的一系列更新
            window[c]++;
            // 判断左侧窗口是否要收缩
            while (window[c] > 1) {
                char d = s[left];
                left++;
                // 进行窗口内数据的一系列更新
                window[d]--;
            }
            // 在这里更新答案
            res = max(res, right - left);
        }
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    # 区间调度问题
    def findMinArrowShots(self, intvs: List[List[int]]) -> int:
        if not intvs:
            return 0
        # 按 end 升序排序
        intvs.sort(key=lambda x: x[1])
        # 至少有一个区间不相交
        count = 1
        # 排序后，第一个区间就是 x
        x_end = intvs[0][1]
        for interval in intvs:
            start = interval[0]
            # 把 >= 改成 > 就行了
            if start > x_end:
                count += 1
                x_end = interval[1]
        return count
    
    # 无重复字符的最长子串
    def lengthOfLongestSubstring(self, s: str) -> int:
        char_map = {}
        left = 0
        max_length = 0
        
        for right in range(len(s)):
            if s[right] in char_map and char_map[s[right]] >= left:
                left = char_map[s[right]] + 1
            char_map[s[right]] = right
            max_length = max(max_length, right - left + 1)
        
        return max_length
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        // 记录结果
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 判断左侧窗口是否要收缩
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                window.put(d, window.get(d) - 1);
            }
            // 在这里更新答案
            res = Math.max(res, right - left);
        }
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func lengthOfLongestSubstring(s string) int {
    window := make(map[rune]int)

    left, right := 0, 0
    // 记录结果
    res := 0
    for right < len(s) {
        c := rune(s[right])
        right++
        // 进行窗口内数据的一系列更新
        window[c] = window[c] + 1
        // 判断左侧窗口是否要收缩
        for window[c] > 1 {
            d := rune(s[left])
            left++
            // 进行窗口内数据的一系列更新
            window[d] = window[d] - 1
        }
        // 在这里更新答案
        if res < right-left {
            res = right - left
        }
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var lengthOfLongestSubstring = function(s) {
    let window = new Map();

    let left = 0, right = 0;
    // 记录结果
    let res = 0;
    while (right < s.length) {
        let c = s.charAt(right);
        right++;
        // 进行窗口内数据的一系列更新
        window.set(c, (window.get(c) || 0) + 1);
        // 判断左侧窗口是否要收缩
        while (window.get(c) > 1) {
            let d = s.charAt(left);
            left++;
            // 进行窗口内数据的一系列更新
            window.set(d, window.get(d) - 1);
        }
        // 在这里更新答案
        res = Math.max(res, right - left);
    }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_longest-substring-without-repeating-characters" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_longest-substring-without-repeating-characters"></div></div>
</details><hr /><br />

</div>
</details>
</div>


<p>Write a function to find the longest common prefix string amongst an array of strings.</p>

<p>If there is no common prefix, return an empty string <code>""</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> strs = ["flower","flow","flight"]
<strong>Output:</strong> "fl"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> strs = ["dog","racecar","car"]
<strong>Output:</strong> ""
<strong>Explanation:</strong> There is no common prefix among the input strings.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= strs.length &lt;= 200</code></li> 
 <li><code>0 &lt;= strs[i].length &lt;= 200</code></li> 
 <li><code>strs[i]</code> consists of only lowercase English letters.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>String | Trie</details><br>

<div>👍 18066, 👎 4610<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**

<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

这个题没什么难度，你把字符串列表看成一个二维数组，然后用一个嵌套 for 循环计算这个二维数组前面有多少列的元素完全相同即可。

如果硬要上点难度的话，你可以考虑用我在 [前缀树算法模板及原理](https://labuladong.online/algo/problem-set/trie/) 中讲过的前缀树结构，把这些字符串转化成前缀树来计算一下公共前缀。

- **详细题解**：
  - [【强化练习】数组双指针经典习题](https://labuladong.online/algo/problem-set/array-two-pointers/)

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
    string longestCommonPrefix(vector<string>& strs) {
        int m = strs.size();
        // 以第一行的列数为基准
        int n = strs[0].length();
        for (int col = 0; col < n; col++) {
            for (int row = 1; row < m; row++) {
                string thisStr = strs[row], prevStr = strs[row - 1];
                // 判断每个字符串的 col 索引是否都相同
                if (col >= thisStr.length() || col >= prevStr.length() ||
                    thisStr[col] != prevStr[col]) {
                    // 发现不匹配的字符，只有 strs[row][0..col-1] 是公共前缀
                    return strs[row].substr(0, col);
                }
            }
        }
        return strs[0];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        m = len(strs)
        # 以第一行的列数为基准
        n = len(strs[0])
        for col in range(n):
            for row in range(1, m):
                thisStr, prevStr = strs[row], strs[row - 1]
                # 判断每个字符串的 col 索引是否都相同
                if col >= len(thisStr) or col >= len(prevStr) or thisStr[col] != prevStr[col]:
                    # 发现不匹配的字符，只有 strs[row][0..col-1] 是公共前缀
                    return strs[row][:col]
        return strs[0]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int m = strs.length;
        // 以第一行的列数为基准
        int n = strs[0].length();
        for (int col = 0; col < n; col++) {
            for (int row = 1; row < m; row++) {
                String thisStr = strs[row], prevStr = strs[row - 1];
                // 判断每个字符串的 col 索引是否都相同
                if (col >= thisStr.length() || col >= prevStr.length() ||
                        thisStr.charAt(col) != prevStr.charAt(col)) {
                    // 发现不匹配的字符，只有 strs[row][0..col-1] 是公共前缀
                    return strs[row].substring(0, col);
                }
            }
        }
        return strs[0];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

func longestCommonPrefix(strs []string) string {
    m := len(strs)
    // 以第一行的列数为基准
    n := len(strs[0])
    for col := 0; col < n; col++ {
        for row := 1; row < m; row++ {
            thisStr, prevStr := strs[row], strs[row-1]
            // 判断每个字符串的 col 索引是否都相同
            if col >= len(thisStr) || col >= len(prevStr) || thisStr[col] != prevStr[col] {
                // 发现不匹配的字符，只有 strs[row][0..col-1] 是公共前缀
                return strs[row][:col]
            }
        }
    }
    return strs[0]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var longestCommonPrefix = function(strs) {
    let m = strs.length;
    // 以第一行的列数为基准
    let n = strs[0].length;
    for (let col = 0; col < n; col++) {
        for (let row = 1; row < m; row++) {
            let thisStr = strs[row], prevStr = strs[row - 1];
            // 判断每个字符串的 col 索引是否都相同
            if (col >= thisStr.length || col >= prevStr.length ||
                    thisStr.charAt(col) !== prevStr.charAt(col)) {
                // 发现不匹配的字符，只有 strs[row][0..col-1] 是公共前缀
                return strs[row].substring(0, col);
            }
        }
    }
    return strs[0];
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_longest-common-prefix" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_longest-common-prefix"></div></div>
</details><hr /><br />

</div>

</details>
</div>


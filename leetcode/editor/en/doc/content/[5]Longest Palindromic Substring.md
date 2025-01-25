<p>Given a string <code>s</code>, return <em>the longest</em> <span data-keyword="palindromic-string"><em>palindromic</em></span> <span data-keyword="substring-nonempty"><em>substring</em></span> in <code>s</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = "babad"
<strong>Output:</strong> "bab"
<strong>Explanation:</strong> "aba" is also a valid answer.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = "cbbd"
<strong>Output:</strong> "bb"
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 1000</code></li> 
 <li><code>s</code> consist of only digits and English letters.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Two Pointers | String | Dynamic Programming</details><br>

<div>👍 30204, 👎 1858<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[网站会员](https://labuladong.online/algo/intro/site-vip/) 即将涨价，有需要可以尽快购买/续费，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/array-two-pointers-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

**寻找回文串的问题核心思想是：从中间开始向两边扩散来判断回文串**，对于最长回文子串，就是这个意思：

```python
for 0 <= i < len(s):
    找到以 s[i] 为中心的回文串
    更新答案
```

找回文串的关键技巧是传入两个指针 `l` 和 `r` 向两边扩散，因为这样实现可以同时处理回文串长度为奇数和偶数的情况。

```python
for 0 <= i < len(s):
    # 找到以 s[i] 为中心的回文串
    palindrome(s, i, i)
    # 找到以 s[i] 和 s[i+1] 为中心的回文串
    palindrome(s, i, i + 1)
    更新答案
```

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

#include <string>
using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        string res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            string s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            string s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

private:
    string palindrome(string s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length() && s[l] == s[r]) {
            // 向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substr(l + 1, r - l - 1);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        for i in range(len(s)):
            # 以 s[i] 为中心的最长回文子串
            s1 = self.palindrome(s, i, i)
            # 以 s[i] 和 s[i+1] 为中心的最长回文子串
            s2 = self.palindrome(s, i, i + 1)
            # res = longest(res, s1, s2)
            res = res if len(res) > len(s1) else s1
            res = res if len(res) > len(s2) else s2
        return res

    def palindrome(self, s: str, l: int, r: int) -> str:
        # 防止索引越界
        while l >= 0 and r < len(s) and s[l] == s[r]:
            # 向两边展开
            l -= 1
            r += 1
        # 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s[l + 1:r]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func longestPalindrome(s string) string {
    res := ""
    for i := 0; i < len(s); i++ {
        // 以 s[i] 为中心的最长回文子串
        s1 := palindrome(s, i, i)
        // 以 s[i] 和 s[i+1] 为中心的最长回文子串
        s2 := palindrome(s, i, i+1)
        // res = longest(res, s1, s2)
        if len(res) > len(s1) {
            res = res
        } else {
            res = s1
        }
        if len(res) > len(s2) {
            res = res
        } else {
            res = s2
        }
    }
    return res
}

func palindrome(s string, l, r int) string {
    // 防止索引越界
    for l >= 0 && r < len(s) && s[l] == s[r] {
        // 向两边展开
        l--
        r++
    }
    // 返回以 s[l] 和 s[r] 为中心的最长回文串
    return s[l+1:r]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var longestPalindrome = function(s) {
    let res = "";
    for (let i = 0; i < s.length; i++) {
        // 以 s[i] 为中心的最长回文子串
        let s1 = palindrome(s, i, i);
        // 以 s[i] 和 s[i+1] 为中心的最长回文子串
        let s2 = palindrome(s, i, i + 1);
        // res = longest(res, s1, s2)
        res = res.length > s1.length ? res : s1;
        res = res.length > s2.length ? res : s2;
    }
    return res;
};

var palindrome = function(s, l, r) {
    // 防止索引越界
    while (l >= 0 && r < s.length && s[l] === s[r]) {
        // 向两边展开
        l--;
        r++;
    }
    // 返回以 s[l] 和 s[r] 为中心的最长回文串
    return s.substring(l + 1, r);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_longest-palindromic-substring" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_longest-palindromic-substring"></div></div>
</details><hr /><br />

</div>
</details>
</div>


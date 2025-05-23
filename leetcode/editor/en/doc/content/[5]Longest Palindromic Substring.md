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

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



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
        // 此时 [l+1, r-1] 就是最长回文串
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
        # 此时 [l+1, r-1] 就是最长回文串
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
        // 此时 [l+1, r-1] 就是最长回文串
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
    // 此时 [l+1, r-1] 就是最长回文串
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
    // 此时 [l+1, r-1] 就是最长回文串
    return s.substring(l + 1, r);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_longest-palindromic-substring" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_longest-palindromic-substring"></div></div>
</details><hr /><br />

</div>
</details>
</div>






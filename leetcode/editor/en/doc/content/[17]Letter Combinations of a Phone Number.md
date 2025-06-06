<p>Given a string containing digits from <code>2-9</code> inclusive, return all possible letter combinations that the number could represent. Return the answer in <strong>any order</strong>.</p>

<p>A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.</p> 
<img alt="" src="https://assets.leetcode.com/uploads/2022/03/15/1200px-telephone-keypad2svg.png" style="width: 300px; height: 243px;" /> 
<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> digits = "23"
<strong>Output:</strong> ["ad","ae","af","bd","be","bf","cd","ce","cf"]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> digits = ""
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> digits = "2"
<strong>Output:</strong> ["a","b","c"]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>0 &lt;= digits.length &lt;= 4</code></li> 
 <li><code>digits[i]</code> is a digit in the range <code>['2', '9']</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Hash Table | String | Backtracking</details><br>

<div>👍 18940, 👎 1019<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

你需要先看前文 [回溯算法详解](https://labuladong.online/algo/essential-technique/backtrack-framework/) 和 [回溯算法团灭子集、排列、组合问题](https://labuladong.online/algo/essential-technique/permutation-combination-subset-all-in-one/)，然后看这道题就很简单了，无非是回溯算法的运用而已。

组合问题本质上就是遍历一棵回溯树，套用回溯算法代码框架即可。

**详细题解**：
  - [【强化练习】回溯算法经典习题 I](https://labuladong.online/algo/problem-set/backtrack-i/)

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

#include <vector>
#include <string>
#include <unordered_map>

class Solution {
    // 每个数字到字母的映射
    std::unordered_map<char, std::string> mapping = {
        {'2', "abc"}, {'3', "def"}, {'4', "ghi"}, {'5', "jkl"},
        {'6', "mno"}, {'7', "pqrs"}, {'8', "tuv"}, {'9', "wxyz"}
    };

    std::vector<std::string> res;
    std::string sb;

public:
    std::vector<std::string> letterCombinations(std::string digits) {
        if (digits.empty()) {
            return res;
        }
        // 从 digits[0] 开始进行回溯
        backtrack(digits, 0);
        return res;
    }

    // 回溯算法主函数
    void backtrack(const std::string& digits, int start) {
        if (sb.size() == digits.size()) {
            // 到达回溯树底部
            res.push_back(sb);
            return;
        }

        // 回溯算法框架
        char digit = digits[start];
        for (char c : mapping[digit]) {
            // 做选择
            sb.push_back(c);
            // 递归下一层回溯树
            backtrack(digits, start + 1);
            // 撤销选择
            sb.pop_back();
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    # 每个数字到字母的映射
    mapping = [
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    ]

    def __init__(self):
        self.res = []
        self.sb = []

    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return self.res
        # 从 digits[0] 开始进行回溯
        self.backtrack(digits, 0)
        return self.res

    # 回溯算法主函数
    def backtrack(self, digits: str, start: int) -> None:
        if len(self.sb) == len(digits):
            # 到达回溯树底部
            self.res.append(''.join(self.sb))
            return

        # 回溯算法框架
        digit = ord(digits[start]) - ord('0')
        for c in self.mapping[digit]:
            # 做选择
            self.sb.append(c)
            # 递归下一层回溯树
            self.backtrack(digits, start + 1)
            # 撤销选择
            self.sb.pop()
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 每个数字到字母的映射
    String[] mapping = new String[] {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    List<String> res = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }
        // 从 digits[0] 开始进行回溯
        backtrack(digits, 0);
        return res;
    }

    // 回溯算法主函数
    void backtrack(String digits, int start) {
        if (sb.length() == digits.length()) {
            // 到达回溯树底部
            res.add(sb.toString());
            return;
        }

        // 回溯算法框架
        int digit = digits.charAt(start) - '0';
        for (char c : mapping[digit].toCharArray()) {
            // 做选择
            sb.append(c);
            // 递归下一层回溯树
            backtrack(digits, start + 1);
            // 撤销选择
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

func letterCombinations(digits string) []string {
    if len(digits) == 0 {
        return []string{}
    }
    // 每个数字到字母的映射
    var mapping = []string{
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz",
    }
    var res []string
    // 从 digits[0] 开始进行回溯
    backtrack(digits, 0, "", &res, mapping)
    return res
}

// 回溯算法主函数
func backtrack(digits string, start int, combination string, res *[]string, mapping []string) {
    if len(combination) == len(digits) {
        // 到达回溯树底部
        *res = append(*res, combination)
        return
    }

    // 回溯算法框架
    digit := digits[start] - '0'
    for _, c := range mapping[digit] {
        // 做选择
        backtrack(digits, start+1, combination+string(c), res, mapping)
        // 递归下一层回溯树
        // Note: The following comment is not needed as there is no action taken for "undo the choice"
        // 撤销选择
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var letterCombinations = function(digits) {
    // 每个数字到字母的映射
    const mapping = [
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    ];

    let res = [];
    let sb = "";

    if (digits === "") {
        return res;
    }

    // 从 digits[0] 开始进行回溯
    // @visualize status(sb)
    function backtrack(digits, start) {
        // 回溯算法主函数
        if (sb.length === digits.length) {
            // 到达回溯树底部
            res.push(sb);
            return;
        }

        // 回溯算法框架
        let digit = digits.charCodeAt(start) - '0'.charCodeAt(0);
        for (let c of mapping[digit].split("")) {
            // 做选择
            // @visualize choose(c)
            sb += c;
            // 递归下一层回溯树
            backtrack(digits, start + 1);
            // 撤销选择
            // @visualize unchoose()
            sb = sb.slice(0, -1);
        }
    }

    backtrack(digits, 0);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_letter-combinations-of-a-phone-number" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_letter-combinations-of-a-phone-number"></div></div>
</details><hr /><br />

</div>
</details>
</div>


<p>Given a string <code>s</code> containing just the characters <code>'('</code>, <code>')'</code>, <code>'{'</code>, <code>'}'</code>, <code>'['</code> and <code>']'</code>, determine if the input string is valid.</p>

<p>An input string is valid if:</p>

<ol> 
 <li>Open brackets must be closed by the same type of brackets.</li> 
 <li>Open brackets must be closed in the correct order.</li> 
 <li>Every close bracket has a corresponding open bracket of the same type.</li> 
</ol>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">s = "()"</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">s = "()[]{}"</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">s = "(]"</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">s = "([])"</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>s</code> consists of parentheses only <code>'()[]{}'</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>String | Stack</details><br>

<div>👍 24682, 👎 1814<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

栈是一种先进后出的数据结构，处理括号问题的时候尤其有用。

括号的有效性判断在笔试中和现实中都很常见，比如说我们写的代码，编辑器会检查括号是否正确闭合。而且我们的代码可能会包含三种括号 `[](){}`，判断起来有一点难度。

解决这个问题之前，我们先降低难度，思考一下，**如果只有一种括号 `()`**，应该如何判断字符串组成的括号是否有效呢？

假设字符串中只有圆括号，如果想让括号字符串有效，那么必须做到：

**每个右括号 `)` 的左边必须有一个左括号 `(` 和它匹配**。

比如说字符串 `()))((` 中，中间的两个右括号**左边**就没有左括号匹配，所以这个括号组合是无效的。

那么根据这个思路，我们可以写出算法：

```java
boolean isValid(String str) {
    // 待匹配的左括号数量
    int left = 0;
    for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == '(') {
            left++;
        } else {
            // 遇到右括号
            left--;
        }

        // 右括号太多
        if (left == -1)
            return false;
    }
    // 是否所有的左括号都被匹配了
    return left == 0;
}
```

如果只有圆括号，这样就能正确判断有效性。对于三种括号的情况，我一开始想模仿这个思路，定义三个变量 `left1`，`left2`，`left3` 分别处理每种括号，虽然要多写不少 if else 分支，但是似乎可以解决问题。

但实际上直接照搬这种思路是不行的，比如说只有一个括号的情况下 `(())` 是有效的，但是多种括号的情况下， `[(])` 显然是无效的。

仅仅记录每种左括号出现的次数已经不能做出正确判断了，我们要加大存储的信息量，可以利用栈来模仿类似的思路。

我们这道题就用一个名为 `left` 的栈代替之前思路中的 `left` 变量，**遇到左括号就入栈，遇到右括号就去栈中寻找最近的左括号，看是否匹配**。

**详细题解**：
  - [【强化练习】栈的经典习题](https://labuladong.online/algo/problem-set/stack/)

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
    bool isValid(string str) {
        stack<char> left;
        for (char c : str) {
            if (c == '(' || c == '{' || c == '[')
                left.push(c);
            // 字符 c 是右括号
            else
                if (!left.empty() && leftOf(c) == left.top())
                    left.pop();
                else
                    // 和最近的左括号不匹配
                    return false;
        }
        // 是否所有的左括号都被匹配了
        return left.empty();
    }

private:
    char leftOf(char c) {
        if (c == '}') return '{';
        if (c == ')') return '(';
        return '[';
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    def isValid(self, str: str) -> bool:
        left = []
        for c in str:
            if c == '(' or c == '{' or c == '[':
                left.append(c)
            # 字符 c 是右括号
            else:
                if left and self.leftOf(c) == left[-1]:
                    left.pop()
                else:
                    # 和最近的左括号不匹配
                    return False
        # 是否所有的左括号都被匹配了
        return not left

    def leftOf(self, c: str) -> str:
        if c == '}': return '{'
        if c == ')': return '('
        return '['
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean isValid(String str) {
        Stack<Character> left = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                left.push(c);
            // 字符 c 是右括号
            else
                if (!left.isEmpty() && leftOf(c) == left.peek())
                    left.pop();
                else
                    // 和最近的左括号不匹配
                    return false;
        }
        // 是否所有的左括号都被匹配了
        return left.isEmpty();
    }

    char leftOf(char c) {
        if (c == '}') return '{';
        if (c == ')') return '(';
        return '[';
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

func isValid(str string) bool {
    var left stack
    for _, c := range str {
        if c == '(' || c == '{' || c == '[' {
            left.push(c)
        } else {
            // 字符 c 是右括号
            if !left.isEmpty() && leftOf(c) == left.peek() {
                left.pop()
            } else {
                // 和最近的左括号不匹配
                return false
            }
        }
    }
    // 是否所有的左括号都被匹配了
    return left.isEmpty()
}

// stack is a basic LIFO stack that holds a slice of characters.
type stack []rune

func (s *stack) push(v rune) {
    *s = append(*s, v)
}

func (s *stack) pop() rune {
    old := *s
    n := len(old)
    v := old[n-1]
    *s = old[0 : n-1]
    return v
}

func (s *stack) peek() rune {
    return (*s)[len(*s)-1]
}

func (s *stack) isEmpty() bool {
    return len(*s) == 0
}

func leftOf(c rune) rune {
    switch c {
    case '}':
        return '{'
    case ')':
        return '('
    case ']':
        return '['
    }
    return ' ' // This should never happen if the input is valid
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var isValid = function(str) {
    let left = [];
    for (let c of str) {
        if (c === '(' || c === '{' || c === '[') {
            left.push(c);
        } else {
            // 字符 c 是右括号
            if (left.length !== 0 && leftOf(c) === left[left.length - 1]) {
                left.pop();
            } else {
                // 和最近的左括号不匹配
                return false;
            }
        }
    }
    // 是否所有的左括号都被匹配了
    return left.length === 0;
};

var leftOf = function(c) {
    if (c === '}') return '{';
    if (c === ')') return '(';
    return '[';
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_valid-parentheses" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_valid-parentheses"></div></div>
</details><hr /><br />

</div>
</details>
</div>


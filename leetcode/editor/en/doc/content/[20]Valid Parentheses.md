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

**通知：[网站会员](https://labuladong.online/algo/intro/site-vip/) 即将涨价，有需要可以尽快购买/续费，谢谢大家的支持~**

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
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

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
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

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
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

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
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

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

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_valid-parentheses" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_valid-parentheses"></div></div>
</details><hr /><br />

</div>
</details>
</div>



iv>
</details>
</div>


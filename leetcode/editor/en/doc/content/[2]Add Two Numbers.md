<p>You are given two <strong>non-empty</strong> linked lists representing two non-negative integers. The digits are stored in <strong>reverse order</strong>, and each of their nodes contains a single digit. Add the two numbers and return the sum&nbsp;as a linked list.</p>

<p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/02/addtwonumber1.jpg" style="width: 483px; height: 342px;" /> 
<pre>
<strong>Input:</strong> l1 = [2,4,3], l2 = [5,6,4]
<strong>Output:</strong> [7,0,8]
<strong>Explanation:</strong> 342 + 465 = 807.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> l1 = [0], l2 = [0]
<strong>Output:</strong> [0]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
<strong>Output:</strong> [8,9,9,9,0,0,0,1]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in each linked list is in the range <code>[1, 100]</code>.</li> 
 <li><code>0 &lt;= Node.val &lt;= 9</code></li> 
 <li>It is guaranteed that the list represents a number that does not have leading zeros.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Linked List | Math | Recursion</details><br>

<div>👍 31879, 👎 6398<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

逆序存储很友好了，直接遍历链表就是从个位开始的，符合我们计算加法的习惯顺序。如果是正序存储，那倒要费点脑筋了，可能需要 [翻转链表](https://labuladong.online/algo/data-structure/reverse-linked-list-recursion/) 或者使用栈来辅助。

这道题主要考察 [链表双指针技巧](https://labuladong.online/algo/essential-technique/linked-list-skills-summary/) 和加法运算过程中对进位的处理。注意这个 `carry` 变量的处理，在我们手动模拟加法过程的时候会经常用到。

**代码中还用到一个链表的算法题中是很常见的「虚拟头结点」技巧，也就是 `dummy` 节点**。你可以试试，如果不使用 `dummy` 虚拟节点，代码会稍显复杂，而有了 `dummy` 节点这个占位符，可以避免处理初始的空指针情况，降低代码的复杂性。

**详细题解**：
  - [【强化练习】链表双指针经典习题](https://labuladong.online/algo/problem-set/linkedlist-two-pointers/)

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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        // 在两条链表上的指针
        ListNode *p1 = l1, *p2 = l2;
        // 虚拟头结点（构建新链表时的常用技巧）
        ListNode *dummy = new ListNode(-1);
        // 指针 p 负责构建新链表
        ListNode *p = dummy;
        // 记录进位
        int carry = 0;
        // 开始执行加法，两条链表走完且没有进位时才能结束循环
        while (p1 != nullptr || p2 != nullptr || carry > 0) {
            // 先加上上次的进位
            int val = carry;
            if (p1 != nullptr) {
                val += p1->val;
                p1 = p1->next;
            }
            if (p2 != nullptr) {
                val += p2->val;
                p2 = p2->next;
            }
            // 处理进位情况
            carry = val / 10;
            val = val % 10;
            // 构建新节点
            p->next = new ListNode(val);
            p = p->next;
        }
        // 返回结果链表的头结点（去除虚拟头结点）
        return dummy->next;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        # 在两条链表上的指针
        p1, p2 = l1, l2
        # 虚拟头结点（构建新链表时的常用技巧）
        dummy = ListNode(-1)
        # 指针 p 负责构建新链表
        p = dummy
        # 记录进位
        carry = 0
        # 开始执行加法，两条链表走完且没有进位时才能结束循环
        while p1 is not None or p2 is not None or carry > 0:
            # 先加上上次的进位
            val = carry
            if p1 is not None:
                val += p1.val
                p1 = p1.next
            if p2 is not None:
                val += p2.val
                p2 = p2.next
            # 处理进位情况
            carry = val // 10
            val = val % 10
            # 构建新节点
            p.next = ListNode(val)
            p = p.next
        # 返回结果链表的头结点（去除虚拟头结点）
        return dummy.next
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 在两条链表上的指针
        ListNode p1 = l1, p2 = l2;
        // 虚拟头结点（构建新链表时的常用技巧）
        ListNode dummy = new ListNode(-1);
        // 指针 p 负责构建新链表
        ListNode p = dummy;
        // 记录进位
        int carry = 0;
        // 开始执行加法，两条链表走完且没有进位时才能结束循环
        while (p1 != null || p2 != null || carry > 0) {
            // 先加上上次的进位
            int val = carry;
            if (p1 != null) {
                val += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                val += p2.val;
                p2 = p2.next;
            }
            // 处理进位情况
            carry = val / 10;
            val = val % 10;
            // 构建新节点
            p.next = new ListNode(val);
            p = p.next;
        }
        // 返回结果链表的头结点（去除虚拟头结点）
        return dummy.next;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    // 在两条链表上的指针
    p1, p2 := l1, l2
    // 虚拟头结点（构建新链表时的常用技巧）
    dummy := &ListNode{-1, nil}
    // 指针 p 负责构建新链表
    p := dummy
    // 记录进位
    carry := 0
    // 开始执行加法，两条链表走完且没有进位时才能结束循环
    for p1 != nil || p2 != nil || carry > 0 {
        // 先加上上次的进位
        val := carry
        if p1 != nil {
            val += p1.Val
            p1 = p1.Next
        }
        if p2 != nil {
            val += p2.Val
            p2 = p2.Next
        }
        // 处理进位情况
        carry = val / 10
        val = val % 10
        // 构建新节点
        p.Next = &ListNode{val, nil}
        p = p.Next
    }
    // 返回结果链表的头结点（去除虚拟头结点）
    return dummy.Next
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var addTwoNumbers = function(l1, l2) {
    // 在两条链表上的指针
    let p1 = l1, p2 = l2;
    // 虚拟头结点（构建新链表时的常用技巧）
    let dummy = new ListNode(-1);
    // 指针 p 负责构建新链表
    let p = dummy;
    // 记录进位
    let carry = 0;
    // 开始执行加法，两条链表走完且没有进位时才能结束循环
    while (p1 !== null || p2 !== null || carry > 0) {
        // 先加上上次的进位
        let val = carry;
        if (p1 !== null) {
            val += p1.val;
            p1 = p1.next;
        }
        if (p2 !== null) {
            val += p2.val;
            p2 = p2.next;
        }
        // 处理进位情况
        carry = Math.floor(val / 10);
        val = val % 10;
        // 构建新节点
        p.next = new ListNode(val);
        p = p.next;
    }
    // 返回结果链表的头结点（去除虚拟头结点）
    return dummy.next;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_add-two-numbers" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_add-two-numbers"></div></div>
</details><hr /><br />

</div>
</details>
</div>


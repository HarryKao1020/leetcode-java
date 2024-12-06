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

**通知：[网站会员](https://labuladong.online/algo/intro/site-vip/) 即将涨价，有需要可以尽快购买/续费，谢谢大家的支持~**

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
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

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
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

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
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

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
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

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

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_add-two-numbers" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_add-two-numbers"></div></div>
</details><hr /><br />

</div>
</details>
</div>




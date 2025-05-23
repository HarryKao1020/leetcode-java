<p>Given the <code>head</code> of a singly linked list, return <code>true</code><em> if it is a </em><span data-keyword="palindrome-sequence"><em>palindrome</em></span><em> or </em><code>false</code><em> otherwise</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg" style="width: 422px; height: 62px;" /> 
<pre>
<strong>Input:</strong> head = [1,2,2,1]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg" style="width: 182px; height: 62px;" /> 
<pre>
<strong>Input:</strong> head = [1,2]
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the list is in the range <code>[1, 10<sup>5</sup>]</code>.</li> 
 <li><code>0 &lt;= Node.val &lt;= 9</code></li> 
</ul>

<p>&nbsp;</p> 
<strong>Follow up:</strong> Could you do it in 
<code>O(n)</code> time and 
<code>O(1)</code> space?

<details><summary><strong>Related Topics</strong></summary>Linked List | Two Pointers | Stack | Recursion</details><br>

<div>👍 17294, 👎 927<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/palindrome-linked-list/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题的关键在于，单链表无法倒着遍历，无法使用双指针技巧。

那么最简单的办法就是，把原始链表反转存入一条新的链表，然后比较这两条链表是否相同。

更聪明一些的办法是借助双指针算法：

**1、先通过 [双指针技巧](https://labuladong.online/algo/essential-technique/linked-list-skills-summary/) 中的快慢指针来找到链表的中点**：

![](https://labuladong.online/algo/images/palindrome-list/1.jpg)

**2、如果 `fast` 指针没有指向 `null`，说明链表长度为奇数，`slow` 还要再前进一步**：

![](https://labuladong.online/algo/images/palindrome-list/2.jpg)

**3、从 `slow` 开始反转后面的链表，现在就可以开始比较回文串了**：

![](https://labuladong.online/algo/images/palindrome-list/3.jpg)

**详细题解**：
  - [如何判断回文链表](https://labuladong.online/algo/data-structure/palindrome-linked-list/)

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
    bool isPalindrome(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        while (fast != nullptr && fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
        }

        if (fast != nullptr)
            slow = slow->next;

        ListNode* left = head;
        ListNode* right = reverse(slow);
        while (right != nullptr) {
            if (left->val != right->val)
                return false;
            left = left->next;
            right = right->next;
        }

        return true;
    }

    ListNode* reverse(ListNode* head) {
        ListNode* pre = nullptr;
        ListNode* cur = head;
        while (cur != nullptr) {
            ListNode* next = cur->next;
            cur->next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        slow = fast = head
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next

        if fast is not None:
            slow = slow.next

        left = head
        right = self.reverse(slow)
        while right is not None:
            if left.val != right.val:
                return False
            left = left.next
            right = right.next

        return True

    def reverse(self, head: ListNode) -> ListNode:
        pre = None
        cur = head
        while cur is not None:
            next = cur.next
            cur.next = pre
            pre = cur
            cur = next
        return pre
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null)
            slow = slow.next;

        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func isPalindrome(head *ListNode) bool {
    slow, fast := head, head
    for fast != nil && fast.Next != nil {
        slow = slow.Next
        fast = fast.Next.Next
    }

    if fast != nil {
        slow = slow.Next
    }

    left := head
    right := reverse(slow)
    for right != nil {
        if left.Val != right.Val {
            return false
        }
        left = left.Next
        right = right.Next
    }

    return true
}

func reverse(head *ListNode) *ListNode {
    var pre *ListNode
    cur := head
    for cur != nil {
        next := cur.Next
        cur.Next = pre
        pre = cur
        cur = next
    }
    return pre
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var isPalindrome = function(head) {
    var reverse = function(head) {
        let pre = null, cur = head;
        while (cur != null) {
            let next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    };

    let slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    if (fast != null)
        slow = slow.next;

    let left = head;
    let right = reverse(slow);
    while (right != null) {
        if (left.val !== right.val)
            return false;
        left = left.next;
        right = right.next;
    }

    return true;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_palindrome-linked-list" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_palindrome-linked-list"></div></div>
</details><hr /><br />

</div>
</details>
</div>


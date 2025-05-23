<p>Given <code>head</code>, the head of a linked list, determine if the linked list has a cycle in it.</p>

<p>There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the&nbsp;<code>next</code>&nbsp;pointer. Internally, <code>pos</code>&nbsp;is used to denote the index of the node that&nbsp;tail's&nbsp;<code>next</code>&nbsp;pointer is connected to.&nbsp;<strong>Note that&nbsp;<code>pos</code>&nbsp;is not passed as a parameter</strong>.</p>

<p>Return&nbsp;<code>true</code><em> if there is a cycle in the linked list</em>. Otherwise, return <code>false</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png" style="width: 300px; height: 97px; margin-top: 8px; margin-bottom: 8px;" /> 
<pre>
<strong>Input:</strong> head = [3,2,0,-4], pos = 1
<strong>Output:</strong> true
<strong>Explanation:</strong> There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png" style="width: 141px; height: 74px;" /> 
<pre>
<strong>Input:</strong> head = [1,2], pos = 0
<strong>Output:</strong> true
<strong>Explanation:</strong> There is a cycle in the linked list, where the tail connects to the 0th node.
</pre>

<p><strong class="example">Example 3:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png" style="width: 45px; height: 45px;" /> 
<pre>
<strong>Input:</strong> head = [1], pos = -1
<strong>Output:</strong> false
<strong>Explanation:</strong> There is no cycle in the linked list.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of the nodes in the list is in the range <code>[0, 10<sup>4</sup>]</code>.</li> 
 <li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li> 
 <li><code>pos</code> is <code>-1</code> or a <strong>valid index</strong> in the linked-list.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Follow up:</strong> Can you solve it using <code>O(1)</code> (i.e. constant) memory?</p>

<details><summary><strong>Related Topics</strong></summary>Hash Table | Linked List | Two Pointers</details><br>

<div>👍 15868, 👎 1424<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/linked-list-skills-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

经典题目了，要使用双指针技巧中的快慢指针，每当慢指针 `slow` 前进一步，快指针 `fast` 就前进两步。

如果 `fast` 最终遇到空指针，说明链表中没有环；如果 `fast` 最终和 `slow` 相遇，那肯定是 `fast` 超过了 `slow` 一圈，说明链表中含有环。

**详细题解**：
  - [双指针技巧秒杀七道链表题目](https://labuladong.online/algo/essential-technique/linked-list-skills-summary/)

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
    bool hasCycle(ListNode *head) {
        // 快慢指针初始化指向 head
        ListNode *slow = head, *fast = head;
        // 快指针走到末尾时停止
        while (fast != nullptr && fast->next != nullptr) {
            // 慢指针走一步，快指针走两步
            slow = slow->next;
            fast = fast->next->next;
            // 快慢指针相遇，说明含有环
            if (slow == fast) {
                return true;
            }
        }
        // 不包含环
        return false;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    # 快慢指针初始化指向 head
    def hasCycle(self, head: ListNode) -> bool:
        slow = head
        fast = head
        # 快指针走到末尾时停止
        while fast is not None and fast.next is not None:
            # 慢指针走一步，快指针走两步
            slow = slow.next
            fast = fast.next.next
            # 快慢指针相遇，说明含有环
            if slow == fast:
                return True
        # 不包含环
        return False
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇，说明含有环
            if (slow == fast) {
                return true;
            }
        }
        // 不包含环
        return false;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func hasCycle(head *ListNode) bool {
    // 快慢指针初始化指向 head
    slow, fast := head, head
    // 快指针走到末尾时停止
    for fast != nil && fast.Next != nil {
        // 慢指针走一步，快指针走两步
        slow = slow.Next
        fast = fast.Next.Next
        // 快慢指针相遇，说明含有环
        if slow == fast {
            return true
        }
    }
    // 不包含环
    return false
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var hasCycle = function(head) {
    // 快慢指针初始化指向 head
    let slow = head, fast = head;
    // 快指针走到末尾时停止
    while (fast !== null && fast.next !== null) {
        // 慢指针走一步，快指针走两步
        slow = slow.next;
        fast = fast.next.next;
        // 快慢指针相遇，说明含有环
        if (slow === fast) {
            return true;
        }
    }
    // 不包含环
    return false;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_linked-list-cycle" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_linked-list-cycle"></div></div>
</details><hr /><br />

</div>
</details>
</div>




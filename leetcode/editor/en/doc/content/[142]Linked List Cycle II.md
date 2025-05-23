<p>Given the <code>head</code> of a linked list, return <em>the node where the cycle begins. If there is no cycle, return </em><code>null</code>.</p>

<p>There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the <code>next</code> pointer. Internally, <code>pos</code> is used to denote the index of the node that tail's <code>next</code> pointer is connected to (<strong>0-indexed</strong>). It is <code>-1</code> if there is no cycle. <strong>Note that</strong> <code>pos</code> <strong>is not passed as a parameter</strong>.</p>

<p><strong>Do not modify</strong> the linked list.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png" style="height: 145px; width: 450px;" /> 
<pre>
<strong>Input:</strong> head = [3,2,0,-4], pos = 1
<strong>Output:</strong> tail connects to node index 1
<strong>Explanation:</strong> There is a cycle in the linked list, where tail connects to the second node.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png" style="height: 105px; width: 201px;" /> 
<pre>
<strong>Input:</strong> head = [1,2], pos = 0
<strong>Output:</strong> tail connects to node index 0
<strong>Explanation:</strong> There is a cycle in the linked list, where tail connects to the first node.
</pre>

<p><strong class="example">Example 3:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png" style="height: 65px; width: 65px;" /> 
<pre>
<strong>Input:</strong> head = [1], pos = -1
<strong>Output:</strong> no cycle
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

<div>👍 13911, 👎 993<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/linked-list-skills-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

基于 [141. 环形链表](/problems/linked-list-cycle) 的解法，直观地来说就是当快慢指针相遇时，让其中任一个指针指向头节点，然后让它俩以相同速度前进，再次相遇时所在的节点位置就是环开始的位置。

原理也简单说下吧，我们假设快慢指针相遇时，慢指针 `slow` 走了 `k` 步，那么快指针 `fast` 一定走了 `2k` 步：

![](https://labuladong.online/algo/images/linked-two-pointer/3.jpeg)

`fast` 一定比 `slow` 多走了 `k` 步，这多走的 `k` 步其实就是 `fast` 指针在环里转圈圈，所以 `k` 的值就是环长度的「整数倍」。

假设相遇点距环的起点的距离为 `m`，那么结合上图的 `slow` 指针，环的起点距头结点 `head` 的距离为 `k - m`，也就是说如果从 `head` 前进 `k - m` 步就能到达环起点。

巧的是，如果从相遇点继续前进 `k - m` 步，也恰好到达环起点：

![](https://labuladong.online/algo/images/linked-two-pointer/2.jpeg)

所以，只要我们把快慢指针中的任一个重新指向 `head`，然后两个指针同速前进，`k - m` 步后一定会相遇，相遇之处就是环的起点了。

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
    ListNode *detectCycle(ListNode *head) {
        ListNode *fast, *slow;
        fast = slow = head;
        while (fast != nullptr && fast->next != nullptr) {
            fast = fast->next->next;
            slow = slow->next;
            if (fast == slow) break;/**<extend down -200>![](https://labuladong.online/algo/images/linked-list-two-pointer/3.jpeg) */
        }
        // 上面的代码类似 hasCycle 函数
        if (fast == nullptr || fast->next == nullptr) {
            // fast 遇到空指针说明没有环
            return nullptr;
        }

        // 重新指向头结点
        slow = head;/**<extend up -100>![](https://labuladong.online/algo/images/linked-list-two-pointer/2.jpeg) */
        // 快慢指针同步前进，相交点就是环起点
        while (slow != fast) {
            fast = fast->next;
            slow = slow->next;
        }
        return slow;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        fast, slow = head, head
        while fast is not None and fast.next is not None:
            fast = fast.next.next
            slow = slow.next
            if fast == slow:
                break # <extend down -200>![](https://labuladong.online/algo/images/linked-list-two-pointer/3.jpeg) #
        # 上面的代码类似 hasCycle 函数
        if fast is None or fast.next is None:
            # fast 遇到空指针说明没有环
            return None

        # 重新指向头结点
        slow = head # <extend up -100>![](https://labuladong.online/algo/images/linked-list-two-pointer/2.jpeg) #
        # 快慢指针同步前进，相交点就是环起点
        while slow != fast:
            fast = fast.next
            slow = slow.next
        return slow
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;/**<extend down -200>![](https://labuladong.online/algo/images/linked-list-two-pointer/3.jpeg) */
        }
        // 上面的代码类似 hasCycle 函数
        if (fast == null || fast.next == null) {
            // fast 遇到空指针说明没有环
            return null;
        }

        // 重新指向头结点
        slow = head;/**<extend up -100>![](https://labuladong.online/algo/images/linked-list-two-pointer/2.jpeg) */
        // 快慢指针同步前进，相交点就是环起点
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func detectCycle(head *ListNode) *ListNode {
    var fast, slow *ListNode
    fast, slow = head, head
    for fast != nil && fast.Next != nil {
        fast = fast.Next.Next
        slow = slow.Next
        if fast == slow {
            break
        }
    }
    // 上面的代码类似 hasCycle 函数
    if fast == nil || fast.Next == nil {
        // fast 遇到空指针说明没有环
        return nil
    }

    // 重新指向头结点
    slow = head
    // 快慢指针同步前进，相交点就是环起点
    for slow != fast {
        fast = fast.Next
        slow = slow.Next
    }
    return slow
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var detectCycle = function(head) {
    let fast = head, slow = head;
    while (fast !== null && fast.next !== null) {
        fast = fast.next.next;
        slow = slow.next;
        if (fast === slow) break;
    }
    // 上面的代码类似 hasCycle 函数
    if (fast === null || fast.next === null) {
        // fast 遇到空指针说明没有环
        return null;
    }

    // 重新指向头结点
    slow = head;
    // 快慢指针同步前进，相交点就是环起点
    while (slow !== fast) {
        fast = fast.next;
        slow = slow.next;
    }
    return slow;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_linked-list-cycle-ii" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_linked-list-cycle-ii"></div></div>
</details><hr /><br />

</div>
</details>
</div>




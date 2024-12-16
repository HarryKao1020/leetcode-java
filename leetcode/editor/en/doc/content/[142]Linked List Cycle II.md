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

**通知：[网站会员](https://labuladong.online/algo/intro/site-vip/) 即将涨价，有需要可以尽快购买/续费，谢谢大家的支持~**



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

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_linked-list-cycle-ii" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_linked-list-cycle-ii"></div></div>
</details><hr /><br />

</div>
</details>
</div>


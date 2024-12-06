<p>You are given the heads of two sorted linked lists <code>list1</code> and <code>list2</code>.</p>

<p>Merge the two lists into one <strong>sorted</strong> list. The list should be made by splicing together the nodes of the first two lists.</p>

<p>Return <em>the head of the merged linked list</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg" style="width: 662px; height: 302px;" /> 
<pre>
<strong>Input:</strong> list1 = [1,2,4], list2 = [1,3,4]
<strong>Output:</strong> [1,1,2,3,4,4]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> list1 = [], list2 = []
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> list1 = [], list2 = [0]
<strong>Output:</strong> [0]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in both lists is in the range <code>[0, 50]</code>.</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
 <li>Both <code>list1</code> and <code>list2</code> are sorted in <strong>non-decreasing</strong> order.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Linked List | Recursion</details><br>

<div>👍 22475, 👎 2201<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[网站会员](https://labuladong.online/algo/intro/site-vip/) 即将涨价，有需要可以尽快购买/续费，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/linked-list-skills-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

经典算法题了，[双指针技巧](https://labuladong.online/algo/essential-technique/linked-list-skills-summary/) 用起来。

![](https://labuladong.online/algo/images/linked-list-two-pointer/1.gif)

这个算法的逻辑类似于「拉拉链」，`l1, l2` 类似于拉链两侧的锯齿，指针 `p` 就好像拉链的拉索，将两个有序链表合并。

**代码中还用到一个链表的算法题中是很常见的「虚拟头结点」技巧，也就是 `dummy` 节点**，它相当于是个占位符，可以避免处理空指针的情况，降低代码的复杂性。

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

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        // 虚拟头结点
        ListNode dummy(-1), *p = &dummy;
        ListNode *p1 = l1, *p2 = l2;

        while (p1 != nullptr && p2 != nullptr) {/**<extend down -200>![](https://labuladong.online/algo/images/linked-list-two-pointer/1.gif) */
            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针
            if (p1->val > p2->val) {
                p->next = p2;
                p2 = p2->next;
            } else {
                p->next = p1;
                p1 = p1->next;
            }
            // p 指针不断前进
            p = p->next;
        }

        if (p1 != nullptr) {
            p->next = p1;
        }

        if (p2 != nullptr) {
            p->next = p2;
        }

        return dummy.next;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # 虚拟头结点
        dummy = ListNode(-1)
        p = dummy
        p1 = l1
        p2 = l2

        while p1 is not None and p2 is not None: # <extend down -200>![](https://labuladong.online/algo/images/linked-list-two-pointer/1.gif) #
            # 比较 p1 和 p2 两个指针
            # 将值较小的的节点接到 p 指针
            if p1.val > p2.val:
                p.next = p2
                p2 = p2.next
            else:
                p.next = p1
                p1 = p1.next
            # p 指针不断前进
            p = p.next

        if p1 is not None:
            p.next = p1

        if p2 is not None:
            p.next = p2

        return dummy.next
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = l1, p2 = l2;

        while (p1 != null && p2 != null) {/**<extend down -200>![](https://labuladong.online/algo/images/linked-list-two-pointer/1.gif) */
            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // p 指针不断前进
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return dummy.next;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
    // 虚拟头结点
    dummy := &ListNode{-1, nil}
    p := dummy
    p1 := l1
    p2 := l2

    for p1 != nil && p2 != nil {
        // 比较 p1 和 p2 两个指针
        // 将值较小的的节点接到 p 指针
        if p1.Val > p2.Val {
            p.Next = p2
            p2 = p2.Next
        } else {
            p.Next = p1
            p1 = p1.Next
        }
        // p 指针不断前进
        p = p.Next
    }

    if p1 != nil {
        p.Next = p1
    }

    if p2 != nil {
        p.Next = p2
    }

    return dummy.Next
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var mergeTwoLists = function(l1, l2) {
    // 虚拟头结点
    let dummy = new ListNode(-1), p = dummy;
    let p1 = l1, p2 = l2;

    while (p1 !== null && p2 !== null) {/**<extend down -200>![](https://labuladong.online/algo/images/linked-list-two-pointer/1.gif) */
        // 比较 p1 和 p2 两个指针
        // 将值较小的的节点接到 p 指针
        if (p1.val > p2.val) {
            p.next = p2;
            p2 = p2.next;
        } else {
            p.next = p1;
            p1 = p1.next;
        }
        // p 指针不断前进
        p = p.next;
    }

    if (p1 !== null) {
        p.next = p1;
    }

    if (p2 !== null) {
        p.next = p2;
    }

    return dummy.next;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_merge-two-sorted-lists" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_merge-two-sorted-lists"></div></div>
</details><hr /><br />

</div>
</details>
</div>


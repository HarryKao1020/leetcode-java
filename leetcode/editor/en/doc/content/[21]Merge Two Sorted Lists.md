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

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



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

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_merge-two-sorted-lists" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_merge-two-sorted-lists"></div></div>
</details><hr /><br />

</div>
</details>
</div>




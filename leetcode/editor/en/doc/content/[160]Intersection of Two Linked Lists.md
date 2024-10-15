<p>Given the heads of two singly linked-lists <code>headA</code> and <code>headB</code>, return <em>the node at which the two lists intersect</em>. If the two linked lists have no intersection at all, return <code>null</code>.</p>

<p>For example, the following two linked lists begin to intersect at node <code>c1</code>:</p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/05/160_statement.png" style="width: 500px; height: 162px;" /> 
<p>The test cases are generated such that there are no cycles anywhere in the entire linked structure.</p>

<p><strong>Note</strong> that the linked lists must <strong>retain their original structure</strong> after the function returns.</p>

<p><strong>Custom Judge:</strong></p>

<p>The inputs to the <strong>judge</strong> are given as follows (your program is <strong>not</strong> given these inputs):</p>

<ul> 
 <li><code>intersectVal</code> - The value of the node where the intersection occurs. This is <code>0</code> if there is no intersected node.</li> 
 <li><code>listA</code> - The first linked list.</li> 
 <li><code>listB</code> - The second linked list.</li> 
 <li><code>skipA</code> - The number of nodes to skip ahead in <code>listA</code> (starting from the head) to get to the intersected node.</li> 
 <li><code>skipB</code> - The number of nodes to skip ahead in <code>listB</code> (starting from the head) to get to the intersected node.</li> 
</ul>

<p>The judge will then create the linked structure based on these inputs and pass the two heads, <code>headA</code> and <code>headB</code> to your program. If you correctly return the intersected node, then your solution will be <strong>accepted</strong>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/05/160_example_1_1.png" style="width: 500px; height: 162px;" /> 
<pre>
<strong>Input:</strong> intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
<strong>Output:</strong> Intersected at '8'
<strong>Explanation:</strong> The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2<sup>nd</sup> node in A and 3<sup>rd</sup> node in B) are different node references. In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3<sup>rd</sup> node in A and 4<sup>th</sup> node in B) point to the same location in memory.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/05/160_example_2.png" style="width: 500px; height: 194px;" /> 
<pre>
<strong>Input:</strong> intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
<strong>Output:</strong> Intersected at '2'
<strong>Explanation:</strong> The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
</pre>

<p><strong class="example">Example 3:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/05/160_example_3.png" style="width: 300px; height: 189px;" /> 
<pre>
<strong>Input:</strong> intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
<strong>Output:</strong> No intersection
<strong>Explanation:</strong> From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes of <code>listA</code> is in the <code>m</code>.</li> 
 <li>The number of nodes of <code>listB</code> is in the <code>n</code>.</li> 
 <li><code>1 &lt;= m, n &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li> 
 <li><code>0 &lt;= skipA &lt;&nbsp;m</code></li> 
 <li><code>0 &lt;= skipB &lt;&nbsp;n</code></li> 
 <li><code>intersectVal</code> is <code>0</code> if <code>listA</code> and <code>listB</code> do not intersect.</li> 
 <li><code>intersectVal == listA[skipA] == listB[skipB]</code> if <code>listA</code> and <code>listB</code> intersect.</li> 
</ul>

<p>&nbsp;</p> 
<strong>Follow up:</strong> Could you write a solution that runs in 
<code>O(m + n)</code> time and use only 
<code>O(1)</code> memory?

<details><summary><strong>Related Topics</strong></summary>Hash Table | Linked List | Two Pointers</details><br>

<div>👍 15186, 👎 1372<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/linked-list-skills-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

这题难点在于，由于两条链表的长度可能不同，两条链表之间的节点无法对应：

![](https://labuladong.online/algo/images/链表技巧/5.jpeg)

如果用两个指针 `p1` 和 `p2` 分别在两条链表上前进，并不能**同时**走到公共节点，也就无法得到相交节点 `c1`。

**解决这个问题的关键是，通过某些方式，让 `p1` 和 `p2` 能够同时到达相交节点 `c1`**。

如果用两个指针 `p1` 和 `p2` 分别在两条链表上前进，我们可以让 `p1` 遍历完链表 `A` 之后开始遍历链表 `B`，让 `p2` 遍历完链表 `B` 之后开始遍历链表 `A`，这样相当于「逻辑上」两条链表接在了一起。

如果这样进行拼接，就可以让 `p1` 和 `p2` 同时进入公共部分，也就是同时到达相交节点 `c1`：

![](https://labuladong.online/algo/images/链表技巧/6.jpeg)

另一种思路，先计算两条链表的长度，然后让 `p1` 和 `p2` 距离链表尾部的距离相同，然后齐头并进，

- **详细题解**：
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
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution {
public:
    ListNode* getIntersectionNode(ListNode* headA, ListNode* headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode* p1 = headA;
        ListNode* p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            p1 = (p1 == nullptr) ? headB : p1->next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            p2 = (p2 == nullptr) ? headA : p2->next;
        }
        return p1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        # p1 指向 A 链表头结点，p2 指向 B 链表头结点
        p1, p2 = headA, headB
        while p1 != p2:
            # p1 走一步，如果走到 A 链表末尾，转到 B 链表
            p1 = headB if p1 is None else p1.next
            # p2 走一步，如果走到 B 链表末尾，转到 A 链表
            p2 = headA if p2 is None else p2.next
        return p1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else            p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else            p2 = p2.next;
        }
        return p1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

func getIntersectionNode(headA, headB *ListNode) *ListNode {
    // p1 指向 A 链表头结点，p2 指向 B 链表头结点
    p1, p2 := headA, headB
    for p1 != p2 {
        // p1 走一步，如果走到 A 链表末尾，转到 B 链表
        if p1 == nil {
            p1 = headB
        } else {
            p1 = p1.Next
        }
        // p2 走一步，如果走到 B 链表末尾，转到 A 链表
        if p2 == nil {
            p2 = headA
        } else {
            p2 = p2.Next
        }
    }
    return p1
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var getIntersectionNode = function(headA, headB) {
    // p1 指向 A 链表头结点，p2 指向 B 链表头结点
    let p1 = headA, p2 = headB;
    while (p1 !== p2) {
        // p1 走一步，如果走到 A 链表末尾，转到 B 链表
        if (p1 === null) p1 = headB;
        else p1 = p1.next;
        // p2 走一步，如果走到 B 链表末尾，转到 A 链表
        if (p2 === null) p2 = headA;
        else p2 = p2.next;
    }
    return p1;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_intersection-of-two-linked-lists" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_intersection-of-two-linked-lists"></div></div>
</details><hr /><br />

</div>

</details>
</div>


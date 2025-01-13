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

**通知：[网站会员](https://labuladong.online/algo/intro/site-vip/) 即将涨价，有需要可以尽快购买/续费，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/linked-list-skills-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题难点在于，由于两条链表的长度可能不同，两条链表之间的节点无法对应：

![](https://labuladong.online/algo/images/linked-list-two-pointer/5.jpeg)

如果用两个指针 `p1` 和 `p2` 分别在两条链表上前进，并不能**同时**走到公共节点，也就无法得到相交节点 `c1`。

**解决这个问题的关键是，通过某些方式，让 `p1` 和 `p2` 能够同时到达相交节点 `c1`**。

如果用两个指针 `p1` 和 `p2` 分别在两条链表上前进，我们可以让 `p1` 遍历完链表 `A` 之后开始遍历链表 `B`，让 `p2` 遍历完链表 `B` 之后开始遍历链表 `A`，这样相当于「逻辑上」两条链表接在了一起。

如果这样进行拼接，就可以让 `p1` 和 `p2` 同时进入公共部分，也就是同时到达相交节点 `c1`：

![](https://labuladong.online/algo/images/linked-list-two-pointer/6.jpeg)

另一种思路，先计算两条链表的长度，然后让 `p1` 和 `p2` 距离链表尾部的距离相同，然后齐头并进，

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
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

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
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

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
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

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

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_intersection-of-two-linked-lists" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_intersection-of-two-linked-lists"></div></div>
</details><hr /><br />

</div>
</details>
</div>












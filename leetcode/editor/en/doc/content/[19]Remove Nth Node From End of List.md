<p>Given the <code>head</code> of a linked list, remove the <code>n<sup>th</sup></code> node from the end of the list and return its head.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg" style="width: 542px; height: 222px;" /> 
<pre>
<strong>Input:</strong> head = [1,2,3,4,5], n = 2
<strong>Output:</strong> [1,2,3,5]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> head = [1], n = 1
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> head = [1,2], n = 1
<strong>Output:</strong> [1]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the list is <code>sz</code>.</li> 
 <li><code>1 &lt;= sz &lt;= 30</code></li> 
 <li><code>0 &lt;= Node.val &lt;= 100</code></li> 
 <li><code>1 &lt;= n &lt;= sz</code></li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Follow up:</strong> Could you do this in one pass?</p>

<details><summary><strong>Related Topics</strong></summary>Linked List | Two Pointers</details><br>

<div>👍 19354, 👎 829<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[网站会员](https://labuladong.online/algo/intro/site-vip/) 即将涨价，有需要可以尽快购买/续费，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/linked-list-skills-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

要删除倒数第 `n` 个节点，就得获得倒数第 `n + 1` 个节点的引用。

获取单链表的倒数第 `k` 个节点，就是想考察 [双指针技巧](https://labuladong.online/algo/essential-technique/linked-list-skills-summary/) 中快慢指针的运用，一般都会要求你**只遍历一次链表**，就算出倒数第 `k` 个节点。

第一步，我们先让一个指针 `p1` 指向链表的头节点 `head`，然后走 `k` 步：

![](https://labuladong.online/algo/images/linked-list-two-pointer/1.jpeg)

第二步，用一个指针 `p2` 指向链表头节点 `head`：

![](https://labuladong.online/algo/images/linked-list-two-pointer/2.jpeg)

第三步，让 `p1` 和 `p2` 同时向前走，`p1` 走到链表末尾的空指针时走了 `n - k` 步，`p2` 也走了 `n - k` 步，也就是链表的倒数第 `k` 个节点：

![](https://labuladong.online/algo/images/linked-list-two-pointer/3.jpeg)

这样，只遍历了一次链表，就获得了倒数第 `k` 个节点 `p2`。

解法中在链表头部接一个虚拟节点 `dummy` 是为了避免删除倒数第一个元素时出现空指针异常，在头部加入 `dummy` 节点并不影响尾部倒数第 `k` 个元素是什么。

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
    // 主函数
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        // 虚拟头结点
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode* x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x->next = x->next->next;
        return dummy->next;
    }

    // 返回链表的倒数第 k 个节点
    ListNode* findFromEnd(ListNode* head, int k) {
        ListNode* p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1->next;
        }
        ListNode* p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != nullptr) {
            p2 = p2->next;
            p1 = p1->next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    # 主函数
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        # 虚拟头结点
        dummy = ListNode(-1)
        dummy.next = head
        # 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        x = self.findFromEnd(dummy, n + 1)
        # 删掉倒数第 n 个节点
        x.next = x.next.next
        return dummy.next

    # 返回链表的倒数第 k 个节点
    def findFromEnd(self, head: ListNode, k: int) -> ListNode:
        p1 = head
        # p1 先走 k 步
        for i in range(k):
            p1 = p1.next
        p2 = head
        # p1 和 p2 同时走 n - k 步
        while p1:
            p2 = p2.next
            p1 = p1.next
        # p2 现在指向第 n - k 个节点
        return p2
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 主函数
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    // 返回链表的倒数第 k 个节点
    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 主函数
func removeNthFromEnd(head *ListNode, n int) *ListNode {
    // 虚拟头结点
    dummy := &ListNode{-1, head}
    // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
    x := findFromEnd(dummy, n+1)
    // 删掉倒数第 n 个节点
    x.Next = x.Next.Next
    return dummy.Next
}

// 返回链表的倒数第 k 个节点
func findFromEnd(head *ListNode, k int) *ListNode {
    p1 := head
    // p1 先走 k 步
    for i := 0; i < k; i++ {
        p1 = p1.Next
    }
    p2 := head
    // p1 和 p2 同时走 n - k 步
    for p1 != nil {
        p2 = p2.Next
        p1 = p1.Next
    }
    // p2 现在指向第 n - k 个节点
    return p2
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var removeNthFromEnd = function(head, n) {
    // 虚拟头结点
    let dummy = new ListNode(-1);
    dummy.next = head;
    // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
    let x = findFromEnd(dummy, n + 1);
    // 删掉倒数第 n 个节点
    x.next = x.next.next;
    return dummy.next;
};

// 返回链表的倒数第 k 个节点
function findFromEnd(head, k) {
    let p1 = head;
    // p1 先走 k 步
    for (let i = 0; i < k; i++) {
        p1 = p1.next;
    }
    let p2 = head;
    // p1 和 p2 同时走 n - k 步
    while (p1 !== null) {
        p2 = p2.next;
        p1 = p1.next;
    }
    // p2 现在指向第 n - k 个节点
    return p2;
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_remove-nth-node-from-end-of-list" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-nth-node-from-end-of-list"></div></div>
</details><hr /><br />

</div>
</details>
</div>


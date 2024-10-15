<p>Given a&nbsp;linked list, swap every two adjacent nodes and return its head. You must solve the problem without&nbsp;modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">head = [1,2,3,4]</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">[2,1,4,3]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/swap_ex1.jpg" style="width: 422px; height: 222px;" /></p>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">head = []</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">[]</span></p>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">head = [1]</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">[1]</span></p>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">head = [1,2,3]</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">[2,1,3]</span></p>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the&nbsp;list&nbsp;is in the range <code>[0, 100]</code>.</li> 
 <li><code>0 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Linked List | Recursion</details><br>

<div>👍 12085, 👎 455<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**

<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

这道题不难，常规方法就是维护多个指针，遍历一遍链表顺便把每两个节点翻转。不过迭代的思路虽然直接，但细节问题会比较多，写起来麻烦。

所以我直接用递归的方式来写，只要搞明白递归函数的定义，然后利用这个定义就可以完成这道题。

其实前文 [如何 `k` 个一组反转链表](https://labuladong.online/algo/data-structure/reverse-linked-list-recursion/) 中讲过的 [25. K 个一组翻转链表](/problems/reverse-nodes-in-k-group) 就是这道题的进阶版，你可以去做一做。

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
public: // Ensure that swapPairs is public
    // 定义：输入以 head 开头的单链表，将这个单链表中的每两个元素翻转，
    // 返回翻转后的链表头结点
    ListNode* swapPairs(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        ListNode* first = head;
        ListNode* second = head->next;
        ListNode* others = head->next->next;
        // 先把前两个元素翻转
        second->next = first;
        // 利用递归定义，将剩下的链表节点两两翻转，接到后面
        first->next = swapPairs(others);
        // 现在整个链表都成功翻转了，返回新的头结点
        return second;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

# 定义：输入以 head 开头的单链表，将这个单链表中的每两个元素翻转，
# 返回翻转后的链表头结点
class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        first = head
        second = head.next
        others = head.next.next
        # 先把前两个元素翻转
        second.next = first
        # 利用递归定义，将剩下的链表节点两两翻转，接到后面
        first.next = self.swapPairs(others)
        # 现在整个链表都成功翻转了，返回新的头结点
        return second
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 定义：输入以 head 开头的单链表，将这个单链表中的每两个元素翻转，
    // 返回翻转后的链表头结点
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode others = head.next.next;
        // 先把前两个元素翻转
        second.next = first;
        // 利用递归定义，将剩下的链表节点两两翻转，接到后面
        first.next = swapPairs(others);
        // 现在整个链表都成功翻转了，返回新的头结点
        return second;/**<extend up -200>![](https://labuladong.online/algo/images/kgroup/7.jpg) */
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

func swapPairs(head *ListNode) *ListNode {
    // 定义：输入以 head 开头的单链表，将这个单链表中的每两个元素翻转，
    // 返回翻转后的链表头结点
    if head == nil || head.Next == nil {
        return head
    }
    first := head
    second := head.Next
    others := head.Next.Next
    // 先把前两个元素翻转
    second.Next = first
    // 利用递归定义，将剩下的链表节点两两翻转，接到后面
    first.Next = swapPairs(others)
    // 现在整个链表都成功翻转了，返回新的头结点
    return second
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

// 定义：输入以 head 开头的单链表，将这个单链表中的每两个元素翻转，
// 返回翻转后的链表头结点
var swapPairs = function(head) {
    if (head === null || head.next === null) {
        return head;
    }
    let first = head;
    let second = head.next;
    let others = head.next.next;
    // 先把前两个元素翻转
    second.next = first;
    // 利用递归定义，将剩下的链表节点两两翻转，接到后面
    first.next = swapPairs(others);
    // 现在整个链表都成功翻转了，返回新的头结点
    return second;
    // ![](https://labuladong.online/algo/images/kgroup/7.jpg) // This line is a comment with a picture reference which is not valid in this context.
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_swap-nodes-in-pairs" data="Gz8nERWkHQDoPLAbPs6ozf3iYVqqD+eGI3yEGvf+n7OqWneq3YygjF7IyUf4KAZAwTSh6Moza+9PeXQGkt1Upe8dvVn4A/MMOYzCb3DCgcA1cGzv0f34tX/9LkAbAJwQ2GhgBawQdDIzd08Q978A8s69AWLFUFlFskKKpipx+cZVtsvImaGeY/XHsUIIQwlw2i7fAMcm8pb+Obu1rkyJcWrOsfmEgcdC7kshBxuSWJ+he7U4Joa3K4S2iu7naLl2qULAvi46iqvp7SQWG8nEhqgW/WV+Zk4k7Iy8nxK8LMdgmWNjbH/VgkEAQ+uNhZpDMi1NEJZ1hD0BqqlNLeY9PIuGnR5/Y+F3nPFltKa3IpaCN+nY409hy1aD+lTX+KmcBVFF1yOefX33+DRLBVm7MQthMqv27JdPPFnuGqxP4Bq+jlXMRllHEOMXHvdxjEK3CaRcnQ+hjbhmPjb7iLxSFnXAf0RJ3sYBH44qoluEjyABpkvz0qMfST78nf386RfHNO0HMNQ8QPQ4qcp6GxgCLaAGPlHmRRW0/gQUz1QK4VM3r7Idzt8VBY/el3MGfpF86pgtEdGjRP/rAad1F6Ejw3Bh8poVRg4tOI7dEnl0OgxoAv7jeSwRfdxFjc6NnS0wgLNHD7R2c5h93p0P8rkGIE8elWf3kiWqINSC/tjFcFS82hqMRjC7Q1t/OJ+faRwuncKEDIYs7FyOP0rxBiq/yXPEuxn2fwrHI+aqxEPUhuD7Lo5Xe8UjsDx6GALdUmXdz1348fv23Y8VO0RKCH7KwiL16O8/WOyAZgj+phQ5+ntbJpw9KkBmFry17wp7ZW85qjAFjEIqAOftM4XBCse55INz/5CQowo7AsmAav/IAjK4fOL0FlRCigXrRZhj5I0beCh1exPQwUd+/VDLjzOzHOWTfBKA8gcfTY7iNY0PmIAkE+tbJ49S5fJwnLJheHUcEuq3SX/kRDZFRqldJOeT3+pdzkmkwOfQPZR/HrfnhPDuOCs49w1EDp4YHQO49oW9BJhXz5bP118eZKQtO76qAV5exR0Y5da21kZIx31Kpm3mYC444e81Ul0zAcFak2MTX9dCjg1e8jAPyeP6yjWfLjhJJIt9oDHZUdL/OTazCdVkFMZyIRagn5VMEI31QigAfwluUoJRhayAWVICHpsATEOpRcg8XlRBnQJ4zHR4wXbKM7ybTM5ouiUNJRqdHXtZ1ZIrhdOQmvWyhsH3NHkVrJjLY65aP8LENSHRVCMMqVwgmszeup4CaXicecfe7Umq1iczXhoXMjqsC9nBIXeKK03mkoxT3nltP4GilpVru/ib3p1IrXimroEIV1pIWZbappNSVRdR0rijN440lc1KpG86ThQgq2ZtkYKicRQ5kka+B561lnlWrRm3CCNQ5aJ6zfy4+yNrW2DmSD1z1mvrYi4q2zkBne0CikSzzYx7pacOVe2wHdwsITjT3HG06MQnUORG2tXSoR17Uob4HGMieAzRFBypeUwEjz5J67SUDvY+y1W1rzWaej1qo7VV2oT8ESaw5UEVSr8mbgT02a5aMilu8fXTyxO5NZ8Ut35CiwZaVTGPxJCLlBvTteZLE9rH+rntgV/c+1wzzFHOdZiHdbhBC49btSzs2kdoEzJmIxvPTpz6pf5msxD6bfkSMV3qql2tUMDA5gEvtrl2guC6PRZhDgANhHwkwuDeez/Qt+uuEzR5bCJa1QF+m8ct6xxIc1SFZdskj3R59jq0KXRN5gyd5uWeVlYhxoMtcAMytDfOLe15tKZ4/XEuPZ8cxZWqNqz0gs+gQ0tvacPDXhjHNnd1PHpdY2/TtEIWUuCJC82qYtMKN9sTdGkm2Ttb9Uwb1sDuZktK3TZb0szY24qfQJHblcYeLkFYCV8/vdTvW7NawGgcMEgD8iG+JBhHHncZcKbCQKqrmdTWepyI1XKoLjUabfJjOvQsTgEtcoPVMtH+WSlRCDaWVQqpQnHDj6oa5ekkIHAkUckd6Cw/wURLfbeUbNF34GOGqAlt5Rb9qeJVbEy7tWUCahA1MFOAoNoTl11zrqcuikpNQBNVIwuo+AQA1RrrPWovVguVlABoXcQCqhwWbM0CMO1UKZWBU7QawRictCjEVdcp1ECgTNANgSwZ1X6+RLhVY47pgmALFIJeFPINLgpFQVwcFAhcJu6QchqQ0P/pxU20q25F/2ffL+6/vrxW4k8lFKpvdv4vlWd8Esmq8b+s/a/ISgswQWOBn5M53RaPiaXeBorImX7wADN+o53P6TA3NxGYW1udNuXWpg/q5jJMXjv7sACLFXzj4an5SZjIx9oNbQzMecHiR7P8pTcSGhUgU/93QJXjk2hyUB77GMFfGC1kRsqVp3t1xiIzclx2rT9GzgfPA21nWLa54CzaG0uiKOpnLG4ld+/eFY6edfh3nLe4ETqwxGeHhxidcltryvHf2S0Eudspd81AT3sFyaJ+GBMqBtyyNRbH/S+g2OV5OCnyYFiuMvqPxkRa0o1jI5YhUjuKWRxkNerzV0UPdyiq89N5T/mqFFw3TYi0BcfjJ8FtWslO+rkGfAW7osqNciRXffUQbV3TdtqaKNgvr8gfj4/mmzcliXQw7psXQB1VvONAIN4nnxL1VGcBUgE/FWZV3DMlfoKMelrgNw3Kmcnaa3ICN9pAuCHEnEgmv5NDK33GGD3kQF6ybraBOZ7VxVhXoyKN8K4na5+eX9/Ies26aYS8Zt5spdQmnhkSgTl+94dTWGc1JxTt7EJg3Ww9xHJjQzQbDsufOmkzTjsTj2iMOycthMiwVOXBqnj0MP099PnVZQKh+D47u513Otk0yaxkZaO/owm6gyjEocmZ3G8sFce+XE4xzn+2NVex6KWRGIFW464Qt47AK0pf38i4BGIUBVVSG00PycKoySop7/G1bh/psf33uAE="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_swap-nodes-in-pairs"></div></div>
</details><hr /><br />

</div>

</details>
</div>



wap-nodes-in-pairs"></div></div>
</details><hr /><br />

</div>

</details>
</div>


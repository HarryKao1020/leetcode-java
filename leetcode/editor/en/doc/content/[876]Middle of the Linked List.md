<p>Given the <code>head</code> of a singly linked list, return <em>the middle node of the linked list</em>.</p>

<p>If there are two middle nodes, return <strong>the second middle</strong> node.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist1.jpg" style="width: 544px; height: 65px;" /> 
<pre>
<strong>Input:</strong> head = [1,2,3,4,5]
<strong>Output:</strong> [3,4,5]
<strong>Explanation:</strong> The middle node of the list is node 3.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist2.jpg" style="width: 664px; height: 65px;" /> 
<pre>
<strong>Input:</strong> head = [1,2,3,4,5,6]
<strong>Output:</strong> [4,5,6]
<strong>Explanation:</strong> Since the list has two middle nodes with values 3 and 4, we return the second one.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the list is in the range <code>[1, 100]</code>.</li> 
 <li><code>1 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Linked List | Two Pointers</details><br>

<div>👍 12008, 👎 385<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/linked-list-skills-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

如果想一次遍历就得到中间节点，也需要耍点小聪明，使用「快慢指针」的技巧：

我们让两个指针 `slow` 和 `fast` 分别指向链表头结点 `head`。

**每当慢指针 `slow` 前进一步，快指针 `fast` 就前进两步，这样，当 `fast` 走到链表末尾时，`slow` 就指向了链表中点**。

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
    ListNode* middleNode(ListNode* head) {
        // 快慢指针初始化指向 head
        ListNode* slow = head;
        ListNode* fast = head;
        // 快指针走到末尾时停止
        while (fast != nullptr && fast->next != nullptr) {
            // 慢指针走一步，快指针走两步
            slow = slow->next;
            fast = fast->next->next;
        }
        // 慢指针指向中点
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
    # 快慢指针初始化指向 head
    def middleNode(self, head: ListNode) -> ListNode:
        slow = head
        fast = head
        # 快指针走到末尾时停止
        while fast is not None and fast.next is not None:
            # 慢指针走一步，快指针走两步
            slow = slow.next
            fast = fast.next.next
        # 慢指针指向中点
        return slow
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        // 慢指针指向中点
        return slow;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func middleNode(head *ListNode) *ListNode {
    // 快慢指针初始化指向 head
    slow, fast := head, head
    // 快指针走到末尾时停止
    for fast != nil && fast.Next != nil {
        // 慢指针走一步，快指针走两步
        slow = slow.Next
        fast = fast.Next.Next
    }
    // 慢指针指向中点
    return slow
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var middleNode = function(head) {
    // 快慢指针初始化指向 head
    let slow = head, fast = head;
    // 快指针走到末尾时停止
    while (fast !== null && fast.next !== null) {
        // 慢指针走一步，快指针走两步
        slow = slow.next;
        fast = fast.next.next;
    }
    // 慢指针指向中点
    return slow;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_middle-of-the-linked-list" data="G1MxERWk40RUcAYAaHHAk0HTW3iwEpuBQTH9dCeETosrDtJs4TcDyN72S2UPVJO9ZufxVgEeUAn4Cyf7N+fjtGdLxw5zat9+znvAQ1GKhaagsCOdsNf3Tg1sN/aNxNa2VB+TsYpet0gXkfihRey+tde+quSKCbvS1U1k/VcFAodkf3fnMiUiSbM3+/cHWRWIta92JwuoXONX++lMHYNwprdwrwCsASXtZhO2EebL6rg6klUVssuYajzTarvPSQjh1AI6t7/xu/fE844+GlPsPhQr1Bjvg2sMHO9Tk+aI1qdj/nV5X0VbiSYuOHSrH9K48Vr+/kuFIgj9o1ElrOenTNwCLVt2eDvOyEJVDM0av3ZwS8169VvFDa31/pKAEPlcI3JZdVM3TfhJL2RsBu3sNIxxJKzvbWoJs3KLT1Nb6C2OmdOdiEqqUz8OxZnGMiTPU1sDrS9eU6RNAH6hxChxX9DB1SQxjXwYGA84gSBm2bvu4r/B3LIkL61gnp+DlbSgjo2f3uI7cJVQLxQa9JbvOCsprlztz29sfUY4B/6RQ+zfHwtZgn125oq+sRMVZ7qm7rMAIQHSeSEFgnxoVQzc3dNY6p5D5PSJU4dOKSgLkpGrRI/gWsGahKOQXGIZhcTJrTwoT4Owc052LL1bsxSTHpEBmAihqkosUCWEXxBmxs4YdWmKKiy7exFTnKoOyfbSF6jvEUyWETqVjhTqCxb8Rp+fN846qcbxwqZk9flA+h23eC3Pz8EtIfcx0y9lCY+wTETQZYQiybjnqj1noq5yha0erHA0RN6bHWRcDG3Ay5XQMUqR4sZIf93MnxNDv8n+wmBNYuVkgKPN9LCmkmdiFm//zjlnTK4CY1bKZUDkkP2OAEqhZw5FXM7sG5TocbemZ/E0UXqalQoRQBLkhN9EtCPwd0svB4nQPzPK/MPGHfmmLJcRlooIDoQiubjte/fJnwx/8SEiOmePb0Y7olKGf2dEnGT/6A9G9juC6VgOczTfjHcyPQTfzuHcH4TIdgQzzegW+TcT3Q+bduSbsmRGWCoiOBAKO9zJ790n7TJEORfoDr6d0hGVMnw7FCfZQx0hT4RABjmEy/d/BZiIHPn+1VFHrzXQ9l8iOCeNxcj2+Io93OV74l+/v314heutdqDy3fNp2eoCId4vvc1+1rQ7UQl7FPbaJ53keqr2X15JjcF6JqwylO3hjC/HJWNOc/UiYTLPGU4k0o4xLAZYdkLB3xep8FfLMiyD1mX4yWOPPPXYc0888tQTfOFRDQ2tStGLtl7TitqD+EUIyTw10xzlsaVpTa9EuOSHwRkTenXCJoOZnBnQq9Igg/HkzIRemQYZjD1qJvQKGmwBNMtJo9dXIJ2bIMve2pYgcgeIRjtI6NhIkUmBdlcdFBgbpfyYfRjqG0JnMqf5DDO5nHajMzmSvSEzWWTT9zPLpuzNqirWo2B/ImRNrEhQcQcUFgyRuKnoKFCB4uvhaecAvo/gIe3kkrZT2ulwqcK9mtAW1ZouGsfxPPQgblgagQEseV8GLPMQA8leyuY3hcJm8O3tuG6/hS0QrzkYLLfBelCx3rwuDHP1e+MBKWhuC6G2GmPAXqpmT5313iAQBMXOgWBZHNbD2q0LxaNDxYBUcomqHRf2Bsc2HFNwZC12A8ONufFwYawH0B251g3BsBG0Plek1oTCtEER21lUe0JhOmBuu/dVN08TNsEkcGmoqFRYD3pgX9Vzrl4uQFl8O4WkCtKEDXDEkqCp9d/tEVSJW1GliJgipLXUUbVpFAP7FAY3UdsF42fRMJSs4K9GNIQIIO6VUc0kNdDiXADvdevut65doKIJ5rImF9PWcdelOqEtqKrqp7yDKjNJWu7i6mJ0G1xT53lK+FsCCBKzUMFCeEyeh/7DD65v7167y9wMeL43d2A3lDpBLoydbZ3V002w7PSJuGRtxX0aAarU9apRI1VQi3vEoaaOG2/n4QMMXaYTrWYbbKjwqriKajB7SXrVzJRp5V1lTwnVTbOnATDQEFywUA+3WHUMjrHIR19JhEOL2kHBtuAohdyiu9x+0Q39SL9RwdZLaN52hsJL/Pe7rWNqbvFtoLawWA+BR2CDP3dgduhmAglgz0sxWGKOLWCLAVrlu9MAON8iVTpPaQXcta/ttuvzfRrDTZ4KaOZj0EkWvftlkkNQHpENYPTVb89oBzwgRCxdYzo9HpJPjhNAserM7tpE3sQX0wMHHGhUNFegUQVxuEIbbujblB+41S4tasgzirNxv7qbJtpWjlf/a0X+3qeOyDUD7eKrZsbwxAwZ4liPy+vGgGxs2YC8cAzI5saAHGzoOORRrSJyoTEgnwlwOckAkFcMALlBgMvvhYAcHaCueqLGrb1pzm2Rhvpdj5UybKusBLZ5JnsvKemB3ru9cCiCvgKeq9IuaALLBXoFK6AvsCqMEbBm6GOsGfocq8IYZ6wZ+ghrAuYwRVfCdyrta3ZL+DYxqBDf/z7ld+/hfCCEEMTaz2zz/9eikQw+iQjhJqfDaDJ4BBFDZhk6d6YuAzVUSnUMtF5J4SCnN3o84ql5yVNZ1g3IL1o4xPCy/9YBng46dYbvwja8Bx3b6I0qMKFwsCNihbS+u1u5Tf697Px+yHhenbAtUTROJxoLFcMkS59sAnJtIG7b9D8M0azQncAwiGX3K3lcs+xwcdUpHYN2o2H2zEuTw7rG6ROF5cOjLqnm61Qn6D76iowyTXm/OvSrN/G3bGW9o66+BnRe0yL9PuKVCNHcR7EtdG6eK/I9yY1e8HkqrC/mtEZlF2FdpN8kIMkiKUogB+Cl+LTUEZLoQjH/sovESZMnSrI/YUoqi9d7IUSChUQWWvSdw9gfdjlSTct+Ytck1QD68QCKadRiyLl9IrUpZT9SBQypjVqeokAfTzPyqMtQ8IyQTwtbe1bs4ighn6rdYbfMieaWL+lnRS6or1Htzlj8UDjGq9lt+Qy8gtBWUIkh3fPOai5rf5ygM+Dr+QnT0+B7WY5/+bvsFp9ZyD3a6UtvWQREp6nWoE/EduFMHJYn2ht/rTu+eUaapA7Tj80lXeAe8EAZU4eLjNodzSdx9me5a1oL5Roo1gH5BETFGvx5YsQM2dawGsMuhL4eebUMlTVWoL7CKu6NpJoIuuQ6CWLp7VhVZ5Hi29oM6uQrypaM3dUxptsk/Fzgd0/a6c7qZb34cI6F0Q4A2Qt2oN0H39LEZYR4tpkqGMvz53ljuqRV1QA=" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_middle-of-the-linked-list"></div></div>
</details><hr /><br />

</div>
</details>
</div>






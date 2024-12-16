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

**通知：[网站会员](https://labuladong.online/algo/intro/site-vip/) 即将涨价，有需要可以尽快购买/续费，谢谢大家的支持~**



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

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_middle-of-the-linked-list" data="G7EkEZWjpQBocWA3cz6FUc9W1QkEp3dX4T4DhEiI8Kk1LcTDfkbAkst6EU7y5Qr62n/m9v/TfocJC3H+2duLf4hULFol26Y176hrD3wq6ODA6CIFxltF7c7jvilZ2YHDNc8ix1rtcSjh97/2WqAtIE0dyjoExxJBJzNvcoO4BSK7b9/fFJB+iYVGI6pktav8pypGVsZCNuUihcLm0Y8u4GUbl9/tkXjrn5bIOnFM7H5aItvjDgNXqWOT6GBDkuqltgPimBg+aKms6Q5ReOaqf8AkEoCfFoarweskFhv+D66kFn0Ta7zlWUyeSviqaA5btT3I+ovWAIOo977WgN0p+xt6HDBz+wBC9XYMq4BPH5hF5HgmydmLa9My39OBdZwv6DjEnyY+R56z+7Ex84UJMjQZx5wjIsUuZx2bpDqaXK8XbiAwnXceUvjXyA6+gcOjD9GzNFf9wk85XzbWEvoBeZinlGDEkP/O573/SvoTohRiCHTH+vG6Kril1YJjeKgDV2jlRs3npQgq+xUMkKDzyNXh0GvscVW9M41cuHSIvFNCab2ZYQGhctiPVKgHlwcUA0EKFLQ5ouVM0criu55bppJ3BNNU9qLHdbKo2zFCAbkAIKdx8oKy4K3gkhI5Cbh5ZhPX6JXx5/SkvBJ5WgWv1KcD7s9zKiyNT4PPiWgCBfnp7jV4P7qeb/RC5S7P8KpZe4xEIfT/e3Seabd0wUIoz1QUwNnooPVkOYR5d648olFRIVSNbTZ2i0ZBpdyxm6xDosclSIyON2BPul61SIV+jf7f512FfGWOjv6e0NmBKBcq5CtzYfT3MS04Gx1zrWP/WBJ6dKDAhcS+6sc0QGR0LAh5LdkldHf/vuz+0jo9OhJ6diDKiYRULoyOK6RJuBsJSGnnWwUmJQhwviWEOiwvwVRpIJ7RUGUNfrgnc8vNj/3iAHcWtQvoF7/ID3Ra8lKnG5e5fXLh7F31ZqFbufaN27yORtYB84ELMsUHSgJn+eN/l0+JSpoL24nt4Z5yHdLzeOl5veH5PHl+L8wyxCoPROof5aog8svVpDC7zjwOdYBlYQTBRX5H0CyMMOAmA7WrhRESnIFmnYURHJyBOSoLIxJcERfJdpF4Llb2N6gsLhsoruErWTsdfNoUfc5ZLuaz7xCsKYbyTZ1I0UjTgqoH3roFlc7b6AXlCHljCyqNocr5V3m1JOu/JkgpIzuvcqgzYbHIv/HTovlZOBdWo06CjJ9lVQO+C5Kl5zavTC6sMqFKOrln7CR2TQ7hxhq6qG+Ww4ORT2GSZll/bRIjXDhlB2D0JJMcN9lnGQOJo5LbrKkAI2VyvWTlT9z7dYdgYKYR3d3nfSJOUjhMj87s+yrACzJHXVaz1gmcvPSNmLMg1CYXztLz3sp4kN74jPTsEWC00q6M5oQYYJTWKrHs6AxBxqQ9Y1/5EEME850l7ysfok9My2Rkx+sQSXbb+4JVgCGMNMF34gO61QcoA7W4acsrh0I4AVPc3aTfKQvaWM6W14pBi85e9Yb30K9NEtbd9ypTWOMSArfnF339Y1bm6OZbI7y7/1rD7oF029Txgv7ZB5LZKBTOx5OX9fdyuJqwfLEOyx5qPQkMYOqlD+knMvT9ssl4doBSgSQlg4e+z6JQXPuJ4DHuWpivAf6QNzfYDsHNEcyK337GqGeoQ3uyBrMbOsUnQQod6OCd8HnFIrSJLryr59Uhr8fH0sviKCZiUut4XlfoUERrS3w4BMuxvQyRn6xr2dsTIoy+BB5X6KW7LlLoWYDAaYeG+JaC8bDiVc+iE3Bkry96od52+i0kHXfEQ/5OrIxc+69T1p+DThg/4igNYBQGZ+JE957kZLYJcIAihF6YtbgYqIxRHhf7em2y67l6Xs0OLdriPN/65/t9rd9I7DaEB2Brv8P3gSDj3OuacTCq0R9liPJHXBD2i862VWFODOMszyRjaXXNUNDDTMAE0VOlsHf5araB09FY39YOTHt0z+d96opufscqVubZzPqXKSdyUnw1iCYo/kZZrUn1Lt1xeAs0/9Hcc5tA684NNObcQNvNDTT93EBLzw4OGnQOLW232UDzzAZaYQ5oY8sG2lQ20HQKB1pIQM7/rIIcSMQ0hzgvHr8mm6xnzXINRI8Vk3ak2+ljJ6Wd6uJyvYloNRqFlESsGtQLjIp6jdGgmYhRUc8xKuoNjAbN3DAqGghj+h6LXK9IzPK2IoFZWHuPSl6r/JvM6G1GAOB0ok4R8MXAYrwKQGclsCn55LLHZsBG41BgSzg+zBUvX9CDEj/wxkdYXXXbfwxnxHUybBZU4eRRYsxQuttwqEmCvZdF/wJHKj94+xfsWWoRkYVjtxXvaTL/nGz58KV4fIviAl23zpepCJ1AJAXpk0lhXln+Xp1/kWjR8AYsg1gOP8iTDRN9QfsLAg3QDgPtPn9x3Ns5jUOBkHt8VF+jFEGxDWXwuyMgJoWTPh/U8WeySTY/c6Kau4fNu2GLPd1Xrhr7ms4/JIOTnZM4Gebcalx5hR38nu8B7i9WwpEYEGK/sGU2BD4+nn1NnpVCq5sPSR4XRf/lS1sK6ay8bvPEZeNbqzdy7lgrQOqXUiZl0+pXGg5J/cAIIbLQt4i0xuo2bmzttMYjXGb9nWU=" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_middle-of-the-linked-list"></div></div>
</details><hr /><br />

</div>
</details>
</div>


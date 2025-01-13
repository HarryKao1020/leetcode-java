<p>Given the <code>head</code> of a sorted linked list, <em>delete all duplicates such that each element appears only once</em>. Return <em>the linked list <strong>sorted</strong> as well</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list1.jpg" style="width: 302px; height: 242px;" /> 
<pre>
<strong>Input:</strong> head = [1,1,2]
<strong>Output:</strong> [1,2]
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list2.jpg" style="width: 542px; height: 222px;" /> 
<pre>
<strong>Input:</strong> head = [1,1,2,3,3]
<strong>Output:</strong> [1,2,3]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the list is in the range <code>[0, 300]</code>.</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
 <li>The list is guaranteed to be <strong>sorted</strong> in ascending order.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Linked List</details><br>

<div>👍 8845, 👎 315<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[网站会员](https://labuladong.online/algo/intro/site-vip/) 即将涨价，有需要可以尽快购买/续费，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/array-two-pointers-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

思路和 [26. 删除有序数组中的重复项](/problems/remove-duplicates-from-sorted-array) 完全一样，唯一的区别是把数组赋值操作变成操作指针而已。

![](https://labuladong.online/algo/images/array-dedup/2.gif)

**详细题解**：
  - [双指针技巧秒杀七道数组题目](https://labuladong.online/algo/essential-technique/array-two-pointers-summary/)

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
    ListNode* deleteDuplicates(ListNode* head) {
        if (head == nullptr) return nullptr;
        ListNode* slow = head;
        ListNode* fast = head;
        while (fast != nullptr) {
            if (fast->val != slow->val) {
                // nums[slow] = nums[fast];
                slow->next = fast;
                // slow++;
                slow = slow->next;
            }
            // fast++
            fast = fast->next;
        }
        // 断开与后面重复元素的连接
        slow->next = nullptr;
        return head;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if head is None:
            return None
        slow = head
        fast = head
        while fast is not None:
            if fast.val != slow.val:
                # nums[slow] = nums[fast];
                slow.next = fast
                # slow++;
                slow = slow.next
            # fast++
            fast = fast.next
        # 断开与后面重复元素的连接
        slow.next = None
        return head
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                // nums[slow] = nums[fast];
                slow.next = fast;
                // slow++;
                slow = slow.next;
            }
            // fast++
            fast = fast.next;
        }
        // 断开与后面重复元素的连接
        slow.next = null;
        return head;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func deleteDuplicates(head *ListNode) *ListNode {
    if head == nil {
        return nil
    }
    slow := head
    fast := head
    for fast != nil {
        if fast.Val != slow.Val {
            // nums[slow] = nums[fast];
            slow.Next = fast
            // slow++;
            slow = slow.Next
        }
        // fast++
        fast = fast.Next
    }
    // 断开与后面重复元素的连接
    slow.Next = nil
    return head
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var deleteDuplicates = function(head) {
    if (head === null) return null;
    let slow = head, fast = head;
    while (fast !== null) {
        if (fast.val !== slow.val) {
            // nums[slow] = nums[fast];
            slow.next = fast;
            // slow++;
            slow = slow.next;
        }
        // fast++
        fast = fast.next;
    }
    // 断开与后面重复元素的连接
    slow.next = null;
    return head;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_remove-duplicates-from-sorted-list" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-duplicates-from-sorted-list"></div></div>
</details><hr /><br />

</div>
</details>
</div>





v></div>
</details><hr /><br />

</div>

</details>
</div>




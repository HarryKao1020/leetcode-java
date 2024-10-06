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

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/array-two-pointers-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

思路和 [26. 删除有序数组中的重复项](/problems/remove-duplicates-from-sorted-array) 完全一样，唯一的区别是把数组赋值操作变成操作指针而已。

![](https://labuladong.online/algo/images/数组去重/2.gif)

- **详细题解**：
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
// 本代码暂未通过力扣的验证，如有错误，请参照我写的 java 代码对比查看。我正在手动验证这部分代码...

class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {  // 删除链表中重复的元素
        if (head == NULL) return NULL;  // 如果链表为空，直接返回NULL
        ListNode *slow = head, *fast = head;  // 定义快慢指针，初始都指向头结点
        while (fast != NULL) {  // 只要快指针没有遍历完整个链表
            if (fast->val != slow->val) {  // 快慢指针值不同
                slow->next = fast;  // 慢指针连接新节点
                slow = slow->next;  // 慢指针向后移动一位
            }
            fast = fast->next;  // 快指针向后移动一位
        }
        slow->next = NULL;  // 断开与后面重复元素的连接
        return head;  // 返回头结点
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码暂未通过力扣的验证，如有错误，请参照我写的 java 代码对比查看。我正在手动验证这部分代码...

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if head == None:
            return None
        slow = head
        fast = head
        while fast != None:
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
    public deleteDuplicates(ListNode head) {
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
// 本代码暂未通过力扣的验证，如有错误，请参照我写的 java 代码对比查看。我正在手动验证这部分代码...

func deleteDuplicates(head *ListNode) *ListNode {
    if head == nil {
        return nil
    }

    slow, fast := head, head
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
// 本代码暂未通过力扣的验证，如有错误，请参照我写的 java 代码对比查看。我正在手动验证这部分代码...

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {
  if (head === null) return null;
  var slow = head;
  var fast = head;
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

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_remove-duplicates-from-sorted-list" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-duplicates-from-sorted-list"></div></div>
</details><hr /><br />

</div>

</details>
</div>


<p>Given the roots of two binary trees <code>p</code> and <code>q</code>, write a function to check if they are the same or not.</p>

<p>Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/20/ex1.jpg" style="width: 622px; height: 182px;" /> 
<pre>
<strong>Input:</strong> p = [1,2,3], q = [1,2,3]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/20/ex2.jpg" style="width: 382px; height: 182px;" /> 
<pre>
<strong>Input:</strong> p = [1,2], q = [1,null,2]
<strong>Output:</strong> false
</pre>

<p><strong class="example">Example 3:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/20/ex3.jpg" style="width: 622px; height: 182px;" /> 
<pre>
<strong>Input:</strong> p = [1,2,1], q = [1,1,2]
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in both trees is in the range <code>[0, 100]</code>.</li> 
 <li><code>-10<sup>4</sup> &lt;= Node.val &lt;= 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Breadth-First Search | Binary Tree</details><br>

<div>👍 11792, 👎 251<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**

<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「分解问题」的思维模式。

判断两棵树是否相同，可以分解为判断根节点是否相同，然后判断左右子树的节点是否都相同。

**详细题解**：
  - [【强化练习】用「分解问题」思维解题 II](https://labuladong.online/algo/problem-set/binary-tree-divide-ii/)

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

// 定义：输入两个根节点，返回以它们为根的两棵二叉树是否相同

class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        // 判断一对节点是否相同
        if (p == nullptr && q == nullptr) {
            return true;
        }
        if (p == nullptr || q == nullptr) {
            return false;
        }
        if (p->val != q->val) {
            return false;
        }
        // 判断其他节点是否相同
        return isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    # 定义：输入两个根节点，返回以它们为根的两棵二叉树是否相同
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        # 判断一对节点是否相同
        if p is None and q is None:
            return True
        if p is None or q is None:
            return False
        if p.val != q.val:
            return False
        # 判断其他节点是否相同
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 定义：输入两个根节点，返回以它们为根的两棵二叉树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 判断一对节点是否相同
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        // 判断其他节点是否相同
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

// 定义：输入两个根节点，返回以它们为根的两棵二叉树是否相同
func isSameTree(p *TreeNode, q *TreeNode) bool {
    // 判断一对节点是否相同
    if p == nil && q == nil {
        return true
    }
    if p == nil || q == nil {
        return false
    }
    if p.Val != q.Val {
        return false
    }
    // 判断其他节点是否相同
    return isSameTree(p.Left, q.Left) && isSameTree(p.Right, q.Right)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var isSameTree = function(p, q) {
    // 定义：输入两个根节点，返回以它们为根的两棵二叉树是否相同
    // 判断一对节点是否相同
    if (p == null && q == null) {
        return true;
    }
    if (p == null || q == null) {
        return false;
    }
    if (p.val != q.val) {
        return false;
    }
    // 判断其他节点是否相同
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_same-tree" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_same-tree"></div></div>
</details><hr /><br />

</div>

</details>
</div>



>


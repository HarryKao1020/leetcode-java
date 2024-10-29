<p>Given the <code>root</code> of a binary tree, return <em>its maximum depth</em>.</p>

<p>A binary tree's <strong>maximum depth</strong>&nbsp;is the number of nodes along the longest path from the root node down to the farthest leaf node.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/26/tmp-tree.jpg" style="width: 400px; height: 277px;" /> 
<pre>
<strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> 3
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [1,null,2]
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Breadth-First Search | Binary Tree</details><br>

<div>👍 13066, 👎 240<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/binary-tree-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

[我的刷题经验总结](https://labuladong.online/algo/essential-technique/algorithm-summary/) 说过，二叉树问题虽然简单，但是暗含了动态规划和回溯算法等高级算法的思想。

下面提供两种思路的解法代码。

**详细题解**：
  - [二叉树系列算法核心纲领](https://labuladong.online/algo/essential-technique/binary-tree-summary/)

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

// **** 解法一，回溯算法思路 ****
class Solution {

public:
    int depth = 0;
    int res = 0;

    int maxDepth(TreeNode* root) {
        traverse(root);
        return res;
    }

    // 遍历二叉树
    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }

        // 前序遍历位置
        depth++;
        // 遍历的过程中记录最大深度
        res = max(res, depth);
        traverse(root->left);
        traverse(root->right);
        // 后序遍历位置
        depth--;
    }
};

// **** 解法二，动态规划思路 ****
class Solution2 {
    // 定义：输入一个节点，返回以该节点为根的二叉树的最大深度
public:
    int maxDepth(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        int leftMax = maxDepth(root->left);
        int rightMax = maxDepth(root->right);
        // 根据左右子树的最大深度推出原二叉树的最大深度
        return 1 + max(leftMax, rightMax);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

# **** 解法一，回溯算法思路 ****
class Solution:
    def __init__(self):
        self.depth = 0
        self.res = 0

    def maxDepth(self, root):
        self.traverse(root)
        return self.res

    # 遍历二叉树
    def traverse(self, root):
        if root is None:
            return

        # 前序遍历位置
        self.depth += 1
        # 遍历的过程中记录最大深度
        self.res = max(self.res, self.depth)
        self.traverse(root.left)
        self.traverse(root.right)
        # 后序遍历位置
        self.depth -= 1

# **** 解法二，动态规划思路 ****
class Solution2:
    # 定义：输入一个节点，返回以该节点为根的二叉树的最大深度
    def maxDepth(self, root):
        if root is None:
            return 0
        leftMax = self.maxDepth(root.left)
        rightMax = self.maxDepth(root.right)
        # 根据左右子树的最大深度推出原二叉树的最大深度
        return 1 + max(leftMax, rightMax)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
// **** 解法一，回溯算法思路 ****
class Solution {

    int depth = 0;
    int res = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    // 遍历二叉树
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 前序遍历位置
        depth++;
        // 遍历的过程中记录最大深度
        res = Math.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        depth--;
    }
}

// **** 解法二，动态规划思路 ****
class Solution2 {
    // 定义：输入一个节点，返回以该节点为根的二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 根据左右子树的最大深度推出原二叉树的最大深度
        return 1 + Math.max(leftMax, rightMax);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

// **** 解法一，回溯算法思路 ****
func maxDepth(root *TreeNode) int {
    var res int
    var depth int
    traverse(root, &depth, &res)
    return res
}

// 遍历二叉树
func traverse(root *TreeNode, depth *int, res *int) {
    if root == nil {
        return
    }

    // 前序遍历位置
    *depth++
    // 遍历的过程中记录最大深度
    if *depth > *res {
        *res = *depth
    }
    traverse(root.Left, depth, res)
    traverse(root.Right, depth, res)
    // 后序遍历位置
    *depth--
}

// **** 解法二，动态规划思路 ****
func maxDepthDP(root *TreeNode) int {
    // 定义：输入一个节点，返回以该节点为根的二叉树的最大深度
    if root == nil {
        return 0
    }
    leftMax := maxDepthDP(root.Left)
    rightMax := maxDepthDP(root.Right)
    // 根据左右子树的最大深度推出原二叉树的最大深度
    return 1 + max(leftMax, rightMax)
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

/**
 * 解法一，回溯算法思路
 */
function maxDepth(root) {
    let depth = 0;
    let res = 0;
    // 遍历二叉树
    function traverse(root) {
        if (root === null) {
        return;
        }

        // 前序遍历位置
        depth++;
        // 遍历的过程中记录最大深度
        res = Math.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        depth--;
    }
    traverse(root);
    return res;
}

/**
 * 解法二，动态规划思路
 */

// 定义：输入一个节点，返回以该节点为根的二叉树的最大深度
function maxDepth2(root) {
    if (root === null) {
        return 0;
    }
    const leftMax = maxDepth2(root.left);
    const rightMax = maxDepth2(root.right);
    // 根据左右子树的最大深度推出原二叉树的最大深度
    return 1 + Math.max(leftMax, rightMax);
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_mydata-maxdepth1" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_mydata-maxdepth1"></div></div>
</details><hr /><br />

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_mydata-maxdepth2" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_mydata-maxdepth2"></div></div>
</details><hr /><br />

</div>

</details>
</div>


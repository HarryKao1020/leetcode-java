<p>Given the <code>root</code> of a binary tree, return <em>the inorder traversal of its nodes' values</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">root = [1,null,2,3]</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">[1,3,2]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/08/29/screenshot-2024-08-29-202743.png" style="width: 200px; height: 264px;" /></p>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">root = [1,2,3,4,5,null,8,null,null,6,7,9]</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">[4,2,6,5,7,1,3,9,8]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/08/29/tree_2.png" style="width: 350px; height: 286px;" /></p>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">root = []</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">[]</span></p>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">root = [1]</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">[1]</span></p>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[0, 100]</code>.</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<p>&nbsp;</p> 
<strong>Follow up:</strong> Recursive solution is trivial, could you do it iteratively?

<details><summary><strong>Related Topics</strong></summary>Stack | Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 13695, 👎 811<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

不要瞧不起二叉树的遍历问题，前文 [我的刷题经验总结](https://labuladong.online/algo/essential-technique/algorithm-summary/) 说过，二叉树的遍历代码是动态规划和回溯算法的祖宗。

动态规划思路的核心在于明确并利用函数的定义分解问题，中序遍历结果的特点是 `root.val` 在中间，左右子树在两侧：

![](https://labuladong.online/algo/images/binary-tree-ii/1.jpeg)

回溯算法的核心很简单，就是 `traverse` 函数遍历二叉树。

本题就分别用两种不同的思路来写代码，注意体会两种思路的区别所在。

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

#include <vector>

// 动态规划思路
// 定义：输入一个节点，返回以该节点为根的二叉树的中序遍历结果
std::vector<int> inorderTraversal(TreeNode* root) {
    std::vector<int> res;
    if (root == nullptr) {
        return res;
    }
    auto leftRes = inorderTraversal(root->left);
    res.insert(res.end(), leftRes.begin(), leftRes.end());
    res.push_back(root->val);
    auto rightRes = inorderTraversal(root->right);
    res.insert(res.end(), rightRes.begin(), rightRes.end());
    return res;
}

// 回溯算法思路
class Solution {
public:
    std::vector<int> res;

    // 返回前序遍历结果
    // Note: Despite the comment saying "preorder", this function actually returns inorder traversal result
    std::vector<int> inorderTraversal(TreeNode* root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历函数
    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        traverse(root->left);
        // 中序遍历位置
        res.push_back(root->val);
        traverse(root->right);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    # 动态规划思路
    # 定义：输入一个节点，返回以该节点为根的二叉树的中序遍历结果
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        if root is None:
            return res
        res.extend(self.inorderTraversal(root.left))
        res.append(root.val)
        res.extend(self.inorderTraversal(root.right))
        return res

    # 回溯算法思路
    res = []

    # 返回前序遍历结果
    def inorderTraversal2(self, root: TreeNode) -> List[int]:
        self.traverse(root)
        return self.res

    # 二叉树遍历函数
    def traverse(self, root: TreeNode):
        if root is None:
            return
        self.traverse(root.left)
        # 中序遍历位置
        self.res.append(root.val)
        self.traverse(root.right)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 动态规划思路
    // 定义：输入一个节点，返回以该节点为根的二叉树的中序遍历结果
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }

    // 回溯算法思路
    LinkedList<Integer> res = new LinkedList<>();

    // 返回前序遍历结果
    public List<Integer> inorderTraversal2(TreeNode root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        // 中序遍历位置
        res.add(root.val);
        traverse(root.right);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

// 动态规划思路
// 定义：输入一个节点，返回以该节点为根的二叉树的中序遍历结果
func inorderTraversal(root *TreeNode) []int {
    var res []int
    if root == nil {
        return res
    }
    res = append(res, inorderTraversal(root.Left)...)
    res = append(res, root.Val)
    res = append(res, inorderTraversal(root.Right)...)
    return res
}

// 回溯算法思路
// 返回前序遍历结果
func inorderTraversal2(root *TreeNode) []int {
    var res []int
    traverse(root, &res)
    return res
}

// 二叉树遍历函数
func traverse(root *TreeNode, res *[]int) {
    if root == nil {
        return
    }
    traverse(root.Left, res)
    // 中序遍历位置
    *res = append(*res, root.Val)
    traverse(root.Right, res)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

// 动态规划思路
// 定义：输入一个节点，返回以该节点为根的二叉树的中序遍历结果
var inorderTraversal = function(root) {
    let res = [];
    if (root === null) {
        return res;
    }
    res = res.concat(inorderTraversal(root.left));
    res.push(root.val);
    res = res.concat(inorderTraversal(root.right));
    return res;
};

// 回溯算法思路
// 返回前序遍历结果
var inorderTraversal2 = function(root) {
    let res = [];
    traverse(root, res);
    return res;
};

// 二叉树遍历函数
var traverse = function(root, res) {
    if (root === null) {
        return;
    }
    traverse(root.left, res);
    // 中序遍历位置
    res.push(root.val);
    traverse(root.right, res);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_binary-tree-inorder-traversal" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_binary-tree-inorder-traversal"></div></div>
</details><hr /><br />

</div>
</details>
</div>




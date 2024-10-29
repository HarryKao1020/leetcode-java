
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int depth = 0;
    int res = 0;

    void traverse(TreeNode root){
        if(root == null) return;
        // 前序走訪
        depth++;
        res = Math.max(res,depth);
        traverse(root.left);
        traverse(root.right);
        // 後序走訪
        depth--;
    }
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

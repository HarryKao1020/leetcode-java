
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
    List<Integer> result = new ArrayList<>();
    TreeNode cur = new TreeNode();
    void traversal(TreeNode node){
       if(node == null){
           return;
       }
       traversal(node.left);
       // 中序遍歷
       result.add(node.val);
       traversal(node.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        traversal(root);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

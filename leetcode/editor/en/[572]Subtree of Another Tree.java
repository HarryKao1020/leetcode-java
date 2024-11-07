
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
    public boolean isSameTree(TreeNode p , TreeNode q){
        // 1.如果都是null 是一樣的
        if(p ==null && q==null){
            return true;
        }

        // 2. 如果有一個為空,或值不相同,則不是相同的樹
        if(p == null || q ==null || p.val != q.val){
            return false;
        }
        // 3. 遞歸比較左右子樹
        return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 1.檢查root跟subRoot是不是完全相同
        if(isSameTree(root,subRoot)) return true;

        // 2.root如果是null , subRoot一定不是子樹
        if(root == null) return false;

        // 遞歸判斷root的子樹有沒有等於subRoot
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

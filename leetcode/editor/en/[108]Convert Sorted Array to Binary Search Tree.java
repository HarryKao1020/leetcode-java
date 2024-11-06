
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
    private TreeNode helper(int[] nums,int left,int right){
        // 基本情況,如果左邊界>右邊界,返回null
        if(left > right){
            return null;
        }

        // 找出中間位置
        int mid  = (left + right)/2;

        // 創建根節點
        TreeNode root = new TreeNode(nums[mid]);

        // 遞迴左子樹
        root.left = helper(nums , left, mid-1);

        // 遞迴右子樹
        root.right = helper(nums, mid+1 , right);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

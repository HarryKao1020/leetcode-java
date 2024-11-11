
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int nums_sum=0;
        int n_sum=0;
        for(int i =0;i<=n;i++){
            n_sum+=i;
        }
        for(int j=0;j<n;j++){
            nums_sum += nums[j];
        }

        return (n_sum-nums_sum);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

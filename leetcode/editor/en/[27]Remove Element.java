
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeElement(int[] nums, int val) {

        int fast = 0, slow =0;

        // fast往前跑,判斷跟val是否相同
        while(fast < nums.length){

            // 判斷不同就可以重寫nums
            if(nums[fast] != val ){
                nums[slow] = nums[fast];
                slow++;
            }

            fast++;
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

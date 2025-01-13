
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        // 設定fast,slow指針, 對應nums的index
        int fast = 0;
        int slow = 0;

        // nums = [0,0,1,1,1,2,2,3,3,4] , length = 10 , index=0~9
        while(fast < nums.length){

            // 如果不同才把nums更新,slow才會往前
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }

            // fast一直往前跑
            fast++;

        }
        // 索引要+1才是長度
        return slow+1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

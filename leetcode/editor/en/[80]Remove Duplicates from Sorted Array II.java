
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        int slow=0 , fast =0; // 快慢指針
        int count = 0; // 記錄一個元素重複的次數


        while (fast < nums.length){
            if(nums[fast] != nums[slow]){
                slow++; // 對nums[0...slow] 來說，nums[fast]是一個新的元素,加進來
                nums[slow] = nums[fast];
            }else if(fast > slow && count < 2){
                slow++; // 此时，对于 nums[0..slow] 来说，nums[fast] 重复次数小于 2，也加进来
                nums[slow] = nums[fast];
            }
            fast++;
            count++;

            // 遇到不同的 count要歸0
            if(fast < nums.length && nums[fast] != nums[fast -1]){
                count = 0;
            }
        }
        // 數組長度索引+1
        return slow+1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

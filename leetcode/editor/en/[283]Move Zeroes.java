
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int snowBallSize = 0;

        for(int i =0;i<nums.length;i++){
            if(nums[i]==0){
                snowBallSize++;
            } else if (snowBallSize>0) {
                int t = nums[i];
                System.out.println("t:"+t);
                nums[i]=0;
                nums[i-snowBallSize]=t;
                System.out.println("i:"+i);
                System.out.println("snowBallSizs:"+snowBallSize);
                System.out.println(nums[i-snowBallSize]);
            }
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)

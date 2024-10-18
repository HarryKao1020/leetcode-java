
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer , Integer> map = new HashMap<>();

        for(int i =0;i< nums.length ;i++){
            int key = target-nums[i];
            if(map.containsKey(key)){
                return new int[]{map.get(key),i};
            }
            map.put(nums[i],i);
        }
        return null;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
nums = [3,2,4], target = 6
6-3 = 3
6-2=4
6-4=2
map=[{3:0},{4:1},{2:2}]


 */
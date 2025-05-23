
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0 , right=0;

        //記錄結果
        int res = 0;

        while(right < s.length()){

//          ex: s="abcabcbb" , c=a
            char c = s.charAt(right);
            right++;
            // 進行窗口內數據的一系列更新 key是一個字母,value是長度
            window.put(c,window.getOrDefault(c,0) +1);

            //判斷左側窗口要不要收縮
            while(window.get(c)>1){
                char d = s.charAt(left);

                // 進行窗口內數據的更新
                window.put(d , window.get(d) -1);
            }
            res = Math.max(res,right-left);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

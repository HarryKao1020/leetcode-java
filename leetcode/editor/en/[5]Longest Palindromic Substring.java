
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        String res = "";

        for(int i = 0; i<s.length() ; i++){
            String s1 = palindrome(s , i ,i); // 奇數的 ,中間起點一樣
            String s2 = palindrome(s , i , i+1); // 偶數的長度，中心有兩個

            res = res.length() > s1.length() ? res : s1; // 如果res長度大於s1 , 返回res 否則反回s1
            res = res.length() > s2.length() ? res : s2; // 如果res長度大於s2,返回res,否則反回s2
        }
        return res;

    }

    String palindrome(String s, int l,int r){
        //防止index越界
        while(l >= 0 && r < s.length() && s.charAt(l)==s.charAt(r)){
            // 往左右展開
            l--;
            r++;
        }
        return s.substring(l+1 ,r);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

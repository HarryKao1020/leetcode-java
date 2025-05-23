
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n+1];
        int i = 2;
        ugly[0] = 1;

        while (i <=n+1) {
            System.out.println("i:"+i);
            if(i % 2 ==0){
                ugly[i-1] = i;
                System.out.println(ugly[i-1]);
            }else if(i % 3 ==0){
                ugly[i-1] = i;
                System.out.println(ugly[i-1]);
            }else if(i % 5 == 0){
                ugly[i-1] =i;
                System.out.println(ugly[i-1]);
            }
            i++;
        }
        return ugly[n-1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

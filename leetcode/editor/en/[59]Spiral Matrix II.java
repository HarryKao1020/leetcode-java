
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int upper_bound = 0,left_bound=0;
        int lower_bound =n-1 , right_bound=n-1;
        int num = 1; // 從1開始到n*n

        while(num <= n*n){
            if(upper_bound <= lower_bound){
                // 從左邊到右邊遍歷upper_bound
                for(int row = left_bound ;row <= right_bound;row++){
                    matrix[upper_bound][row] = num;
                    num++;
                }
                upper_bound++; // 上邊界下移
            }

            if(left_bound <= right_bound){

                for(int col = upper_bound ; col <= lower_bound ; col++){
                    matrix[col][right_bound] = num;
                    num++;
                }
                right_bound--; // 右邊界往左邊移
            }

            if(upper_bound <= lower_bound){
                // 從右邊到左邊遍歷lower_bound
                for(int row = right_bound ;row >= left_bound;row--){
                    matrix[lower_bound][row] = num;
                    num++;
                }
                lower_bound--; // 下邊界上移
            }

            if(left_bound <= right_bound){
                for(int col = lower_bound ; col >= upper_bound ; col--){
                    matrix[col][left_bound] = num;
                    num++;
                }
                left_bound++; // 左邊界往右移
            }
        }
        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

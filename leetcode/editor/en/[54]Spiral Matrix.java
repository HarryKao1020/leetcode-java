
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int upper_bound = 0; //上邊界
        int left_bound = 0; // 左邊界
        int lower_bound = m-1; // 下邊界 : 2
        int right_bound = n-1; // 右邊界: 3
        List<Integer> res = new LinkedList<>();

        // res最後會塞滿m*n個數字 , ex:m*n=12 (m=3 , n=4)
        while(res.size() < m * n){

            if(upper_bound <= lower_bound){ //
                // 從左到右遍歷上邊界
                for(int j = left_bound ; j<= right_bound; j++){
                    res.add(matrix[upper_bound][j]);
                }
                // 上邊界下移
                upper_bound++;
            }


            if(left_bound <= right_bound){ // 定義水平的長度 慢慢縮減(0~3)每個陣列有4個
                // 從上到下遍歷遍歷右邊界
                for(int i = upper_bound ; i <= lower_bound ; i++){
                    res.add(matrix[i][right_bound]);
                }
                // 右邊界左移
                right_bound--;
            }

            if(upper_bound <= lower_bound){
                // 從右到左遍歷下邊界
                for(int j = right_bound; j >= left_bound ; j--){ // j=3 , 3>=0
                    res.add(matrix[lower_bound][j]);// matrix[2][3]
                }
                // 下邊界上移
                lower_bound--;
            }

            if(left_bound <= right_bound){
                // 從下到上遍歷左邊界
                for(int i = lower_bound ; i >= upper_bound ; i--){
                    res.add(matrix[i][left_bound]);
                }
                // 左邊界往右移
                left_bound++;
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

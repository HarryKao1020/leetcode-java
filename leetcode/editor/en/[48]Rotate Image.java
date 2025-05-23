
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        // martix長度
        int martix_len = matrix.length;

        //延對角線做矩陣
        for(int i = 0 ; i < martix_len ; i++){
            for(int j =i ; j < martix_len ; j++){
                int temp = matrix[i][j]; // 1 ,2,3,4,5 ,6,7,8,9//第二圈[1,1] =5
                matrix[i][j] = matrix[j][i]; // [[1,4,7],[2,5,8],[3,6,9]]
                matrix[j][i] = temp; // 互換 // [[1,4,7],[2,],[3]]
            }
        }

        // 翻轉martix所有陣列[[reverse],[reverse],[reverse]]
        for(int[] row:matrix){
           reverse(row);
        }

    }
    void reverse(int[] arr){
        int i = 0 , j = arr.length-1;

        while(j > i){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

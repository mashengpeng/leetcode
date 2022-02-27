package editor.cn;


public class RangeSumQuery2dImmutable{
    public static void main(String[] args) {
        //Solution solution = new RangeSumQuery2dImmutable().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        sum = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = matrix[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];

            }
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];

        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)


}
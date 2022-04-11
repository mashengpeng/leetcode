package editor.cn;
 
import java.util.*; 


public class MaximalRectangle{
    public static void main(String[] args) {
        Solution solution = new MaximalRectangle().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j-1]) + 1;
                }
            }
        }

        int ans = 0;
        for (int j = 0; j < n; j++) {

            int[] down = new int[m];
            int[] top = new int[m];

            Deque<int[]> stack = new ArrayDeque<>();
            stack.addLast(new int[]{-1, -1});
            for (int i = 0; i < m; i++) {

                while (stack.getLast()[0] >= left[i][j]) {
                    stack.pollLast();
                }
                top[i] = stack.getLast()[1];
                stack.addLast(new int[]{left[i][j], i});
            }

            stack.clear();
            stack.addLast(new int[]{-1, m});
            for (int i = m - 1; i >= 0; i--) {

                while (stack.getLast()[0] >= left[i][j]) {
                    stack.pollLast();
                }
                down[i] = stack.getLast()[1];
                stack.addLast(new int[]{left[i][j], i});
            }

            for (int i = 0; i < m; i++) {
                ans = Math.max(ans, left[i][j] * (down[i] - top[i] - 1));
            }


        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

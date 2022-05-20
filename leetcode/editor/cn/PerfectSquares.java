package editor.cn;

import java.util.Arrays;


public class PerfectSquares{
    public static void main(String[] args) {
        Solution solution = new PerfectSquares().new Solution();
        System.out.println(solution.numSquares(12));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {
        int[] f = new int[n+1];
        int INF = 0x3f3f3f3f;
        Arrays.fill(f, INF);
        f[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            for (int j = i*i; j <= n; j++) {
                f[j] = Math.min(f[j], f[j-i*i]+1);
            }
        }
        return f[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

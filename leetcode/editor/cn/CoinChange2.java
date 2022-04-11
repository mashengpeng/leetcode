package editor.cn;
 
import java.util.*; 


public class CoinChange2{
    public static void main(String[] args) {
        Solution solution = new CoinChange2().new Solution();
        solution.change(5, new int[]{1,2,5});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];

        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int j = 0; j < coins.length; j++) {
            for (int i = 1; i <= amount; i++) {
                if(i - coins[j] >= 0){
                    dp[i] += dp[i - coins[j]];
                }
            }
        }
        return dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

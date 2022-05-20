package editor.cn;
 
import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class CoinChange{
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        System.out.println(solution.coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int INF = 0x3f3f3f3f;
        int[] f = new int[amount + 1];

        //f[i][j]代表用到第i个硬币时，凑成j元的最少数量；

        Arrays.fill(f, INF);
        f[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                f[j] = Math.min(f[j - coins[i]] + 1, f[j]);
            }
        }
        return f[amount] == INF ? -1 : f[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;

        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i - coins[j] < 0){
                    break;
                }
                dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    @Test
    public void test(){
        Assert.assertEquals(new CoinChange().new Solution().coinChange(new int[]{1,2,5}, 11), -1);
    }
}

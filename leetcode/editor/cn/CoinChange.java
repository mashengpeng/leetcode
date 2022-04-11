package editor.cn;
 
import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class CoinChange{
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        solution.coinChange(new int[]{1}, 0);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
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

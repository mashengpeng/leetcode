package editor.cn;


public class CountVowelsPermutation{
    public static void main(String[] args) {
        Solution solution = new CountVowelsPermutation().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int countVowelPermutation(int n) {
        int mod = (int)1e9 + 7;
        long res = 0;
        long[][] dp = new long[5][n];

        for(int i = 0; i < 5; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < n; i++){
            dp[0][i] += dp[1][i-1];
            dp[0][i] += dp[2][i-1];
            dp[0][i] += dp[4][i-1];
            dp[0][i] %= mod;

            dp[1][i] += dp[0][i-1];
            dp[1][i] += dp[2][i-1];
            dp[1][i] %= mod;

            dp[2][i] += dp[1][i-1];
            dp[2][i] += dp[3][i-1];
            dp[2][i] %= mod;

            dp[3][i] += dp[2][i-1];
            dp[3][i] %= mod;

            dp[4][i] += dp[2][i-1];
            dp[4][i] += dp[3][i-1];
            dp[4][i] %= mod;
        }

        for(int i = 0; i < 5; i ++){
            res += dp[i][n-1];
        }
        return (int)(res % mod);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
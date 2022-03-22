package editor.cn;


public class DeleteAndEarn{
    public static void main(String[] args) {
        Solution solution = new DeleteAndEarn().new Solution();
        //Solution solution = new Solution();
        System.out.println(solution.deleteAndEarn(new int[]{1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2}));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] dp = new int[3];
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] sum = new int[max+1];

        for (int t : nums) {
            sum[t] += t;
        }


        dp[0] = 0;
        dp[1] = sum[1];

        for (int i = 2; i <= max; i++) {
            dp[i%3] = Math.max(dp[(i-1)%3], dp[(i-2)%3] + sum[i]);
        }

        return dp[max%3];
    }
}

//leetcode submit region end(Prohibit modification and deletion)
}
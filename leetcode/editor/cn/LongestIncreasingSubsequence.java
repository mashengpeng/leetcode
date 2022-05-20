package editor.cn;
 
import java.util.*; 


public class LongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int idx = 0;
        int[] dp = new int[n];

        Arrays.fill(dp, 100000);
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if(nums[i] > dp[idx]){

                dp[++idx] = nums[i];
                continue;
            }

            int left = 0, right = idx;
            while(left < right){
                int mid = (left + right) >> 1;
                if(dp[mid] >= nums[i]){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }
            dp[left] = nums[i];
        }

        return idx+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

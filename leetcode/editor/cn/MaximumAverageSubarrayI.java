package editor.cn;


public class MaximumAverageSubarrayI{
    public static void main(String[] args) {
        Solution solution = new MaximumAverageSubarrayI().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int n = nums.length;
        int cur = 0;

        for (int i = 0; i < k; i++) {
            cur += nums[i];
        }
        int max = cur;
        for (int i = k; i < n; i++) {
            cur = cur + nums[i] - nums[i - k];
            max = Math.max(max, cur);
        }
        return (double) max / k;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
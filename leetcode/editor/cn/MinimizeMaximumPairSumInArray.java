package editor.cn;
 
import java.util.*; 


public class MinimizeMaximumPairSumInArray{
    public static void main(String[] args) {
        Solution solution = new MinimizeMaximumPairSumInArray().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int ans = 0;
        int i = 0, j = nums.length-1;

        while(i < j){
            ans = Math.max(ans, nums[i++] + nums[j--]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
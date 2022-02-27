package editor.cn;


public class OptimalDivision{
    public static void main(String[] args) {
        Solution solution = new OptimalDivision().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int n = nums.length;

        if(n == 1){
            return String.valueOf(nums[0]);
        }
        sb.append(nums[0]);
        sb.append("/");
        if(n > 2){
            sb.append("(");
        }
        for(int i = 1; i < n - 1; i++){
            sb.append(nums[i]);
            sb.append("/");
        }
        sb.append(nums[n - 1]);
        if(n > 2){
            sb.append(")");
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
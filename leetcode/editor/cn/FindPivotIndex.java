package editor.cn;


public class FindPivotIndex{
    public static void main(String[] args) {
        Solution solution = new FindPivotIndex().new Solution();
        System.out.println(solution.pivotIndex(new int[]{2, 1, -1}));
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int all = sum[n - 1];

        for (int i = 0; i < n; i++) {
            if(sum[i] * 2 - nums[i] == all){
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
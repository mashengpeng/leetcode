package editor.cn;


public class LargestNumberAtLeastTwiceOfOthers{
    public static void main(String[] args) {
        Solution solution = new LargestNumberAtLeastTwiceOfOthers().new Solution();
        System.out.println(solution.dominantIndex(new int[]{3,6,1,0}));
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int dominantIndex(int[] nums) {
        int ans = 0;
        boolean flag = true;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] >= 2 * nums[ans]) {
                ans = i;

            }
        }
        for(int num : nums){
            if(num != nums[ans] && num * 2 > nums[ans]){
                return -1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
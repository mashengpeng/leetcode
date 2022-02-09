package editor.cn;
 
import java.util.Arrays;


public class ThreeSumClosest{
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        boolean sign = true;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int left = i + 1, right = nums.length - 1;
            while(left < right){

                int sum = nums[i] + nums[left] + nums[right];

                if(sum == target){
                    return target;
                }else if(sum > target){
                    right--;
                }else{
                    left++;
                }

                if(Math.abs(target - sum) < Math.abs(res)){
                    res = sum - target;
                }


            }
        }

        return target + res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
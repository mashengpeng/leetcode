package editor.cn;

import java.util.Arrays;


public class MaximumElementAfterDecreasingAndRearranging{
    public static void main(String[] args) {
        Solution solution = new MaximumElementAfterDecreasingAndRearranging().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int ans = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > ans){
                ans++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
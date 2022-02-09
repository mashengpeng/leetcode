package editor.cn;
 
import java.util.*; 


public class ContainsDuplicateIi{
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIi().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> s = new HashSet<>();
        int n = k+1;
        for(int i = 0; i < n && i < nums.length; i++){
            if(s.contains(nums[i])){
                return true;
            }else {
                s.add(nums[i]);
            }
        }
        for(int i = n; i < nums.length; i++){
            s.remove(nums[i-n]);
            if(s.contains(nums[i])){
                return true;
            }else {
                s.add(nums[i]);
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
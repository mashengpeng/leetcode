package editor.cn;
 
import java.util.*; 


public class ShuffleAnArray{
    public static void main(String[] args) {
        //Solution solution = new ShuffleAnArray().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[] nums;
    int n;
    public Solution(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        int[] ans = nums.clone();
        Random r = new Random();
        for(int i = 0; i < n; i++){
            swap(ans, i, r.nextInt(n - i) + i);
        }
        return ans;
    }

    void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)


}
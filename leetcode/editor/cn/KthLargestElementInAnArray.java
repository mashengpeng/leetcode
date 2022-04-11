package editor.cn;
 
import java.util.*; 


public class KthLargestElementInAnArray{
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>(k, Comparator.comparingInt(x -> x));

        for (int i = 0; i < nums.length; i++) {
            if(p.size() < k){
                p.add(nums[i]);
                continue;
            }
            if(nums[i] < p.peek()){
                continue;
            }

            p.poll();
            p.add(nums[i]);
        }

        return p.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

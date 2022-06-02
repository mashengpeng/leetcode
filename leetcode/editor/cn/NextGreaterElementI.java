package editor.cn;
 
import java.util.*; 


public class NextGreaterElementI{
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementI().new Solution();
        System.out.println(solution.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2}));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Deque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = n2-1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.getLast() < nums2[i]){
                stack.pollLast();
            }
            if(stack.isEmpty()){
                map.put(nums2[i], -1);
            }else {
                map.put(nums2[i], stack.getLast());
            }
            stack.addLast(nums2[i]);
        }
        int[] ans = new int[n1];
        for (int i = 0; i < n1; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

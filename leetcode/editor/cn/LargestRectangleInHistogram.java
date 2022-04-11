package editor.cn;
 
import java.util.*; 


public class LargestRectangleInHistogram{
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) {
            return 0;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        int ans = 0;

        Deque<int[]> s = new ArrayDeque<>();
        s.addLast(new int[]{-1, -1});
        for (int i = 0; i < n; i++) {
            while(s.getLast()[0] >= heights[i]){
                s.pollLast();
            }
            left[i] = s.getLast()[1];
            s.addLast(new int[]{heights[i], i});
        }

        s.clear();
        s.addLast(new int[]{-1, n});
        for (int i = n - 1; i >= 0; i--) {
            while(s.getLast()[0] >= heights[i]){
                s.pollLast();
            }
            right[i] = s.getLast()[1];
            s.addLast(new int[]{heights[i], i});
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

package editor.cn;
 
import java.util.*;


public class FindRightInterval{
    public static void main(String[] args) {
        Solution solution = new FindRightInterval().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            map.put(intervals[i][0], i);
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int l = i, r = n - 1;
            while(l < r){
                int mid = (l + r) / 2;
                if(intervals[mid][0] >= intervals[i][1]){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }
            if(intervals[l][0] >= intervals[i][1]){
                ans[map.get(intervals[i][0])] = map.get(intervals[l][0]);
            }else{
                ans[map.get(intervals[i][0])] = -1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

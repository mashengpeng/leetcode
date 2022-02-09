package editor.cn;
 
import java.util.*; 


public class MinimumTimeDifference{
    public static void main(String[] args) {
        Solution solution = new MinimumTimeDifference().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinDifference(List<String> timePoints) {

        int res = Integer.MAX_VALUE;
        int[] tmp = new int[timePoints.size()];
        for(int i = 0; i < timePoints.size(); i++){
            String[] x = timePoints.get(i).split(":");
            int x0 = Integer.parseInt(x[0]);
            int x1 = Integer.parseInt(x[1]);

            tmp[i] = x0 * 60 + x1;
        }
        Arrays.sort(tmp);
        for(int i = 1; i < timePoints.size(); i++){
            res = Math.min(res, tmp[i] - tmp[i-1]);
        }
        res = Math.min(res, 60 * 24 + tmp[0] - tmp[tmp.length-1]);
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}
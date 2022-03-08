package editor.cn;


import java.util.Arrays;

public class PlatesBetweenCandles{
    public static void main(String[] args) {
        Solution solution = new PlatesBetweenCandles().new Solution();
        System.out.println(Arrays.toString(solution.platesBetweenCandles("**|**|***|", new int[][]{{2, 5}, {5, 9}})));

    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int[] sum = new int[n];

        int last = -1;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '|'){
                last = i;
            }
            left[i] = last;
        }
        last = n;
        for (int i = n - 1; i >= 0; i--) {
            if(s.charAt(i) == '|'){
                last = i;
            }
            right[i] = last;
        }

        sum[0] = s.charAt(0) == '|' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1];
            if(s.charAt(i) == '|'){
                sum[i]++;
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];

            if(y - x < 2 || left[y] - right[x] < 2){
                ans[i] = 0;
            }else{
                ans[i] = left[y] - right[x] - sum[left[y]] + sum[right[x]];
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
package editor.cn;


public class FindMissingObservations{
    public static void main(String[] args) {
        Solution solution = new FindMissingObservations().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int total = (n + m) * mean;
        int remain = total;
        for (int i = 0; i < m; i++) {
            remain -= rolls[i];
        }
        if(remain / (double)n > 6 || remain / (double)n < 1){
            return new int[]{};
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = remain / n;
        }
        if(remain % n == 0){
            return ans;
        }
        for (int i = 0; i < remain % n; i++) {
            ans[i]++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

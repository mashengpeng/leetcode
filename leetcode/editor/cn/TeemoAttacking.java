package editor.cn;


public class TeemoAttacking{
    public static void main(String[] args) {
        Solution solution = new TeemoAttacking().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(i == 0){
                ans += duration;
            } else if(timeSeries[i] - timeSeries[i - 1] < duration){
                ans += timeSeries[i] - timeSeries[i - 1];
            } else {
                ans += duration;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
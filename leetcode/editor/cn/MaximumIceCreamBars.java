package editor.cn;


import java.util.Arrays;

public class MaximumIceCreamBars{
    public static void main(String[] args) {
        Solution solution = new MaximumIceCreamBars().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        for (int i = 0; i < costs.length; i++) {
            if(coins >= costs[i]){
                ans++;
                coins -= costs[i];
            }else{
                break;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
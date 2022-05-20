package editor.cn;


public class LastStoneWeightIi{
    public static void main(String[] args) {
        Solution solution = new LastStoneWeightIi().new Solution();
        System.out.println(solution.lastStoneWeightII(new int[]{31,26,33,21,40}));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastStoneWeightII(int[] stones) {

        int n = stones.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += stones[i];
        }

        int target = sum / 2 + 1;
        int[] f = new int[target];

        for(int i = 0; i < n; i++){
            for(int j = target - 1; j >= stones[i]; j--){
                f[j] = Math.max(f[j], f[j-stones[i]]+stones[i]);
            }
        }
        return sum - 2 * f[target-1];
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}

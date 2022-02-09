package editor.cn;


public class WGki4K{
    public static void main(String[] args) {
        Solution solution = new WGki4K().new Solution();
        System.out.println(solution.singleNumber(new int[]{0,1,0,1,0,1,100}));
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
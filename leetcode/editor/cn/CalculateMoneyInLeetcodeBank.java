package editor.cn;


public class CalculateMoneyInLeetcodeBank{
    public static void main(String[] args) {
        Solution solution = new CalculateMoneyInLeetcodeBank().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalMoney(int n) {
        int a = n / 7, b = n % 7;
        int ans = 0, k = 1;
        while (a-- > 0) {
            ans += (k + (k + 6)) * 7 / 2;
            k++;
        }
        while (b-- > 0) {
            ans += k++;
        }
        return ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)


}
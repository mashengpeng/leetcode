package editor.cn;


public class ConsecutiveCharacters{
    public static void main(String[] args) {
        Solution solution = new ConsecutiveCharacters().new Solution();
        System.out.println(solution.maxPower("hooraaaaaaaaaaay"));
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxPower(String s) {
        int ans = 1;
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i - 1)){
                cur++;
                ans = Math.max(cur, ans);
            }else{
                cur = 1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
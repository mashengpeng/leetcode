package editor.cn;


public class MaximumNestingDepthOfTheParentheses{
    public static void main(String[] args) {
        Solution solution = new MaximumNestingDepthOfTheParentheses().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int tmp = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                tmp++;
                ans = Math.max(tmp, ans);
            }else if(s.charAt(i) == ')'){
                tmp--;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
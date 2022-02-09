package editor.cn;


public class RemovePalindromicSubsequences{
    public static void main(String[] args) {
        Solution solution = new RemovePalindromicSubsequences().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removePalindromeSub(String s) {
        int i = 0, j = s.length()-1;
        while (i < j){
            if (s.charAt(i++) != s.charAt(j--)){
                return 2;
            }
        }
        return 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
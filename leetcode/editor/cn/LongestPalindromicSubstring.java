package editor.cn;


public class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int max = -1;
        int ansi = -1, ansj = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int left = i - j;
                int right = i + j;
                if(left < 0 || right >= n){
                    break;
                }

                if(s.charAt(left) != s.charAt(right)){
                    break;
                }
                if(right - left > max){
                    max = right - left;
                    ansi = left;
                    ansj = right + 1;
                }
            }
            for(int j = 0; j < n; j++){
                int left = i - j;
                int right = i + 1 + j;
                if(left < 0 || right >= n){
                    break;
                }
                if(s.charAt(left) != s.charAt(right)){
                    break;
                }
                if(right - left > max){
                    max = right - left;
                    ansi = left;
                    ansj = right + 1;
                }
            }
        }
        return s.substring(ansi, ansj);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

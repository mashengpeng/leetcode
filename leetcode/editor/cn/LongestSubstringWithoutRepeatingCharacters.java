package editor.cn;


public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] cnt = new int[128];
        int i = 0, j = 0;
        int ans = 0;
        while(j < n){
            if(++cnt[s.charAt(j)] > 1){
                while(cnt[s.charAt(j)] > 1){
                    cnt[s.charAt(i)]--;
                    i++;
                }
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
